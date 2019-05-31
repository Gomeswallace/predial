package com.automacaopredial.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.domain.DispositivoTipo;
import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.Usuario;
import com.automacaopredial.domain.enums.TipoEquipamento;
import com.automacaopredial.domain.enums.TipoUsuario;
import com.automacaopredial.repositories.AmbienteRepository;
import com.automacaopredial.repositories.DispositivoRepository;
import com.automacaopredial.repositories.DispositivoTipoRepository;
import com.automacaopredial.repositories.EquipamentoRepository;
import com.automacaopredial.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@Autowired
	private AmbienteRepository ambienteRepository;
	
	@Autowired
	private DispositivoRepository dispositivoRepository;
	
	@Autowired
	private DispositivoTipoRepository dispositivoTipoRepository;
	
	public void instantiateTestDataBase() {
			
		Usuario user1 = new Usuario(null, "Wallace", "gomes.wallace10@gmail.com", pe.encode("123"));
		user1.addTipoUsuario(TipoUsuario.ADMIN);
		
		Usuario user2 = new Usuario(null, "Maria", "maria@email.com", pe.encode("123"));
		user1.addTipoUsuario(TipoUsuario.CLIENTE);
	
		DispositivoTipo tipoDisp1 = new DispositivoTipo(null, "Arduino Due", 12, 54); 
		DispositivoTipo tipoDisp2 = new DispositivoTipo(null, "Arduino Mega 2560", 16, 54);
		
		Dispositivo disp1 = new Dispositivo(null, "Dispositivo 1", "TESTE", tipoDisp1);
		Dispositivo disp2 = new Dispositivo(null, "Dispositivo 2", "TESTE 2", tipoDisp2);

		Ambiente amb1 = new Ambiente(null, "Garagem", "Entrada 1", disp1);
		Ambiente amb2 = new Ambiente(null, "Area de serviço", "Lavanderia", disp2);
		
		disp1.getAmbientes().addAll(Arrays.asList(amb1));
		disp2.getAmbientes().addAll(Arrays.asList(amb2));
		
		Equipamento ep1 = new Equipamento(1,"Equipamento 1", 2, true, TipoEquipamento.LAMPADA, amb1);
		Equipamento ep2 = new Equipamento(2,"Equipamento 2", 3, true, TipoEquipamento.RADIO, amb2);				
						
		amb1.getEquipamentos().addAll(Arrays.asList(ep1));
		amb2.getEquipamentos().addAll(Arrays.asList(ep2));
		
		dispositivoTipoRepository.saveAll(Arrays.asList(tipoDisp1, tipoDisp2));
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		dispositivoRepository.saveAll(Arrays.asList(disp1, disp2));
		ambienteRepository.saveAll(Arrays.asList(amb1, amb2));
		equipamentoRepository.saveAll(Arrays.asList(ep1, ep2));	}
}
