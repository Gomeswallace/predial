package com.automacaopredial.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Equipamento obj WHERE obj.ambiente.id = ambiente")
	Page<Equipamento> search(String nome, Optional<Ambiente> dispositivo, Pageable pageRequest);
	//findDistinctByNomeContainingAndDispositivo_IdIn
}