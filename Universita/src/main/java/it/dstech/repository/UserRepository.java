package it.dstech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.dstech.models.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);	
	   User findUserByUserName(String userName);
}
