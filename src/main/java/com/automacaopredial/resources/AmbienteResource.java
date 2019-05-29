package com.automacaopredial.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.dto.AmbienteDTO;
import com.automacaopredial.dto.AmbienteNewDTO;
import com.automacaopredial.resources.utils.URL;
import com.automacaopredial.services.AmbienteService;

@RestController
@RequestMapping(value="/ambientes")
public class AmbienteResource {
	
	@Autowired
	private AmbienteService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Ambiente> find(@PathVariable Integer id) {
		
		Ambiente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AmbienteNewDTO objNewDTO){ //converte o obj em json
		Ambiente obj = service.fromDTO(objNewDTO); 
		obj = service.insert(obj);
		//pega o id do novo recurso criado e add na url
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//retorna a nova url criada
		return ResponseEntity.created(uri).build();		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AmbienteDTO objDTO, @PathVariable Integer id){
		Ambiente obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);		
		return ResponseEntity.noContent().build();					
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<AmbienteDTO>> findAll() {
		List<Ambiente> list = service.findAll();
		List<AmbienteDTO> listDTO = list.stream()
									.map(obj -> new AmbienteDTO(obj)).collect(Collectors.toList());
				
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<AmbienteDTO>> findPage(
			 @RequestParam(value="nome", defaultValue="") String nome,
			 @RequestParam(value="dispositivo", defaultValue="") String dispositivo,
			 @RequestParam(value="page", defaultValue="0")  Integer page, 
			 @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			 @RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			 @RequestParam(value="direction", defaultValue="ASC") String direction){
		String nomeDecoded = URL.decodeParam(nome);
		//List<Integer> ids = URL.decodeIntList(dispositivos);
		Integer id = Integer.parseInt(dispositivo);
		Page<Ambiente> list = service.search(nomeDecoded, id, page, linesPerPage, orderBy, direction);
		Page<AmbienteDTO> listDto = list.map(obj -> new AmbienteDTO(obj));
		//lista de dto para o stream converter cada obj em dto pela funcao anonima e depois retornar essa lista
		//Page<Ambiente> listDTO = list.map(obj -> new Ambiente(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
