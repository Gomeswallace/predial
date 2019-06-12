package com.automacaopredial.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.dto.EquipamentoDTO;
import com.automacaopredial.dto.EquipamentoNewDTO;
import com.automacaopredial.services.EquipamentoService;

@RestController
@RequestMapping(value="/equipamentos")
public class EquipamentoResource {
	
	@Autowired //instanciar o objeto automaticamente
	private EquipamentoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Equipamento> find(@PathVariable Integer id) {
		Equipamento obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	//mapear o metodo no endpoin equipamentos como POST 
	@RequestMapping(method = RequestMethod.POST) //@RequestBody permite que o obj seja construido a partir do json enviado 	
	public ResponseEntity<Void> insert(@Valid @RequestBody EquipamentoNewDTO objNewDTO){
		Equipamento obj = service.fromDTO(objNewDTO);				
		//ver http status code
		obj = service.insert(obj); 
		//o http tem seus codigos de retorno apos realizar a operacao
		//fromCurrentRequest pega a uri que foi utilizada para inserir e add o id
		//buildAndExpand pega o id do obj que foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value= "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> Update(@Valid @RequestBody EquipamentoNewDTO objNewDTO, @PathVariable Integer id) {
		Equipamento obj = service.fromDTO(objNewDTO);
		obj.setId(id);
		obj = service.update(obj);
		//noContent conteudo vazio
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EquipamentoDTO>> findAll(){
		List<Equipamento> list = service.findAll();
		//lista de dto para o stream converter cada obj em dto pela funcao anonima e depois retornar essa lista
		List<EquipamentoDTO> listDTO = list.stream().map(obj -> new EquipamentoDTO(obj))
											.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<List<EquipamentoDTO>> findPage(
			//requestParam informa que o parametro é opcional
			// @RequestParam(value="nome", defaultValue="") String nome,
			 @RequestParam(value="ambiente", defaultValue="") String ambiente)
			//@RequestParam(value="page", defaultValue="0")  Integer page, 
			//@RequestParam(value="linesPerPage", defaultValue="4") Integer linesPerPage, 
			//@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			//@RequestParam(value="direction", defaultValue="ASC") String direction)
	{
		//String nomeDecoded = URL.decodeParam(nome);
		//List<Integer> ids = URL.decodeIntList(dispositivos);
		Integer id = Integer.parseInt(ambiente);
		List<Equipamento> list = service.search(id);
		List<EquipamentoDTO> listDTO = list.stream().map(obj -> new EquipamentoDTO(obj)).collect(Collectors.toList());
		
		//Page<Equipamento> list = service.findPage(page, linesPerPage, orderBy, direction);
		//lista de dto para o stream converter cada obj em dto pela funcao anonima e depois retornar essa lista
		//Page<EquipamentoDTO> listDTO = list.map(obj -> new EquipamentoDTO(obj));
		return ResponseEntity.ok().body(listDTO);
	}
}
