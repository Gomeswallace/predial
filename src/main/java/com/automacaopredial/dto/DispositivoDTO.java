package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.automacaopredial.domain.Dispositivo;

public class DispositivoDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, message="O tamanho deve ser mínimo de 5 caracteres.")
	private String nome;
	private String descricao;
	@NotEmpty(message="Preenchimento obrigatório.")
	private Integer tipo;

	public DispositivoDTO() {
		
	}
	
	public DispositivoDTO(Dispositivo obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
		tipo = obj.getTipo();
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}	
}
