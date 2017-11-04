package com.douane.repository;

import com.douane.entite.Agent;
import com.douane.entite.Useri;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hasina on 11/4/17.
 */
public interface UseriRepository extends CrudRepository<Useri, Long> {
    public List<Useri> findAll();
    public List<Useri> findByAgent(Useri useri);
}