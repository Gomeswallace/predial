package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.automacaopredial.domain.DispositivoTipo;

public class DispositivoTipoDTO implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, message="O tamanho deve ser mínimo de 5 caracteres.")
	private String nome;
	
	private Integer quantidadePortasAnalog;
	
	private Integer quantidadePortasDig;	
	
	public DispositivoTipoDTO() {
		
	}
	
	public DispositivoTipoDTO(DispositivoTipo obj) {
		id = obj.getId();
		nome = obj.getNome();
		quantidadePortasAnalog = obj.getQuantidadePortasAnalog();
		quantidadePortasDig = obj.getQuantidadePortasAnalog();
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
	public Integer getQuantidadePortasAnalog() {
		return quantidadePortasAnalog;
	}

	public void setQuantidadePortasAnalog(Integer quantidadePortasAnalog) {
		this.quantidadePortasAnalog = quantidadePortasAnalog;
	}

	public Integer getQuantidadePortasDig() {
		return quantidadePortasDig;
	}

	public void setQuantidadePortasDig(Integer quantidadePortasDig) {
		this.quantidadePortasDig = quantidadePortasDig;
	}
}
