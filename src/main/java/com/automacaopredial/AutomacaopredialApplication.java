package com.automacaopredial;

import java.util.Arrays;

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
		
		Dispositivo disp1 = new Dispositivo(null, "Dispositivo 1", "TESTE", TipoDispositivo.ARDUINO_MEGA_2560);
		Dispositivo disp2 = new Dispositivo(null, "Dispositivo 2", "TESTE 2", TipoDispositivo.ARDUINO_LALYPAD);
		
		dispositivoRepository.saveAll(Arrays.asList(disp1, disp2));

		Ambiente amb1 = new Ambiente(null, "Garagem", "Entrada 1", disp1);
		Ambiente amb2 = new Ambiente(null, "Area de serviço", "Lavanderia", disp2);
				
		ambienteRepository.saveAll(Arrays.asList(amb1, amb2));
		
		disp1.getAmbientes().addAll(Arrays.asList(amb1));
		disp2.getAmbientes().addAll(Arrays.asList(amb2));
		
		Equipamento ep1 = new Equipamento(1,"Equipamento 1", 2, true, TipoEquipamento.LAMPADA, amb1);
		Equipamento ep2 = new Equipamento(2,"Equipamento 2", 3, true, TipoEquipamento.RADIO, amb2);				
		
		equipamentoRepository.saveAll(Arrays.asList(ep1, ep2));
				
		amb1.getEquipamentos().addAll(Arrays.asList(ep1));
		amb2.getEquipamentos().addAll(Arrays.asList(ep2));
		
	}	
}
