package com.automacaopredial.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.enums.TipoEquipamento;

@RestController
@RequestMapping(value="/equipamentos")
public class EquipamentoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Equipamento> listar() {
		
		Equipamento ep1 = new Equipamento(null,"Equipamento 1", 2, true, TipoEquipamento.LAMPADA);
		Equipamento ep2 = new Equipamento(null,"Equipamento 2", 3, true, TipoEquipamento.LAMPADA);
		
		List<Equipamento> lista = new ArrayList<>();
		lista.add(ep1);
		lista.add(ep2);
		return lista;		
	}
}
