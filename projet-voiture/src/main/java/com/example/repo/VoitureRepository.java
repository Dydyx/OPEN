/**
 * 
 */
package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.model.Voiture;

/**
 * @author Dylan
 *
 */

public interface VoitureRepository extends JpaRepository<Voiture, Long>, VoitureRepositoryCustom {
	List<Voiture> findByMarque(String marque);

	List<Voiture> findByPrix(int prix);
	
	
}
