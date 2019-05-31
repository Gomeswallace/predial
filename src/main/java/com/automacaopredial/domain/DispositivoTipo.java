package com.automacaopredial.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.automacaopredial.domain.enums.TipoDispositivo;

@Entity
public class DispositivoTipo implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //geracao de chave primaria
	private Integer id;
	private String nome;
	private Integer quantidadePortasAnalog;
	private Integer quantidadePortasDig;
	
	public DispositivoTipo() {		
	}
	
	public DispositivoTipo(Integer id, String nome, Integer quantidadePortasAnalog, Integer quantidadePortasDig) {
		this.id = id;
		this.nome = nome;
		this.quantidadePortasAnalog = quantidadePortasAnalog;
		this.quantidadePortasDig = quantidadePortasDig;
	}

/*

	public enum TipoDispositivo {
		ARDUINO_DUE(0, "Arduino Due", 12, 54),
		ARDUINO_LALYPAD(1, "Arduino Lalypad", 6, 14),
		ARDUINO_LEONARDO_ETHERNET(2, "Arduino Leonado", 7, 20),	
		ARDUINO_MEGA_2560(3, "Arduino Mega 2560", 16, 54),
		ARDUINO_NANO(4, "Arduino Nano", 8, 14),
		ARDUINO_UNO_R3(5, "Placa Uno R3", 6, 14);
*/		
	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidadePortasAnalog() {
		return quantidadePortasAnalog;
	}

	public Integer getQuantidadePortasDig() {
		return quantidadePortasDig;
	}
	
	public static TipoDispositivo toTipo(Integer cod) {
		
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
		DispositivoTipo other = (DispositivoTipo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
