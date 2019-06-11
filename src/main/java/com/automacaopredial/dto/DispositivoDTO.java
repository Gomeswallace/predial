package com.automacaopredial.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.automacaopredial.domain.Dispositivo;
import com.automacaopredial.domain.DispositivoTipo;

public class DispositivoDTO implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, message="O tamanho deve ser mínimo de 5 caracteres.")
	private String nome;
	private String descricao;
	private DispositivoTipo dispositivoTipo;
	
	public DispositivoDTO() {
		
	}
	
	public DispositivoDTO(Dispositivo obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
		dispositivoTipo = obj.getTipo();
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

	public DispositivoTipo getDispositivoTipo() {
		return dispositivoTipo;
	}

	public void setDispositivoTipo(DispositivoTipo dispositivoTipo) {
		this.dispositivoTipo = dispositivoTipo;
	}
}
