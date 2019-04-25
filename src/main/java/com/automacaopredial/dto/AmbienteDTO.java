package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Dispositivo;

public class AmbienteDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, message="O tamanho deve ser mínimo de 5 caracteres.")
	private String nome;
	private String descricao;
	private Dispositivo dispositivo;
	
	public AmbienteDTO() {
		
	}

	public AmbienteDTO(Ambiente obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
		dispositivo = obj.getDispositivo();
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

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}	
}
