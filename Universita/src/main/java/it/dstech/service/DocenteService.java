package it.dstech.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.dstech.models.Docente;
import it.dstech.repository.DocenteRepository;

@Service
public class DocenteService {
	
	@Autowired
    private DocenteRepository docenteRepository;
    
    public Docente findUserByEmail(String email) {
        return docenteRepository.findByEmail(email);
    }

    public Docente findUserByUsername(String userName) {
        return docenteRepository.findByUsername(userName);
    }

}
