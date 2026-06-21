package com.spring.bioMedical.repository;

import com.spring.bioMedical.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User Repository - Matching ORIGINAL schema
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	Optional<User> findByUsername(String username);
	
	boolean existsByUsername(String username);
	
}
