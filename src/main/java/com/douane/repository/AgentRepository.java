package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;

public interface AgentRepository extends CrudRepository<Agent, Long> {
	public List<Agent> findByNomAgentContainingIgnoreCase(String nom);
}
