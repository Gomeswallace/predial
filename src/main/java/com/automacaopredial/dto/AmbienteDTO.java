package com.automacaopredial.dto;

import java.io.Serializable;

import com.automacaopredial.domain.Ambiente;

public class AmbienteDTO implements Serializable{	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String descricao;
	
	public AmbienteDTO() {
		
	}

	public AmbienteDTO(Ambiente obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
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
}
