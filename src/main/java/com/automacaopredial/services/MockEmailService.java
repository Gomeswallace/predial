package com.automacaopredial.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import com.automacaopredial.domain.Usuario;

public class MockEmailService extends AbstractEmailService{

	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {		
		LOG.info("Simulando o envio de e-mail...");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado com sucesso!!!");
	}

	@Override
	public void sendNewPasswordEmail(Usuario usuario, String newPass) {
		
		LOG.info("Simulando o envio de e-mail com alteração da senha...");
		LOG.info("Usuário: ");
		LOG.info(usuario.getId() + usuario.getNome());
		LOG.info("Alterou sua senha. Nova senha: ");
		LOG.info(newPass);
		LOG.info("E-mail enviado com sucesso!!!");		
	}
/*
	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando o envio de e-mail HTML...");
		LOG.info(msg.toString());
		LOG.info("E-mail enviado com sucesso!!!");
		
	}
*/
}
