package edu.will.barberApp.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.will.barberApp.models.Barbeiro;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {

	@Query(value = "SELECT * FROM barbeiro b WHERE b.barbeiro_nome = :nome", nativeQuery = true)
	Barbeiro findByName(@Param("nome") String nome);
	
	@Override
	@Query(value = "SELECT * FROM barbeiro", nativeQuery = true)
	List<Barbeiro> findAll();
//	@Query(value = "SELECT * FROM barbeiro WHERE barbeiro_id = :id", nativeQuery = true)
//	public Barbeiro findById(@Param("id") String id);
}

