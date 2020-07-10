package it.dstech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.dstech.models.Docente;
import it.dstech.models.Esame;
import it.dstech.models.Studente;
import it.dstech.repository.EsameRepository;

public class EsameService implements EsameI{

	@Autowired
	private EsameRepository esameRepository;
	
	@Override
	public Esame findByListaDocenti(List<Docente> listaDocenti) {
		return esameRepository.findByListaDocenti(listaDocenti);
	}

	@Override
	public Esame findByEsame(List<Studente> listStudenti) {
		return esameRepository.findByEsame(listStudenti);
	}
		
}
