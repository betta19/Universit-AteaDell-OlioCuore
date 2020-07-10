package it.dstech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.dstech.models.Docente;
import it.dstech.models.Esame;
import it.dstech.models.Studente;

@Repository
public interface EsameRepository extends JpaRepository<Esame, Long>{
	
	@Query(value = "SELECT e FROM Esame e WHERE e.nome LIKE '%' || :keyword || '%'"
			+ " OR e.data LIKE '%' || :keyword || '%'"
			+ " OR e.voto LIKE '%' || :keyword || '%'"
			+ " OR e.superato LIKE '%' || :keyword || '%'")
	public List<Esame> search(@Param("keyword") String keyword);
	
	Esame findByListaDocenti(List<Docente> listaDocenti);
	
	Esame findByEsame(List<Studente> listStudenti);
	
}
