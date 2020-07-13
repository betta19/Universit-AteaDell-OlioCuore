package it.dstech.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.models.Docente;
import it.dstech.models.Esame;
import it.dstech.repository.DocenteRepository;
import it.dstech.repository.EsameRepository;

@Service
public class DocenteService implements DocenteI {
	
	@Autowired
    private DocenteRepository docenteRepository;
	
	@Autowired
	private EsameRepository esameRepo;
    
    public Docente findUserByEmail(String email) {
        return docenteRepository.findByEmail(email);
    }

    public Docente findUserByUsername(String username) {
        return docenteRepository.findByUsername(username);
    }

    @Override
    public boolean aggiungiEsame(Docente docente, Esame esame) {

     if (esameRepo.existsById(esame.getId())) {
      
      Esame sovrascrivEsame = esame;

      esameRepo.save(sovrascrivEsame);
     }

     Esame save = esameRepo.save(esame);
     return save != null;

    }
}
