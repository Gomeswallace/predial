package com.automacaopredial.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserSS {//implements UserDetails {
/*	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UserSS() {
	}
	
	public UserSS(Integer id, String email, String senha, Set<TipoUsuario> tipos) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		
		//converte a descricao do Enum para o tipo authorities do spring 
		this.authorities = tipos.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public boolean hasRole(TipoUsuario perfil) {
		//converte o tipo recebido em granted e verifica se contem na lista de authorities
		return getAuthorities().contains(new SimpleGrantedAuthority(perfil.getDescricao()));
	}
	*/
}
