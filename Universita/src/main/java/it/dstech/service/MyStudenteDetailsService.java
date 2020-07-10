package it.dstech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import it.dstech.models.Role;
import it.dstech.models.Studente;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyStudenteDetailsService implements UserDetailsService {

    @Autowired
    private StudenteService studenteService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        Studente studente = studenteService.findUserByUsername(username);
        List<GrantedAuthority> authorities = getUserAuthority(studente.getRoles());
        return buildUserForAuthentication(studente, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(Studente studente, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(studente.getUsername(), studente.getPassword(),
        		studente.getActive(), true, true, true, authorities);
    }
}