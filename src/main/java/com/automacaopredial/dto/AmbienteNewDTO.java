package com.automacaopredial.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AmbienteNewDTO {
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String descricao;
/*
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String equipamentoNome;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer equipamentoPorta;
	
	@NotNull(message="Preenchimento obrigatório")
	private boolean equipamentoStatus;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer equipamentoTipo;
*/	
	@NotNull(message="Preenchimento obrigatório")
	private Integer dispositivoId;
	
	public AmbienteNewDTO() {
		
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
	
	public Integer getDispositivoId() {
		return dispositivoId;
	}

	public void setDispositivoId(Integer dispositivoId) {
		this.dispositivoId = dispositivoId;
	}	
}
