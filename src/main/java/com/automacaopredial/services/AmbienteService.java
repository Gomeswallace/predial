package com.automacaopredial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.dto.AmbienteDTO;
import com.automacaopredial.dto.AmbienteNewDTO;
import com.automacaopredial.repositories.AmbienteRepository;
import com.automacaopredial.repositories.EquipamentoRepository;
import com.automacaopredial.services.exceptions.DataIntegrityException;
import com.automacaopredial.services.exceptions.ObjectNotFoundException;

@Service
public class AmbienteService {
	
	@Autowired
	public AmbienteRepository repo;
	
	@Autowired
	public EquipamentoRepository equipamentoRepository;
	
	@Autowired
	private DispositivoService dispositivoService;
	
	public Ambiente find(Integer id) {
		Optional<Ambiente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Ambiente.class.getName(), null));
	}
	
	@Transactional
	public Ambiente insert(Ambiente obj) {
		obj.setId(null); //id null para garantir a insercao
		repo.save(obj);
		equipamentoRepository.saveAll(obj.getEquipamentos());
		return obj; 		
	}
	
	public Ambiente update(Ambiente obj) {
		Ambiente newObj = find(obj.getId()); //verifica se o obj existe antes de tentar atualizar		
		updateData(newObj, obj); //Criado o metodo para tratar quais os dados podem ser atualizados		
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {			
			repo.deleteById(id);			
		} catch (DataIntegrityException ex) {
			throw new DataIntegrityException("Não é possível excluir um Ambiente que possui Equipamentos!");
		}
	}
	
	public List<Ambiente> findAll(){
		return repo.findAll();
	}
	
	public Page<Ambiente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
												 Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Ambiente> search(Integer id) {
		return repo.search(id);	  
	}
	
	public Ambiente fromDTO(AmbienteDTO objDTO) {
			return new Ambiente(objDTO.getId(), objDTO.getNome(), objDTO.getDescricao(), null);
	}
	
	public Ambiente fromDTO(AmbienteNewDTO objNewDTO) {
		Dispositivo disp = dispositivoService.find(objNewDTO.getDispositivoId());
		Ambiente amb = new Ambiente(null, objNewDTO.getNome(), objNewDTO.getDescricao(), disp);
		return amb;
	}
	
	private void updateData(Ambiente newObj, Ambiente obj) {
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
		newObj.setEquipamento(obj.getEquipamentos());
	}
}