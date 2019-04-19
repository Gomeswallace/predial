package com.automacaopredial.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.enums.TipoEquipamento;
import com.automacaopredial.services.EquipamentoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/equipamentos")
public class EquipamentoResource {
	
	@Autowired
	private EquipamentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) throws ObjectNotFoundException {
				
		Equipamento ep1 = new Equipamento(1,"Equipamento 1", 2, true, TipoEquipamento.LAMPADA);
		Equipamento ep2 = new Equipamento(2,"Equipamento 2", 3, true, TipoEquipamento.RADIO);
		
		Equipamento obj = service.find(id);
		return ResponseEntity.ok().body(obj);		
	}
}
