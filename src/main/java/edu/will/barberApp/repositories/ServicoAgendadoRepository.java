package edu.will.barberApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.will.barberApp.models.Servico;
import edu.will.barberApp.models.ServicoAgendado;
import edu.will.barberApp.models.ServicoAgendadoFront;

@Repository
public interface ServicoAgendadoRepository extends JpaRepository<ServicoAgendado, Long> {
	
		
	@Query(value = "SELECT barbeiro.usuario_nome, servico_agendado.barbeiro_id, servico_agendado.cliente_id, servico_agendado.servico_id, servico_agendado.servico_agendado_id, servico_agendado.servico_data, servico_agendado.servico_hora, cliente.usuario_nome, servico.servico_nome\n"
			+ "	FROM servico_agendado\n"
			+ "    INNER JOIN barbeiro ON servico_agendado.barbeiro_id = barbeiro.barbeiro_id\n"
			+ "    INNER JOIN cliente ON servico_agendado.cliente_id = cliente.cliente_id\n"
			+ "    INNER JOIN servico ON servico_agendado.servico_id = servico.servico_id\n"
			+ "    WHERE servico_agendado.barbeiro_id = 1", nativeQuery = true)
	List<ServicoAgendado> findServicoByBarbeiro(@Param("id") Long id);
	
}
