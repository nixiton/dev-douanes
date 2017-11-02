package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;
import com.douane.entite.Direction;
import com.douane.entite.Materiel;
import com.douane.entite.OpSortie;

public interface OpSortieRepository extends CrudRepository<OpSortie, Long>{
	public List<OpSortie> findAll();
	public List<OpSortie> findByOperateur(Agent operateur);
	public List<OpSortie> findByDirection(Direction direction);
	public List<OpSortie> findByMat(Materiel m);

}

