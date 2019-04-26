package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class DispositivoNewDTO implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String descricao;
	
	private Integer tipo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String ambienteNome;
	
	private String ambienteDescricao;

	public DispositivoNewDTO() {
		
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

	public String getAmbienteNome() {
		return ambienteNome;
	}

	public void setAmbienteNome(String ambienteNome) {
		this.ambienteNome = ambienteNome;
	}

	public String getAmbienteDescricao() {
		return ambienteDescricao;
	}

	public void setAmbienteDescricao(String ambienteDescricao) {
		this.ambienteDescricao = ambienteDescricao;
	}	
}
