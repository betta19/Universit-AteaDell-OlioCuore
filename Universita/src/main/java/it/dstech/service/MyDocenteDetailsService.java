package it.dstech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import it.dstech.models.Docente;
import it.dstech.models.Role;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MyDocenteDetailsService implements UserDetailsService {

    @Autowired
    private DocenteService docenteService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) {
        Docente docente = docenteService.findUserByUserName(username);
        List<GrantedAuthority> authorities = getUserAuthority(docente.getRoles());
        return buildUserForAuthentication(docente, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
        Set<GrantedAuthority> roles = new HashSet<>();
        for (Role role : userRoles) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }
        return new ArrayList<>(roles);
    }

    private UserDetails buildUserForAuthentication(Docente docente, List<GrantedAuthority> authorities) {
        return new org.springframework.security.core.userdetails.User(docente.getUsername(), docente.getPassword(),
                docente.getActive(), true, true, true, authorities);
    }
}
