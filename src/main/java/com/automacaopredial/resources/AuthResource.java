package com.automacaopredial.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.automacaopredial.security.JWTUtil;
import com.automacaopredial.security.UserSS;
import com.automacaopredial.services.AuthService;
import com.automacaopredial.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private AuthService service;
	
	//metodo protegido por autorizao, precisa logar 
	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		//pega usuario logago
		UserSS user = UserService.authenticated();
		//gera um novo token com a data atual
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");

		//retorna o objeto com a autorizacao e com o token
		return ResponseEntity.noContent().build();
	}
	
//	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
//	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
//		service.sendNewPassword(objDto.getEmail());
//		return ResponseEntity.noContent().build();
//	}
}
