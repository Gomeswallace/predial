package com.automacaopredial.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automacaopredial.domain.Usuario;
import com.automacaopredial.domain.enums.TipoUsuario;
import com.automacaopredial.repositories.AmbienteRepository;
import com.automacaopredial.repositories.EquipamentoRepository;
import com.automacaopredial.repositories.UsuarioRepository;

@Service
public class DBService {
	
//	@Autowired
//	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@Autowired
	private AmbienteRepository ambienteRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void instantiateTestDataBase() {
	
//		Usuario user1 = new Usuario(null, "Wallace", "gomes.wallace@email.com", pe.encode("123"));
//		user1.addTipoUsuario(TipoUsuario.ADMINISTRADOR);
//		user1.getTelefones().addAll(Arrays.asList("9999-9999"));
		
//		Usuario user2 = new Usuario(null, "Maria", "maria@email.com", pe.encode("1234"));
//		user1.addTipoUsuario(TipoUsuario.CLIENTE);
//		user2.getTelefones().addAll(Arrays.asList("1111-9999"));
		
		
//		Equipamento ep1 = new Equipamento(null, "Lampada", 1, true, TipoEquipamento.LAMPADA );
//		Equipamento ep2 = new Equipamento(null, "Tomada Luz", 2, false, TipoEquipamento.TOMADA);
		
//		Ambiente amb1 = new Ambiente(null, "Sala TV", "Sala embaixo");
//		Ambiente amb2 = new Ambiente(null, "Garagem", "Sala embaixo");
		
//		ep1.getAmbientes().addAll(Arrays.asList(amb1));
//		ep2.getAmbientes().addAll(Arrays.asList(amb2));
		
//		amb1.getEquipamentos().addAll(Arrays.asList(ep1));
//		amb2.getEquipamentos().addAll(Arrays.asList(ep2));
		
//		usuarioRepository.saveAll(Arrays.asList(user1, user2));
//		equipamentoRepository.saveAll(Arrays.asList(ep1, ep2));
//		ambienteRepository.saveAll(Arrays.asList(amb1,amb2));
		
	}
}
