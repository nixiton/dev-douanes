package com.douane.metier.referent;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.douane.dao.referentiel.IRefDAO;
import com.douane.entite.Agent;
import com.douane.entite.FournisseurDetail;
import com.douane.entite.OpSaisie;
import com.douane.entite.Referentiel;
import com.douane.repository.FournRepository;
import com.douane.repository.OpRepository;
import com.douane.repository.RefRepository;

@Transactional
public class RefMetierImpl implements IRefMetier{

    private IRefDAO refdao;

    @Autowired
    private RefRepository refrepos;
    @Autowired
    private FournRepository fournrepos;
    @Autowired
    private OpRepository oprepos;


    public IRefDAO getRefdao() {
        return refdao;
    }

    public void setRefdao(IRefDAO dao) {
        this.refdao = dao;
    }
    public RefMetierImpl() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Referentiel addRef(Referentiel r, Agent oper)
    {
        // TODO Auto-generated method stub
        Referentiel refx = refrepos.save(r);
        OpSaisie saisiref = new OpSaisie(new Date(), new Date(), oper.getIp(), oper, r.getLeref(),refx.getId());
        //saisiref.valider();
        oprepos.save(saisiref);
        return refx;
    }

    @Override
    public void removeRef(Referentiel r) {
        // TODO Auto-generated method stub
        //dao.delRef((Nomenclature)r);
        refrepos.delete(r);
    }

    @Override
    public List<Referentiel> listRef(Referentiel r) {
        // TODO Auto-generated method stub
        return refdao.listRef(r);
    }

    @Override
    public void saveRefs(List<Referentiel> listrefs,Agent operat) {
        // TODO Auto-generated method stub
        OpSaisie saisiref = new OpSaisie(new Date(), new Date(), operat.getIp(), operat, "des referentiels",null);
        oprepos.save(saisiref);
        refrepos.save(listrefs);
    }

    @Override
    public void addFournisseur(FournisseurDetail f, Agent operat) {
        // TODO Auto-generated method stub
        FournisseurDetail fx= fournrepos.save(f);
        OpSaisie saisiref = new OpSaisie(new Date(), new Date(), operat.getIp(), operat, f.getLeref(),f.getIdFourn());
        oprepos.save(saisiref);
    }

    @Override
    public void removeFournisseur(FournisseurDetail f) {
        // TODO Auto-generated method stub
        fournrepos.delete(f);
    }

    @Override
    public List<FournisseurDetail> listFournisseur() {
        // TODO Auto-generated method stub
        return (List<FournisseurDetail>)fournrepos.findAll();
    }

}
