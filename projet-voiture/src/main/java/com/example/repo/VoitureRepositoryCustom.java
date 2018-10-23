/**
 * 
 */
package com.example.repo;

import java.util.List;

import com.example.model.Voiture;

/**
 * @author Dylan
 *
 */
public interface VoitureRepositoryCustom {
	List<Voiture> searchPrixLessThan(int prix);
}
