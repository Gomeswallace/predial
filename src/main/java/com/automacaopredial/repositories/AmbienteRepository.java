package com.automacaopredial.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.automacaopredial.domain.Ambiente;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Ambiente obj WHERE obj.dispositivo.id = :dispositivoId ORDER BY obj.id")
	public List<Ambiente> search(@Param("dispositivoId") Integer dispositivo_id);
	//findDistinctByNomeContainingAndDispositivo_IdIn
}