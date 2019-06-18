package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.EquipamentoTipo;

public class EquipamentoDTO implements Serializable{	
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, message="O tamanho deve ser mínimo de 5 caracteres.")
	private String nome;
	
	@NotNull(message="Preenchimento obrigatório.")
	private Integer porta;
	
	@NotNull(message="Preenchimento obrigatório.")
	private boolean status;
	
	@NotNull(message="Preenchimento obrigatório.")
	private EquipamentoTipo tipo;
	
	@NotNull(message="Preenchimento obrigatório.")
	private Ambiente ambiente;
	
	public EquipamentoDTO() {
		
	}

	public EquipamentoDTO(Equipamento obj) {
		id = obj.getId();
		nome = obj.getNome();
		porta = obj.getPorta();
		status = obj.isStatus();
		tipo = obj.getTipo();
		ambiente = obj.getAmbiente();
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

	public EquipamentoTipo getTipo() {
		return tipo;
	}

	public void setTipo(EquipamentoTipo tipo) {
		this.tipo = tipo;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}
}
