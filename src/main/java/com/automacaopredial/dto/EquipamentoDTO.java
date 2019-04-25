package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.automacaopredial.domain.Equipamento;

public class EquipamentoDTO implements Serializable{	
	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, message="O tamanho deve ser mínimo de 5 caracteres.")
	private String nome;
	@NotEmpty(message="Preenchimento obrigatório.")
	private Integer porta;
	@NotEmpty(message="Preenchimento obrigatório.")
	private boolean status;
	@NotEmpty(message="Preenchimento obrigatório.")
	private Integer tipo;
	
	public EquipamentoDTO() {
		
	}

	public EquipamentoDTO(Equipamento obj) {
		id = obj.getId();
		nome = obj.getNome();
		porta = obj.getPorta();
		status = obj.isStatus();
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

}
