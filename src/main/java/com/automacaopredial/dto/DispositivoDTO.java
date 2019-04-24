package com.automacaopredial.dto;

import java.io.Serializable;

import com.automacaopredial.domain.Dispositivo;

public class DispositivoDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descricao;
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
