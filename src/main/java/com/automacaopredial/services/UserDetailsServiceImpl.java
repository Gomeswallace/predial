package com.automacaopredial.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automacaopredial.domain.Usuario;
import com.automacaopredial.repositories.UsuarioRepository;

@Service
public class UserDetailsServiceImpl {//implements UserDetailsService {
/*
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario user = repo.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}
		
		//retorna os dados os usuarios 
		return new UserSS(user.getId(), user.getEmail(), user.getSenha(), user.getTipos());
	}
*/
}
