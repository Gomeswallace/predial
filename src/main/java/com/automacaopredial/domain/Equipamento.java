package com.automacaopredial.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipamento implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //geracao de chave primaria
	private Integer id;
	private String nome;
	private Integer porta;
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "equipamentoTipo_id")
	private EquipamentoTipo tipo;
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "ambiente_id")
	private Ambiente ambiente;
	
	public Equipamento() {		
	}

	public Equipamento(Integer id, String nome, Integer porta, boolean status, EquipamentoTipo tipoEquipamento, Ambiente ambiente) {
		this.id = id;
		this.nome = nome;
		this.porta = porta;
		this.status = status;
		this.tipo = tipoEquipamento;
		this.ambiente = ambiente;
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
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Integer getPorta() {
		return porta;
	}

	public void setPorta(Integer porta) {
		this.porta = porta;
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

	//hashCode e Equals para comparar o objeto pelo conteudo e nao pela referencia
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipamento other = (Equipamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
