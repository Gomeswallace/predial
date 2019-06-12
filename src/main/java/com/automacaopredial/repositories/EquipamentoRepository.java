package com.automacaopredial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.automacaopredial.domain.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Equipamento obj WHERE obj.ambiente.id = :ambienteId ORDER BY obj.nome")
	public List<Equipamento> search(@Param("ambienteId") Integer ambiente_id);
	//findDistinctByNomeContainingAndDispositivo_IdIn
	
}