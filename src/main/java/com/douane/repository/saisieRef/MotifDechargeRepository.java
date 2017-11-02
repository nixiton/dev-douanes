package com.douane.repository.saisieRef;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;
import com.douane.entite.MotifDecharge;
import com.douane.entite.Nomenclature;

public interface MotifDechargeRepository extends CrudRepository<MotifDecharge, Long> {
	
}
