package com.automacaopredial.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {
/*	
	//criar a senha com a palavra embaralhada, do properties
	@Value("${jwt.secret}")
	private String secret;

	//pegar o tempo de expiracao da sessao
	@Value("${jwt.expiration}")
	private Long expiration;
	
	//gera o token para o usuario
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + expiration))
				.signWith(SignatureAlgorithm.HS512, secret.getBytes()) //tipo de algoritmo para assinar o token
				.compact();
	}
	
	public boolean tokenValido(String token) {
		//claims armazena as reinvidicacoes do token
		Claims claims = getClaims(token);
		if (claims != null) {
			String username = claims.getSubject();
			Date expirationDate = claims.getExpiration();
			Date now = new Date(System.currentTimeMillis());
			if (username != null && expirationDate != null && now.before(expirationDate)) {
				return true;
			}
		}
		return false;
	}

	public String getUsername(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}
	
	private Claims getClaims(String token) {
		try {
			//funcao que recupera as reinvidicacao utilizando o token
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
		}
		catch (Exception e) {
			return null;
		}
	}
	*/	
}
