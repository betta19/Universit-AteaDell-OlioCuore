package it.dstech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dstech.models.Docente;
import it.dstech.models.Esame;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

	Docente findByEmail(String email);

	Docente findByUsername(String userName);

}
