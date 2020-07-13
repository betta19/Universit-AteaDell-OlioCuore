package it.dstech.service;

import it.dstech.models.Docente;
import it.dstech.models.Esame;

public interface DocenteI {

	boolean aggiungiEsame(Docente docente, Esame esame);

}
