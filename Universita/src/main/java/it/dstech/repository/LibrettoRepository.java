package it.dstech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import it.dstech.models.Libretto;
@Repository
public interface LibrettoRepository extends JpaRepository<Libretto, Integer> {

	
	public Libretto findByStudente(String username);
}
