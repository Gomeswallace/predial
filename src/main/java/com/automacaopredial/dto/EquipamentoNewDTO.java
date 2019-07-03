package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class EquipamentoNewDTO  implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer porta;
	
	@NotNull(message="Preenchimento obrigatório")
	private boolean status;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer tipo;
	
	@NotNull(message="Preenchimento obrigatório")	
	private Integer ambienteId;
	
	public EquipamentoNewDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Integer getIdtipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getAmbienteId() {
		return ambienteId;
	}

	public void setAmbienteId(Integer ambienteId) {
		this.ambienteId = ambienteId;
	}
}

