package com.automacaopredial.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.automacaopredial.services.DBService;
import com.automacaopredial.services.EmailService;
import com.automacaopredial.services.SmtpEmailService;

@Configuration //indica que a classe é de configuração
@Profile("dev") //indica o profile (dentro de resources) que este arquivo pertence
public class DevConfig {
	
	@Autowired
	private DBService service;
	
	@Value("${spring.jpa.hibernate.ddl-auto}") //pega o valor da chave e salva na variavel
	private String strategy;
	
	@Bean
	public boolean instatiateDataBase() {
		
		if(!"create".equals(strategy)) {
			return false;
		} 
		
		service.instantiateTestDataBase();		
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}