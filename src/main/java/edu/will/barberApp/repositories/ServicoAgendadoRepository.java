package edu.will.barberApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.will.barberApp.models.Servico;
import edu.will.barberApp.models.ServicoAgendado;

@Repository
public interface ServicoAgendadoRepository extends JpaRepository<ServicoAgendado, Long> {
	
		
	
	
}
