package it.dstech.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.dstech.models.Role;
import it.dstech.models.Studente;
import it.dstech.repository.RoleRepository;
import it.dstech.repository.StudenteRepository;

public class StudenteService {
	
	@Autowired
    private StudenteRepository studenteRepository;
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    public Studente findUserByEmail(String email) {
        return studenteRepository.findByEmail(email);
    }

    public Studente findUserByUserName(String username) {
        return studenteRepository.findByUserName(username);
    }

    public Studente saveUser(Studente studente) {
    	studente.setPassword(bCryptPasswordEncoder.encode(studente.getPassword()));
    	studente.setActive(true);
        Role userRole = roleRepository.findByRole("STUDENTE");
        studente.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return studenteRepository.save(studente);
    }

}
