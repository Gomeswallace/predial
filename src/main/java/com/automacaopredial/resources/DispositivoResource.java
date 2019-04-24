package com.automacaopredial.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.dto.DispositivoDTO;
import com.automacaopredial.services.DispositivoService;

@RestController
@RequestMapping(value="/dispositivos")
public class DispositivoResource {
	
	@Autowired
	private DispositivoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Dispositivo> find(@PathVariable Integer id) {
		
		Dispositivo obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
//	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Dispositivo obj){ //converte o obj em json
		obj = service.insert(obj);
		//pega o id do novo recurso criado e add na url
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//retorna a nova url criada
		return ResponseEntity.created(uri).build();		
	}
	
	//@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Dispositivo obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	//@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		
		return ResponseEntity.noContent().build();					
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<DispositivoDTO>> findAll() {
		List<Dispositivo> list = service.findAll();
		List<DispositivoDTO> listDTO = list.stream()
											.map(obj -> new DispositivoDTO(obj)).collect(Collectors.toList());				
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Dispositivo>> findPage(
			 @RequestParam(value="page", defaultValue="0")  Integer page, 
			 @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			 @RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			 @RequestParam(value="direction", defaultValue="ASC") String direction){
		Page<Dispositivo> list = service.findPage(page, linesPerPage, orderBy, direction);
		//lista de dto para o stream converter cada obj em dto pela funcao anonima e depois retornar essa lista
		//Page<DispositivoDTO> listDTO = list.map(obj -> new DispositivoDTO(obj));
		return ResponseEntity.ok().body(list);
	}
}
