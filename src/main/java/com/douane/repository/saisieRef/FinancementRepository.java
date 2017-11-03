package com.douane.repository.saisieRef;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;
import com.douane.entite.Financement;
import com.douane.entite.Nomenclature;

public interface FinancementRepository extends CrudRepository<Financement, Long> {
	
}
