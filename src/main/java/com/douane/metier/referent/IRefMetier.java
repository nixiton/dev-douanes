package com.douane.metier.referent;

import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.FournisseurDetail;
import com.douane.entite.Referentiel;

public interface IRefMetier {
    public Referentiel addRef(Referentiel r, Agent operat);
    public void removeRef(Referentiel r);
    public List<Referentiel> listRef(Referentiel r);
    public void saveRefs(List<Referentiel> listrefs, Agent operat);

    public void addFournisseur(FournisseurDetail f, Agent operat);
    public void removeFournisseur(FournisseurDetail f);
    public List<FournisseurDetail> listFournisseur();
}
