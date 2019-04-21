package com.automacaopredial.services;

import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.domain.Usuario;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Dispositivo obj);
	
//	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Usuario cliente, String newPass);
}
