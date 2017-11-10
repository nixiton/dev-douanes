package com.douane.dao.materiel;

import com.douane.entite.Materiel;
import com.douane.entite.Referentiel;
import com.douane.metier.motifAquisition.IModeAcquisitionMetier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by hasina on 11/11/17.
 */
public class IMatDAOImpl implements IMatDAO{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Materiel> listMat(Materiel m) {
        Query req= em.createQuery("select n from "+m.getClass().getName()+" n");
        return (List<Materiel>)req.getResultList();
    }
}
