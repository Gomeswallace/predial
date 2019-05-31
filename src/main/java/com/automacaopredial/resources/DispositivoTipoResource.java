package com.automacaopredial.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.automacaopredial.domain.DispositivoTipo;
import com.automacaopredial.services.DispositivoTipoService;

@RestController
@RequestMapping(value="/tiposdispositivos")
public class DispositivoTipoResource {
	
	@Autowired
	private DispositivoTipoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<DispositivoTipo> find(@PathVariable Integer id) {	
		DispositivoTipo obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<DispositivoTipo>> findAll() {
		List<DispositivoTipo> list = service.findAll();				
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<DispositivoTipo>> findPage(
			 @RequestParam(value="page", defaultValue="0")  Integer page, 
			 @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			 @RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			 @RequestParam(value="direction", defaultValue="ASC") String direction){
		Page<DispositivoTipo> list = service.findPage(page, linesPerPage, orderBy, direction);
		//lista de dto para o stream converter cada obj em dto pela funcao anonima e depois retornar essa lista
		//Page<DispositivoDTO> listDTO = list.map(obj -> new DispositivoDTO(obj));
		return ResponseEntity.ok().body(list);
	}
}
