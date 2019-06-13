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
			
		Usuario user1 = new Usuario(null, "Wallace", "a@g.com", pe.encode("1"));
		user1.addTipoUsuario(TipoUsuario.ADMIN);
		
		Usuario user2 = new Usuario(null, "Maria", "maria@email.com", pe.encode("123"));
		user1.addTipoUsuario(TipoUsuario.CLIENTE);
	
		DispositivoTipo tipoDisp1 = new DispositivoTipo(null, "Arduino Due", 12, 54); 
		DispositivoTipo tipoDisp2 = new DispositivoTipo(null, "Arduino Mega 2560", 16, 54);
		
		Dispositivo disp1 = new Dispositivo(null, "Dispositivo 1", "TESTE", tipoDisp1 );
		Dispositivo disp2 = new Dispositivo(null, "Dispositivo 2", "TESTE 2", tipoDisp2);

		Ambiente amb1 = new Ambiente(null, "Garagem", "Entrada 1", disp1);
		Ambiente amb2 = new Ambiente(null, "DOIS", "Entrada 1", disp1);
		Ambiente amb3 = new Ambiente(null, "TRES", "Entrada 1", disp1);
		Ambiente amb4 = new Ambiente(null, "QUATRO", "Entrada 1", disp1);
		Ambiente amb5 = new Ambiente(null, "CINCO", "Entrada 1", disp1);
		Ambiente amb6 = new Ambiente(null, "SEIS", "Entrada 1", disp1);
		Ambiente amb7 = new Ambiente(null, "SETE", "Entrada 1", disp1);
		Ambiente amb8 = new Ambiente(null, "OITO", "Entrada 1", disp1);
		Ambiente amb9 = new Ambiente(null, "NOVE", "Entrada 1", disp1);
		Ambiente amb10 = new Ambiente(null, "DEZ", "Entrada 1", disp1);
		Ambiente amb11 = new Ambiente(null, "Area de serviço", "Lavanderia", disp2);
		
		disp1.getAmbientes().addAll(Arrays.asList(amb1, amb2, amb3, amb4, amb5, amb6, amb7, amb8, amb9, amb10));
		disp2.getAmbientes().addAll(Arrays.asList(amb11));
		
		Equipamento ep1 = new Equipamento(null,"Equipamento 1", 2, true, TipoEquipamento.LAMPADA, amb1);
		Equipamento ep2 = new Equipamento(null,"Equipamento 2", 3, true, TipoEquipamento.RADIO, amb1);
		Equipamento ep3 = new Equipamento(null, "Equipamento 3", 4, true, TipoEquipamento.RADIO, amb2);
		Equipamento ep4 = new Equipamento(null,"Equipamento 4", 5, true, TipoEquipamento.RADIO, amb3);
						
		amb1.getEquipamentos().addAll(Arrays.asList(ep1, ep2));
		amb2.getEquipamentos().addAll(Arrays.asList(ep3));
		amb3.getEquipamentos().addAll(Arrays.asList(ep4));
		
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		dispositivoTipoRepository.saveAll(Arrays.asList(tipoDisp1, tipoDisp2));		
		dispositivoRepository.saveAll(Arrays.asList(disp1, disp2));
		ambienteRepository.saveAll(Arrays.asList(amb1, amb2));
		equipamentoRepository.saveAll(Arrays.asList(ep1, ep2));	}
}
