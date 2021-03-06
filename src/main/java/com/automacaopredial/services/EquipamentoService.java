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
import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.dto.EquipamentoDTO;
import com.automacaopredial.dto.EquipamentoNewDTO;
import com.automacaopredial.repositories.AmbienteRepository;
import com.automacaopredial.repositories.EquipamentoRepository;
import com.automacaopredial.services.exceptions.DataIntegrityException;
import com.automacaopredial.services.exceptions.ObjectNotFoundException;

@Service
public class EquipamentoService {
			
	@Autowired //será instancia automaticamente pelo spring pela injecao de depencia ou inversao de controle
	public EquipamentoRepository repo;
	
	@Autowired
	public AmbienteRepository ambienteRepository;
	
	@Autowired
	public AmbienteService ambienteService;
	
	@Autowired
	public EquipamentoTipoService equipamentoTipoService;
	
	@Autowired
	public ArduinoService arduinoService;
	
	@Autowired
	public DispositivoService dispositivoService;

	public Equipamento find(Integer id) {
		Optional<Equipamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Equipamento.class.getName(), null));
	}
	
	@Transactional
	public Equipamento insert(Equipamento obj) {
		//set id null para garantir uma insercao
		obj.setId(null);		
		return repo.save(obj);
	}
	
	public Equipamento update(Equipamento obj) throws Exception {
		Equipamento newObj = find(obj.getId()); //verifica se o obj existe antes de tentar atualizar
		updateData(newObj, obj); //Criado o metodo para tratar quais os dados podem ser atualizados
		
//		String porta = String.valueOf(newObj.getPorta());
//		String status = String.valueOf(newObj.getStatus());
		
		arduinoService.sendGet(newObj);
		
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);;
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Erro ao excluir o equipamento com o id: " + id);
		}
	}
	
	public List<Equipamento> findAll() {
		return repo.findAll();
	}
	
	public Page<Equipamento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
												 Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public List<Equipamento> search(Integer id) {		
		return repo.search(id);	
	}
	
	public Integer findPortas(Integer id) {
		Dispositivo dispositivo = dispositivoService.find(id);
		Integer qtdadePortas = dispositivo.getTipo().getQuantidadePortasDig();
		
		return qtdadePortas;	
	}
	
	public Equipamento fromDTO(EquipamentoDTO objDTO) {
			return new Equipamento(objDTO.getId(), 
								   objDTO.getNome(), 
								   objDTO.getPorta(), 
								   objDTO.isStatus(), 
								   objDTO.getTipo(),
								   null);
	}
	
	public Equipamento fromDTO(EquipamentoNewDTO objNewDTO) {
		Ambiente amb = ambienteService.find(objNewDTO.getAmbienteId());
		Equipamento equip = new Equipamento(null, 
											objNewDTO.getNome(), 
											objNewDTO.getPorta(),
											objNewDTO.isStatus(), 
											equipamentoTipoService.toTipo(objNewDTO.getIdtipo()),											
											amb);
		return equip;
	}
	
	private void updateData(Equipamento newObj, Equipamento obj) {
		newObj.setNome(obj.getNome());
		newObj.setPorta(obj.getPorta());
		newObj.setStatus(obj.getStatus());
		newObj.setTipo(obj.getTipo());
	}
}