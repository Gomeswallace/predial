package com.automacaopredial.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.automacaopredial.domain.Ambiente;
import com.automacaopredial.domain.Dispositivo;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Ambiente obj WHERE obj.dispositivo.id = dispositivo")
	Page<Ambiente> search(String nome, Optional<Dispositivo> dispositivo, Pageable pageRequest);
	//findDistinctByNomeContainingAndDispositivo_IdIn
}
