package com.douane.repository.saisieRef;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;

public interface UtilisateurRepository extends CrudRepository<Useri, Integer> {
	
}
