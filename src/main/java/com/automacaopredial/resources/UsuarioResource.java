package com.automacaopredial.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Usuario;
import com.automacaopredial.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		
//		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(null);
	}
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<Usuario> find(@RequestParam(value="value") String email) {
//		Usuario obj = service.findByEmail(email);
		return ResponseEntity.ok().body(null);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario obj){ //converte o obj em json
		//obj = service.insert(obj);
		//pega o id do novo recurso criado e add na url
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		//retorna a nova url criada
		return ResponseEntity.created(uri).build();		
	}
	
//	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable Integer id){
		obj.setId(id);
		//obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
//	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		//service.delete(id);
		
		return ResponseEntity.noContent().build();					
	}
	
//	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Ambiente>> findAll() {
		//List<Usuario> list = service.findAll();
		//List<UsuarioDTO> listDTO = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
				
		return ResponseEntity.ok(null);
	}
}
