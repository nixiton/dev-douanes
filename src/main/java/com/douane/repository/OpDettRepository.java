package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;
import com.douane.entite.Direction;
import com.douane.entite.Materiel;
import com.douane.entite.OpAttribution;
import com.douane.entite.OpDettachement;

public interface OpDettRepository extends CrudRepository<OpDettachement, Long>{
    public List<OpDettachement> findAll();
    public List<OpDettachement> findByOperateur(Agent operateur);
    public List<OpDettachement> findByDirection(Direction direction);
    public List<OpDettachement> findByMat(Materiel m);

}

