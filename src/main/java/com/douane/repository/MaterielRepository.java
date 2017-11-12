package com.douane.repository;

import java.util.List;

import com.douane.entite.*;
import org.springframework.data.repository.CrudRepository;

public interface MaterielRepository extends CrudRepository<Materiel, Long>{
	public Materiel findByIdMateriel(Long idmat);
	public List<Materiel> findByDetenteur(Agent detenteur);
	public List<Materiel> findByNomenMat(Nomenclature nomenclature);
	public List<Materiel> findByDirec(Direction direction);
	public List<Materiel> findByServ(Service service);
	public List<Materiel> findByBureau(Bureau bureau);
	public List<Materiel> findByValidation(boolean validation);
	public List<Materiel> findByDetenteurAndValidation(Agent detenteur, boolean validation);
}
