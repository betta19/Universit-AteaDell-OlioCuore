package it.dstech.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.dstech.models.Esame;


@Repository
public interface EsameRepository extends JpaRepository<Esame, Integer>{
	
//	@Query(value = "SELECT e FROM Esame e WHERE e.nome LIKE '%' || :keyword || '%'"
//			+ " OR e.data LIKE '%' || :keyword || '%'"
//			+ " OR e.voto LIKE '%' || :keyword || '%'"
//			+ " OR e.superato LIKE '%' || :keyword || '%'")
//	public List<Esame> search(@Param("keyword") String keyword);

	public List<Esame> findAll();

	public boolean existsById(Integer id); 
	
	public Optional<Esame> findById(Integer id);

}
