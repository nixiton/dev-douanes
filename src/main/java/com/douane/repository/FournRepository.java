package com.douane.repository;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.FournisseurDetail;

public interface FournRepository extends CrudRepository<FournisseurDetail, Long>{

}
