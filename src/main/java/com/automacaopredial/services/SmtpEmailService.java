package com.automacaopredial.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.domain.Usuario;

public class SmtpEmailService extends AbstractEmailService{

	@Autowired
	private MailSender mailSender;
	
	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);
	
	@Override
	public void sendEmail(SimpleMailMessage msg) {
		LOG.info("Enviando email...");
		mailSender.send(msg);
		LOG.info("Email enviado");
	}

	@Override
	public void sendOrderConfirmationEmail(Dispositivo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendNewPasswordEmail(Usuario usuario, String newPass) {
		// TODO Auto-generated method stub
		
	}	
}
