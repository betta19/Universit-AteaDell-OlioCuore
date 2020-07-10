package it.dstech.service;


import org.springframework.beans.factory.annotation.Autowired;
import it.dstech.models.Docente;
import it.dstech.repository.DocenteRepository;

public class DocenteService {
	
	@Autowired
    private DocenteRepository docenteRepository;
    
    public Docente findUserByEmail(String email) {
        return docenteRepository.findByEmail(email);
    }

    public Docente findUserByUserName(String userName) {
        return docenteRepository.findByUserName(userName);
    }

}
