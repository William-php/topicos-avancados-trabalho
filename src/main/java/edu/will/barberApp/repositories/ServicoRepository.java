package edu.will.barberApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.will.barberApp.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
