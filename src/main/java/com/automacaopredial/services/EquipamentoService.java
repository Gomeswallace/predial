package com.automacaopredial.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.enums.TipoEquipamento;
import com.automacaopredial.dto.EquipamentoDTO;
import com.automacaopredial.dto.EquipamentoNewDTO;
import com.automacaopredial.repositories.EquipamentoRepository;
import com.automacaopredial.services.exceptions.DataIntegrityException;
import com.automacaopredial.services.exceptions.ObjectNotFoundException;

@Service
public class EquipamentoService {
			
	@Autowired //será instancia automaticamente pelo spring pela injecao de depencia ou inversao de controle
	public EquipamentoRepository repo;

	public Equipamento find(Integer id) {
		Optional<Equipamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Equipamento.class.getName(), null));
	}
	
	public Equipamento insert(Equipamento obj) {
		//set id null para garantir uma insercao
		obj.setId(null);		
		return repo.save(obj);
	}
	
	public Equipamento update(Equipamento obj) {
		Equipamento newObj = find(obj.getId()); //verifica se o obj existe antes de tentar atualizar
		updateData(newObj, obj); //Criado o metodo para tratar quais os dados podem ser atualizados
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
	
	public Equipamento fromDTO(EquipamentoDTO objDTO) {
			return new Equipamento(objDTO.getId(), objDTO.getNome(), objDTO.getPorta(), objDTO.isStatus(), TipoEquipamento.toEnum(objDTO.getTipo()),null);
	}
	
	public Equipamento fromDTO(EquipamentoNewDTO objNewDTO) {
		Ambiente amb = new Ambiente(objNewDTO.getAmbienteId(), null, null, null);
		Equipamento equip = new Equipamento(null, objNewDTO.getNome(), objNewDTO.getPorta(),
					objNewDTO.isStatus(), TipoEquipamento.toEnum(objNewDTO.getTipo()), amb);
		return equip;
	}
	
	private void updateData(Equipamento newObj, Equipamento obj) {
		newObj.setNome(obj.getNome());
		newObj.setPorta(obj.getPorta());
		newObj.setStatus(obj.isStatus());
		newObj.setTipo(TipoEquipamento.toEnum(obj.getTipo()));
	}
}