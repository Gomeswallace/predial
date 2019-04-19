package com.automacaopredial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.automacaopredial.domain.Equipamento;
import com.automacaopredial.repositories.EquipamentoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EquipamentoService {

	@Autowired //será instancia automaticamente pelo spring pela injecao de depencia ou inversao de controle
	public EquipamentoRepository repo;
	
	public Equipamento find(Integer id) throws ObjectNotFoundException {
		Optional<Equipamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Equipamento.class.getName(), null));
	}
}
