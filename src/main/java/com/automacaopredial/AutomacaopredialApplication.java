package com.automacaopredial;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.enums.TipoEquipamento;
import com.automacaopredial.repositories.EquipamentoRepository;

@SpringBootApplication
public class AutomacaopredialApplication implements CommandLineRunner {

	@Autowired
	private EquipamentoRepository equipamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AutomacaopredialApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Equipamento ep1 = new Equipamento(1,"Equipamento 1", 2, true, TipoEquipamento.LAMPADA);
		Equipamento ep2 = new Equipamento(2,"Equipamento 2", 3, true, TipoEquipamento.RADIO);
		
		equipamentoRepository.saveAll(Arrays.asList(ep1, ep2));
	}

	
}
