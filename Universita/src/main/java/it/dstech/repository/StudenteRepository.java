package it.dstech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.dstech.models.Esame;
import it.dstech.models.Studente;

@Repository
public interface StudenteRepository extends JpaRepository<Studente, Integer>{

	@Query(value = "SELECT s FROM Studente s WHERE s.matricola LIKE '%' || :keyword || '%'")
	public List<Esame> search(@Param("keyword") String keyword);

	Studente findByEmail(String email);

	Studente findByUsername(String username);
		
}
