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
	@Query("SELECT eq, am FROM Equipamento eq INNER JOIN eq.ambiente am"
			+ " WHERE am.dispositivo.id = :dispositivoId")
	public List<Equipamento> search(@Param("dispositivoId") Integer dispositivo_id);
	//public List<Equipamento> findDistinctByNomeContainingAndAmbinete_IdIn(Integer id);

	//SELECT c1, c2 FROM Country c1 INNER JOIN c1.neighbors c2
	
	@Transactional(readOnly=true)
	@Query("SELECT obj "
			+ "FROM Equipamento obj "
			+ "INNER JOIN Ambiente AS amb "
			+ "ON amb.id = obj.ambiente "
			+ "INNER JOIN Dispositivo AS disp "  
			+ "ON disp.id = amb.dispositivo "
			+ "INNER JOIN DispositivoTipo AS tipo "		
			+ "ON tipo.id = disp.tipo "
			+ "WHERE obj.ambiente.id = :ambienteId")	
	public List<Object> searchTipo(@Param("ambienteId") Integer ambiente_id);
	//public List<Equipamento> findDistinctByNomeContainingAndAmbinete_IdIn(Integer id);	
}