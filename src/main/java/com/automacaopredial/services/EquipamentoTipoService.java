package com.automacaopredial.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.automacaopredial.domain.EquipamentoTipo;
import com.automacaopredial.repositories.EquipamentoTipoRepository;
import com.automacaopredial.services.exceptions.ObjectNotFoundException;

@Service
public class EquipamentoTipoService {
	
	@Autowired
	private EquipamentoTipoRepository repo; 
	
	public EquipamentoTipo find(Integer id) {
		Optional<EquipamentoTipo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + EquipamentoTipo.class.getName(), null));
	}	
		
	public List<EquipamentoTipo> findAll(){
		return repo.findAll();
	}
	
	public Page<EquipamentoTipo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
												 Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public EquipamentoTipo toTipo(Integer cod) {
		
		if(cod == null) return null;
		
		List<EquipamentoTipo> tipos = new ArrayList<>();
		tipos = findAll();
		for(EquipamentoTipo t: tipos) {
			if(cod.equals(t.getId())) {
				return t;
			}
		}	
		throw new IllegalArgumentException("Id inválido: " + cod);
	}	
}
