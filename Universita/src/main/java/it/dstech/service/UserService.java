//package it.dstech.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import it.dstech.models.Role;
//import it.dstech.models.User;
//import it.dstech.repository.RoleRepository;
//import it.dstech.repository.UserRepository;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
//@Service
//public class UserService {
//
//	@Autowired
//    private UserRepository userRepository;
//	@Autowired
//    private RoleRepository roleRepository;
//	
//	@Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    
//    public User findUserByEmail(String email) {
//        return userRepository.findByEmail(email);
//    }
//
//    public User findUserByUserName(String userName) {
//        return userRepository.findByUserName(userName);
//    }
//
//    public User saveUser(User user) {
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setActive(true);
//        Role userRole = roleRepository.findByRole("ADMIN");
//        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
//        return userRepository.save(user);
//    }
//
//}