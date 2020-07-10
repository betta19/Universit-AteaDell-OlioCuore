package it.dstech.service;

import java.util.Arrays;
import java.util.HashSet;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.dstech.models.Docente;
import it.dstech.repository.DocenteRepository;
import it.dstech.repository.RoleRepository;


public class DocenteService {
	
	@Autowired
    private DocenteRepository docenteRepository;
	@Autowired
    private RoleRepository roleRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
    public Docente findUserByEmail(String email) {
        return docenteRepository.findByEmail(email);
    }

    public Docente findUserByUserName(String userName) {
        return docenteRepository.findByUserName(userName);
    }

    public Docente saveUser(Docente docente) {
    	docente.setPassword(bCryptPasswordEncoder.encode(docente.getPassword()));
    	docente.setActive(true);
        Role userRole = roleRepository.findByRole("ADMIN");
        docente.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return docenteRepository.save(docente);
    }

}
