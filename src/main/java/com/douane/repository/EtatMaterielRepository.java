package com.douane.repository;

import com.douane.entite.EtatMateriel;
import com.douane.entite.Materiel;

import java.util.List;

/**
 * Created by hasina on 11/4/17.
 */
public interface EtatMaterielRepository {

    public List<EtatMateriel> findByMateriel(Materiel materiel);
    public List<EtatMateriel> findALl();
}