package com.automacaopredial.dto;

import java.io.Serializable;

import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.domain.enums.TipoEquipamento;

public class EquipamentoDTO implements Serializable{	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private Integer porta;
	private boolean status;
	private TipoEquipamento tipo;
	
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

	public TipoEquipamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoEquipamento tipo) {
		this.tipo = tipo;
	}
}
