package com.automacaopredial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.dto.DispositivoDTO;
import com.automacaopredial.dto.DispositivoNewDTO;
import com.automacaopredial.repositories.DispositivoRepository;
import com.automacaopredial.services.exceptions.DataIntegrityException;
import com.automacaopredial.services.exceptions.ObjectNotFoundException;

@Service
public class DispositivoService {
	
	@Autowired
	private DispositivoRepository repo;
	
	@Autowired
	private DispositivoTipoService dispositivoTipoService; 
	
	@Autowired
	private EmailService emailService; 
	
	public Dispositivo find(Integer id) {
		Optional<Dispositivo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Dispositivo.class.getName(), null));
	}	
	
	@Transactional
	public Dispositivo insert(Dispositivo obj) {
		obj.setId(null); //id null para garantir a insercao		
		repo.save(obj); //utiliza os metodos do spring data
		emailService.sendOrderConfirmationEmail(obj);
		return obj;
	}
	
	public Dispositivo update(Dispositivo obj) {
		Dispositivo newObj = find(obj.getId()); //verifica se o obj existe antes de tentar atualizar
		updateData(newObj, obj); //Criado o metodo para tratar quais os dados podem ser atualizados		
		repo.save(newObj);
		emailService.sendOrderConfirmationEmail(obj);
		return newObj;
	}
	
	public void delete(Integer id) {
		find(id);
		try {			
			repo.deleteById(id);			
		} catch (DataIntegrityException ex) {
			throw new DataIntegrityException("Não é possível excluir um Dispositivo que possui Ambientes!");
		}
	}
	
	public List<Dispositivo> findAll(){
		return repo.findAll();
	}
	
	public Page<Dispositivo> findPage(Integer page, 
									  Integer linesPerPage, 
									  String orderBy, 
									  String direction){
		
		PageRequest pageRequest = PageRequest.of(page, 
												 linesPerPage, 
												 Direction.valueOf(direction), 
												 orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Dispositivo fromDTO(DispositivoDTO objDTO) {
			return new Dispositivo(objDTO.getId(),
								   objDTO.getNome(),
								   objDTO.getDescricao(),
								   null);
	}
	
	public Dispositivo fromDTO(DispositivoNewDTO objnewDTO) {
		Dispositivo disp = new Dispositivo(null, 
										   objnewDTO.getNome(), 
										   objnewDTO.getDescricao(), 
										   dispositivoTipoService.toTipo(objnewDTO.getIdTipo()));
		return disp;
	}	
	
	private void updateData(Dispositivo newObj, Dispositivo obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
	}

	public DispositivoTipoService getDispositivoTipoService() {
		return dispositivoTipoService;
	}

	public void setDispositivoTipoService(DispositivoTipoService dispositivoTipoService) {
		this.dispositivoTipoService = dispositivoTipoService;
	}
}
