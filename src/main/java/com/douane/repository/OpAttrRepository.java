package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;
import com.douane.entite.Direction;
import com.douane.entite.Materiel;
import com.douane.entite.OpAttribution;
import com.douane.entite.OpEntree;

public interface OpAttrRepository extends CrudRepository<OpAttribution, Long>{
    public List<OpAttribution> findAll();
    public List<OpAttribution> findByOperateur(Agent operateur);
    public List<OpAttribution> findByDirection(Direction direction);
    public List<OpAttribution> findByMat(Materiel m);

}
