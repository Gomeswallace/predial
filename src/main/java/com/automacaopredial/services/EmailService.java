package com.automacaopredial.services;

import org.springframework.mail.SimpleMailMessage;

import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.domain.Usuario;

//EmailService padrao Strategy
public interface EmailService {
	
	void sendOrderConfirmationEmail(Dispositivo obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuario usuario, String newPass);
	
//	void sendOrderConfirmationHtmlEmail(Dispositivo obj);
	
//	void sendHtmlEmail(MimeMessage msg);
}
