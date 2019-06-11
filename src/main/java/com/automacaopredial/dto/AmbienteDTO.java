package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.automacaopredial.domain.Ambiente;

public class AmbienteDTO implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, message="O tamanho deve ser mínimo de 5 caracteres.")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	private String descricao;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer dispositivoId;
	
	public AmbienteDTO() {
		
	}

	public AmbienteDTO(Ambiente obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
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
	
	public Integer getDispositivoId() {
		return dispositivoId;
	}

	public void setDispositivoId(Integer dispositivoId) {
		this.dispositivoId = dispositivoId;
	}
}
