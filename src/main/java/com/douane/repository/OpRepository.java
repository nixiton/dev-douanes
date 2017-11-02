package com.douane.repository;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Operation;

public interface OpRepository extends CrudRepository<Operation, Long>{

}
