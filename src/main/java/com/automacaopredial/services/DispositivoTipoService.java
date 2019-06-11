package com.automacaopredial.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.automacaopredial.domain.DispositivoTipo;
import com.automacaopredial.repositories.DispositivoTipoRepository;
import com.automacaopredial.services.exceptions.ObjectNotFoundException;

@Service
public class DispositivoTipoService {
	
	@Autowired
	private DispositivoTipoRepository repo; 
	
	public DispositivoTipo find(Integer id) {
		Optional<DispositivoTipo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + DispositivoTipo.class.getName(), null));
	}	
		
	public List<DispositivoTipo> findAll(){
		return repo.findAll();
	}
	
	public Page<DispositivoTipo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, 
												 Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public DispositivoTipo toTipo(Integer cod) {
		
		if(cod == null) return null;
		
		List<DispositivoTipo> tipos = new ArrayList<>();
		tipos = findAll();
		for(DispositivoTipo t: tipos) {
			if(cod.equals(t.getId())) {
				return t;
			}
		}	
		throw new IllegalArgumentException("Id inválido: " + cod);
	}	
}
