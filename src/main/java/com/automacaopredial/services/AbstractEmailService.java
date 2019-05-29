package com.automacaopredial.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.domain.Usuario;

public abstract class AbstractEmailService implements EmailService {

	//pega o valor contindo no parametro e add na variavel. Neste caso vem do properties
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	//@Autowired
	//private JavaMailSender javaMailSender; 
	
	@Override
	public void sendOrderConfirmationEmail(Dispositivo obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromDispositivo(obj);
		sendEmail(sm); //template method
	}
	
	protected SimpleMailMessage prepareSimpleMailMessageFromDispositivo(Dispositivo obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		//sm.setTo(obj.getUsuario().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Novo dispositivo cadastrado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	@Override
	public void sendNewPasswordEmail(Usuario usuario, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(usuario, newPass);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareNewPasswordEmail(Usuario usuario, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(usuario.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova senha: " + newPass);
		return sm;
	}
	
	protected String htmlFromTemplateDispositivo(Dispositivo obj) {
		Context context = new Context();
		context.setVariable("dispositio", obj);
		return templateEngine.process("email/InsercaoDispositivo", context);		
	}
/*	
	@Override
	public void sendOrderConfirmationHtmlEmail(Dispositivo obj) {
		try {
		MimeMessage mm = prepareMimeMessageFromDispositivo(obj);
		sendHtmlEmail(mm); //template method
		}
		catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}

	protected MimeMessage prepareMimeMessageFromDispositivo(Dispositivo obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper  mmh = new MimeMessageHelper(mimeMessage, true);
		//mmh.setTo(obj.getNome());
		mmh.setFrom(sender);
		mmh.setSubject("Dispositivo adicionado: " + obj.getId() + " - " + obj.getNome());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateDispositivo(obj), true);
		return mimeMessage;
	}
	*/
}
