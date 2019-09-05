package com.automacaopredial.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.domain.DispositivoTipo;
import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.EquipamentoTipo;
import com.automacaopredial.domain.Usuario;
import com.automacaopredial.domain.enums.TipoUsuario;
import com.automacaopredial.repositories.AmbienteRepository;
import com.automacaopredial.repositories.DispositivoRepository;
import com.automacaopredial.repositories.DispositivoTipoRepository;
import com.automacaopredial.repositories.EquipamentoRepository;
import com.automacaopredial.repositories.EquipamentoTipoRepository;
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
	
	@Autowired
	private EquipamentoTipoRepository equipamentoTipoRepository;
	
	public void instantiateTestDataBase() {
			
		Usuario user1 = new Usuario(null, "Wallace", "a", pe.encode("1"));
		user1.addTipoUsuario(TipoUsuario.ADMIN);
		
		Usuario user2 = new Usuario(null, "Maria", "maria@email.com", pe.encode("123"));
		user1.addTipoUsuario(TipoUsuario.CLIENTE);
	
		DispositivoTipo tipoDisp1 = new DispositivoTipo(null, "Arduino Due", 12, 54); 
		DispositivoTipo tipoDisp2 = new DispositivoTipo(null, "Arduino Mega 2560", 16, 54);
		
		Dispositivo disp1 = new Dispositivo(null, "Dispositivo Due", "1 Andar", tipoDisp1 );
		Dispositivo disp2 = new Dispositivo(null, "Dispositivo Mega", "2 Andar", tipoDisp2);

		Ambiente amb1 = new Ambiente(null, "Garagem", "Subsolo", disp1);
		Ambiente amb2 = new Ambiente(null, "Area de serviço", "Lavanderia", disp1);
		Ambiente amb3 = new Ambiente(null, "TRES", "Entrada 3", disp1);
		Ambiente amb4 = new Ambiente(null, "QUATRO", "Entrada 4", disp1);
		Ambiente amb5 = new Ambiente(null, "CINCO", "Entrada 5", disp1);
		Ambiente amb6 = new Ambiente(null, "SEIS", "Entrada 6", disp1);
		Ambiente amb7 = new Ambiente(null, "SETE", "Entrada 7", disp1);
		Ambiente amb8 = new Ambiente(null, "OITO", "Entrada 8", disp1);
		Ambiente amb9 = new Ambiente(null, "NOVE", "Entrada 9", disp1);
		Ambiente amb10 = new Ambiente(null, "DEZ", "Entrada 10", disp1);
		Ambiente amb11 = new Ambiente(null, "Area de serviço", "Lavanderia", disp2);
		
		disp1.getAmbientes().addAll(Arrays.asList(amb1, amb2, amb3, amb4, amb5, amb6, amb7, amb8, amb9, amb10));
		disp2.getAmbientes().addAll(Arrays.asList(amb11));
		
		EquipamentoTipo eTipo1 = new EquipamentoTipo(null, "Tomada");
		EquipamentoTipo eTipo2 = new EquipamentoTipo(null, "Lampada");
		EquipamentoTipo eTipo3 = new EquipamentoTipo(null, "Televisão");
		EquipamentoTipo eTipo4 = new EquipamentoTipo(null, "Radio");
		EquipamentoTipo eTipo5 = new EquipamentoTipo(null, "Ventilador");
		
		Equipamento ep1 = new Equipamento(null,"Equipamento 1", 6, true, eTipo1, amb1);
		Equipamento ep2 = new Equipamento(null,"Equipamento 2", 3, true, eTipo2, amb1);
		Equipamento ep3 = new Equipamento(null, "Equipamento 3", 4, true, eTipo3, amb2);
		Equipamento ep4 = new Equipamento(null,"Equipamento 4", 5, true, eTipo4, amb3);
		Equipamento ep5 = new Equipamento(null,"Equipamento 5", 7, true, eTipo5, amb3);
		
		amb1.getEquipamentos().addAll(Arrays.asList(ep1, ep2));
		amb2.getEquipamentos().addAll(Arrays.asList(ep3));
		amb3.getEquipamentos().addAll(Arrays.asList(ep4, ep5));
		
		usuarioRepository.saveAll(Arrays.asList(user1, user2));
		dispositivoTipoRepository.saveAll(Arrays.asList(tipoDisp1, tipoDisp2));		
		dispositivoRepository.saveAll(Arrays.asList(disp1, disp2));
		ambienteRepository.saveAll(Arrays.asList(amb1, amb2, amb3, amb4, amb5, amb6, amb7, amb8, amb9, amb10));
		equipamentoTipoRepository.saveAll(Arrays.asList(eTipo1, eTipo2, eTipo3, eTipo4, eTipo5));
		equipamentoRepository.saveAll(Arrays.asList(ep1, ep2, ep3, ep4));	}
}
