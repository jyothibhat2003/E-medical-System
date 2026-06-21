package com.spring.bioMedical.repository;

import com.spring.bioMedical.model.App;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Appointment Repository - Matching ORIGINAL schema
 */
@Repository
public interface AppRepository extends JpaRepository<App, Integer> {
    
    List<App> findByEmail(String email);
    
}
