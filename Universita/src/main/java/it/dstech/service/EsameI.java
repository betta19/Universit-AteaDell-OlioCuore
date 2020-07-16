package it.dstech.service;

import java.util.List;
import it.dstech.models.Esame;
import it.dstech.models.Libretto;
import it.dstech.models.User;

public interface EsameI {
	
	public List<Esame> findAllEsame();

	Esame findById(int id);

	boolean prenotaEsame(User userS, Esame esame, Libretto libretto);
}
