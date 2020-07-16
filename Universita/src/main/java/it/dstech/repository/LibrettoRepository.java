package it.dstech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dstech.models.Esame;
import it.dstech.models.Libretto;
@Repository
public interface LibrettoRepository extends JpaRepository<Libretto, Integer> {

	
	public List<Libretto> findByStudente(String username);
	
	
}
