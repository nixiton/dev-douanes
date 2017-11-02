package com.douane.repository.saisieRef;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;
import com.douane.entite.Marque;
import com.douane.entite.Nomenclature;

public interface MarqueRepository extends CrudRepository<Marque, Long> {
	
}
