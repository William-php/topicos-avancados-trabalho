package edu.will.barberApp.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.will.barberApp.models.Barbeiro;
import edu.will.barberApp.models.Usuario;

@Repository
public interface BarbeiroRepository extends JpaRepository<Barbeiro, Long> {

	@Query(value = "SELECT * FROM barbeiro b WHERE b.usuario_nome = :nome", nativeQuery = true)
	List<Barbeiro> findByName(@Param("nome") String nome);
	
	@Query(value = "SELECT * FROM barbeiro b WHERE b.usuario_sobrenome = :sobrenome", nativeQuery = true)
	List<Barbeiro> findBysobrenome(@Param("sobrenome") String sobrenome);
	
	@Query(value = "SELECT * FROM barbeiro b WHERE b.usuario_nome LIKE :nome AND b.usuario_sobrenome LIKE :sobrenome", nativeQuery = true)
	Barbeiro findBynomeSobrenome(@Param("nome") String nome, @Param("sobrenome") String sobrenome);
	
	
//	@Query(value = "SELECT * FROM barbeiro WHERE barbeiro_id = :id", nativeQuery = true)
//	public Barbeiro findById(@Param("id") String id);
}

