package com.automacaopredial.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.automacaopredial.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			//funcao do Spring Security que retorna o usuario logado no sistema
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}


}
