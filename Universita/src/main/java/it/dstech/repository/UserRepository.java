package it.dstech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dstech.models.Esame;
import it.dstech.models.Libretto;
import it.dstech.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);

	User findUserByUsername(String username);

	Optional<User> findById(Integer id);
	
}
