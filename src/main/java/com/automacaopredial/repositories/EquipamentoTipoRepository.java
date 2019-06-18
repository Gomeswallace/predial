package com.automacaopredial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automacaopredial.domain.EquipamentoTipo;

@Repository
public interface EquipamentoTipoRepository extends JpaRepository<EquipamentoTipo, Integer>{
	
}
