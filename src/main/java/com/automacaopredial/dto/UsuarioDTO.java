package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.automacaopredial.domain.Usuario;
import com.automacaopredial.domain.enums.TipoUsuario;
import com.automacaopredial.services.validation.UsuarioUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;

@UsuarioUpdate
public class UsuarioDTO implements Serializable{	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, message="O tamanho deve ser mínimo de 5 caracteres.")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Email(message="E-mail invalido.")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	private String senha;
	
	private TipoUsuario tipoUsuario; 
	
	public UsuarioDTO(Usuario obj) {
		this.id=obj.getId();
		this.nome=obj.getNome();
		this.email=obj.getEmail();
		//this.tipoUsuario= obj.getTipos();
		this.senha = obj.getSenha();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
