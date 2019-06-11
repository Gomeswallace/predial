package com.automacaopredial.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Dispositivo implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //geracao de chave primaria
	private Integer id;
	private String nome;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "dispositivoTipo_id")
	private DispositivoTipo tipo;
	
	@OneToMany(mappedBy = "dispositivo")
	private List<Ambiente> ambientes = new ArrayList<>(); 
	
	public Dispositivo() {		
	}
	
	public Dispositivo(Integer id, String nome, String descricao, DispositivoTipo tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.tipo = tipo;
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
	
	public DispositivoTipo getTipo() {
		return tipo;
	}

	public void setTipo(DispositivoTipo tipo) {
		this.tipo = tipo;
	}
	
	public List<Ambiente> getAmbientes() {
		return ambientes;
	}

	public void setAmbientes(List<Ambiente> ambientes) {
		this.ambientes = ambientes;
	}

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
		Dispositivo other = (Dispositivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dispositivo [nome=");
		builder.append(nome);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append("]");
		return builder.toString();
	}
}
