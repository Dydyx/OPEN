package com.formation.repository;

import java.util.List;
import com.formation.model.Etudiant;

public interface EtudiantRepoCostum {
	List<Etudiant> noteLessThan(Double note);
	}
