package com.douane.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.douane.entite.Agent;
import com.douane.entite.Bureau;
import com.douane.entite.Direction;
import com.douane.entite.Materiel;
import com.douane.entite.Nomenclature;
import com.douane.entite.Service;

public interface MaterielRepository extends CrudRepository<Materiel, Long>{
	public Materiel findByIdMateriel(Long idmat);
	public List<Materiel> findByDetenteur(Agent detenteur);
	public List<Materiel> findByNomenMat(Nomenclature nomenclature);
	public List<Materiel> findByDirec(Direction direction);
	public List<Materiel> findByServ(Service service);
	public List<Materiel> findByBureau(Bureau bureau);
}
