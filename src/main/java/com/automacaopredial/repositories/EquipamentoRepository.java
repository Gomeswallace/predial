package com.automacaopredial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.automacaopredial.domain.Equipamento;

@Repository
public interface EquipamentoRepository extends JpaRepository<Equipamento, Integer>{

}