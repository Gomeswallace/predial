package com.automacaopredial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.enums.TipoDispositivo;
import com.automacaopredial.domain.enums.TipoEquipamento;
import com.automacaopredial.repositories.AmbienteRepository;
import com.automacaopredial.repositories.DispositivoRepository;
import com.automacaopredial.repositories.EquipamentoRepository;

@SpringBootApplication
public class AutomacaopredialApplication implements CommandLineRunner {

	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	@Autowired
	private AmbienteRepository ambienteRepository;
	
	@Autowired
	private DispositivoRepository dispositivoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AutomacaopredialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Equipamento ep1 = new Equipamento(1,"Equipamento 1", 2, true, TipoEquipamento.LAMPADA);
		Equipamento ep2 = new Equipamento(2,"Equipamento 2", 3, true, TipoEquipamento.RADIO);		
		
		List<Equipamento> listaEp1 = new ArrayList<>();
		listaEp1.add(ep1);
		
		List<Equipamento> listaEp2 = new ArrayList<>();
		listaEp2.add(ep2);
		
		equipamentoRepository.saveAll(Arrays.asList(ep1, ep2));
		
		Ambiente amb1 = new Ambiente(1, "Garagem", "Entrada 1");
		Ambiente amb2 = new Ambiente(2, "Area de serviço", "Lavanderia");
		
		List<Ambiente> listaAmb1 = new ArrayList<>();
		listaAmb1.add(amb1);
		
		List<Ambiente> listaAmb2 = new ArrayList<>();
		listaAmb2.add(amb2);
		
		amb1.setEquipamento(listaEp1);
		amb2.setEquipamento(listaEp2);
		
		ambienteRepository.saveAll(Arrays.asList(amb1, amb2));
		
		Dispositivo disp1 = new Dispositivo(1, "Dispositivo 1", "TESTE", TipoDispositivo.ARDUINO_MEGA_2560);
		Dispositivo disp2 = new Dispositivo(2, "Dispositivo 2", "TESTE 2", TipoDispositivo.ARDUINO_LALYPAD);
		
		disp1.setAmbientes(listaAmb1);
		disp2.setAmbientes(listaAmb2);
		
		dispositivoRepository.saveAll(Arrays.asList(disp1, disp2));
		
	}

	
}
