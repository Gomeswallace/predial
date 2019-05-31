package com.automacaopredial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automacaopredial.domain.DispositivoTipo;

@Repository
public interface DispositivoTipoRepository extends JpaRepository<DispositivoTipo, Integer>{
	
}
