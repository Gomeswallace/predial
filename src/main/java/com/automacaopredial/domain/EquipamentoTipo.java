package com.automacaopredial.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.automacaopredial.domain.enums.TipoEquipamento;

@Entity
public class EquipamentoTipo implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //geracao de chave primaria
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy = "tipo")
	private List<Equipamento> equipamentos = new ArrayList<>();
	
	public EquipamentoTipo() {		
	}
	
	public EquipamentoTipo(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public static TipoEquipamento toTipo(Integer cod) {
		
		if(cod == null) return null;
		
/*		for(DispositivoTipo t: DispositivoTipo.values()) {
			if(cod.equals(t.getId())) {
				return t;
			}
		}	
*/		throw new IllegalArgumentException("Id inválido: " + cod);
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
		EquipamentoTipo other = (EquipamentoTipo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
