package com.automacaopredial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.automacaopredial.services.DBService;
import com.automacaopredial.services.EmailService;
import com.automacaopredial.services.MockEmailService;

@Configuration //indica que a classe é de configuração
@Profile("test") //indica o profile (dentro de resources) que este arquivo pertence
public class TestConfig {
	
	@Autowired
	private DBService service;
	
	@Bean
	public boolean instatiateDataBase() {
		
		service.instantiateTestDataBase();		
		return true;
	}


	//@Bean significa que o metodo esta disponivel como componente do sistema
	//Qualquer classe com injecao de dependencia 
	//o Spring procura um componente, que pode ser @Bean que devolve a instancia
	@Bean
	public EmailService emailService() {
		//MockEmailservice chama o servico que grava o e-mail no log
		return new MockEmailService();
	}	
}