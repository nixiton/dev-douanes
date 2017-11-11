package com.douane.managed.bean;

import com.douane.entite.*;
import com.douane.metier.user.IUserMetier;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Created by hasina on 11/3/17.
 */


@ManagedBean(name="suivieditionBean")
@RequestScoped
public class SuiviEditionBean {


    @ManagedProperty(value="#{usermetier}")
    IUserMetier usermetierimpl;

    private Agent agentOperateur;
    private Direction direction;
    private Date startDate;
    private Date endDate;


    /*private List<OpEntree> listOperationEntree;
    private List<OpSortie> listOperationSortie;
    private List<Operation> listOperatoinByOperateur;
    private List<OpEntree> listOperationEntreeByOperator;
    private List<OpSortie> listOperationSortieByOperator;
    private List<Operation> listOperatoinByDirection;
    private List<OpEntree> listOperationEntreeByDirection;
    private List<OpSortie> listOperationSortieByDirection;
    private List<Operation> listOperationBetween;
    private List<OpEntree> listOperationEntreeByMateriel;
    private List<OpSortie> listOperationSortieByMateriel;
    private List<OpEntree> listOperationEntreeByMaterielByDate;
    private List<OpSortie> listOperationSortieByMaterielByDate;
    private List<OpAttribution> listOperationAttribution;
    private List<OpDettachement> listOperationDetachement;
    private List<OpAttribution> listOperationAttributionByOperator;
    private List<OpDettachement> listOperationDetachementByOperator;
    private List<OpAttribution> listOperationAttributionByDirection;
    private List<OpDettachement> listOperationDeetachementByDirection;
    private List<OpAttribution> listOperationAttributionByMateriel;
    private List<OpDettachement> listOperationDetachementByMateriel;*/

    private Materiel materiel;


    //----------ALL LIST BY METHOD------------------
    private List<Operation> listAllOperation;
    private List<OpEntree> listOperationEntree;
    private List<OpSortie> listOperationSortie;
    private List<Operation> listOperationByOperateur;
    private List<OpEntree> listOperationEntreeByOperator;
    private List<OpSortie> listOperationSortieByOperator;
    private List<Operation> listOperatoinByDirection;
    private List<OpEntree> listOperationEntreeByDirection;
    private List<OpSortie> listOperationSortieByDirection;
    private List<Operation> listOperationBetween;
    private List<OpEntree> listOperationEntreeByMateriel;
    private List<OpSortie> listOperationSortieByMateriel;
    private List<OpEntree> listOperationEntreeByMaterielByDate;
    private List<OpSortie> listOperationSortieByMaterielByDate;
    private List<OpAttribution> listOperationAttribution;
    private List<OpDettachement> listOperationDetachement;
    private List<OpAttribution> listOperationAttributionByOperator;
    private List<OpDettachement> listOperationDetachementByOperator;
    private List<OpAttribution> listOperationAttributionByDirection;
    private List<OpDettachement> listOperationDeetachementByDirection;
    private List<OpAttribution> listOperationAttributionByMateriel;
    private List<OpDettachement> listOperationDetachementByMateriel;
    //----------ALL LIST BY METHOD------------------
    public List<Operation> getListAllOperation()
    {
        return usermetierimpl.getListOp();
    }

    public void setListAllOperation(List<Operation> l)
    {
        this.listAllOperation = l;
    }

    public List<OpEntree> getListOperationEntree()
    {
        //setListOperationEntree(usermetierimpl.getListOpEntree());
        //return listOperationEntree;
        return usermetierimpl.getListOpEntree();
    }

    public void setListOperationEntree(List<OpEntree> l)
    {

        this.listOperationEntree = l;
    }

    public List<OpSortie> getListOperationSortie()
    {
        return usermetierimpl.getListOpSortie();
    }

    public void setListOperationSortie(List<OpSortie> l)
    {
        this.listOperationSortie = l;
    }


    //get Agent and set Agent operator
    public Agent getAgentOperateur() {
        return agentOperateur;
    }

    public void setAgentOperateur(Agent agentOperateur) {
        this.agentOperateur = agentOperateur;
    }

    //-------------GET List of operations by OPERATOR --------------------------------
    //get direction
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public List<Operation> getListOperationByOperateur()
    {
        return usermetierimpl.getListOpByOperator(this.agentOperateur);
    }

    public void setListOperationByOperateur(List<Operation> l )
    {
        this.listOperationByOperateur = l;
    }


    public List<OpEntree> getListOperationEntreeByOperator()
    {
        return usermetierimpl.getListOpEntreeByOperator(this.agentOperateur);
    }

    public void setListOperationEntreeByOperator(List<OpEntree> l)
    {
        this.listOperationEntreeByOperator = l;
    }

    public List<OpSortie> getListOperationSortieByOperator()
    {
        return usermetierimpl.getListOpSortieByOperator(this.agentOperateur);
    }

    public void setListOperationSortieByOperator(List<OpSortie> l)
    {
        this.listOperationSortieByOperator = l;
    }


    //-------------GET List of operations by DIRECTION --------------------------------
    public List<Operation> getListOperatoinByDirection()
    {
        return usermetierimpl.getListOpByDirection(this.direction);
    }

    public void setListOperatoinByDirection(List<Operation> l)
    {
        this.listOperatoinByDirection = l;
    }

    public List<OpEntree> getListOperationEntreeByDirection()
    {
        return usermetierimpl.getListOpEntreeByDirection(this.direction);
    }
    public void setListOperationEntreeByDirection(List<OpEntree> l)
    {
        this.listOperationEntreeByDirection = l;
    }

    public List<OpSortie> getListOperationSortieByDirection()
    {
        return usermetierimpl.getListOpSortieByDirection(this.direction);
    }
    public void setListOperationSortieByDirection(List<OpSortie> l)
    {
        this.listOperationSortieByDirection = l;
    }

    //------------GET List of Operations By DATE-------------------
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Operation> getListOperationBetween(Date startDate, Date endDate)
    {
        return getListOperationBetween(startDate, endDate);
    }

    public void setListOperationBetween(List<Operation> l)
    {
        this.listOperationBetween = l;
    }

    //------------GET List of Operations By Materiel-------------------
    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public List<OpEntree> getListOperationEntreeByMateriel()
    {
        return usermetierimpl.getListOpEntreeByMat(getMateriel());
    }
    public void setListOperationEntreeByMateriel(List<OpEntree> l)
    {
        this.listOperationEntreeByMateriel = l;
    }

    public List<OpSortie> getListOperationSortieByMateriel()
    {
        return usermetierimpl.getListOpSortieByMat(getMateriel());
    }
    public void setListOperationSortieByMateriel(List<OpSortie> l)
    {
        this.listOperationSortieByMateriel = l;
    }

    //------------GET List of Materiel By Date-------------------
    public List<OpEntree> getListOperationEntreeByMaterielByDate(Date startDate, Date endDate)
    {
        return usermetierimpl.getListOpEntreeByMatBDate(getMateriel(),startDate,endDate);
    }
    public void setListOperationEntreeByMaterielByDate(List<OpEntree> l)
    {
        this.listOperationEntreeByMaterielByDate = l;
    }


    public List<OpSortie> getListOperationSortieByMaterielByDate(Date startDate, Date endDate)
    {
        return usermetierimpl.getListOpSortieByMatBDate(getMateriel(),startDate,endDate);
    }
    public void setListOperationSortieByMaterielByDate(List<OpSortie> l)
    {
        this.listOperationSortieByMaterielByDate = l;
    }

    //------------------liste des operations atributions et dettachements ---------------------
    public List<OpAttribution> getListOperationAttribution()
    {
        return usermetierimpl.getListOpAttribution();
    }
    public void setListOperationAttribution(List<OpAttribution> l)
    {
        this.listOperationAttribution = l;
    }

    public List<OpDettachement> getListOperationDetachement()
    {
        return usermetierimpl.getListOpDettachement();
    }
    public void setListOperationDetachement(List<OpDettachement> l)
    {
        this.listOperationDetachement = l;
    }

    public List<OpAttribution> getListOperationAttributionByOperator()
    {
        return usermetierimpl.getListOpAttrByOperator(getAgentOperateur());
    }
    public void setListOperationAttributionByOperator(List<OpAttribution> l)
    {
        this.listOperationAttributionByOperator = l;
    }

    public List<OpDettachement> getListOperationDetachementByOperator()
    {
        return usermetierimpl.getListOpDettByOperatort(getAgentOperateur());
    }
    public void setListOperationDetachementByOperator(List<OpDettachement> l)
    {
        this.listOperationDetachementByOperator = l;
    }

    public List<OpAttribution> getListOperationAttributionByDirection()
    {
        return usermetierimpl.getListOpAttrByDirection(getDirection());
    }
    public void setListOperationAttributionByDirection(List<OpAttribution> l)
    {
        this.listOperationAttributionByDirection = l;
    }

    public List<OpDettachement> getListOperationDeetachementByDirection()
    {
        return usermetierimpl.getListOpDettByDirection(getDirection());
    }
    public void setListOperationDeetachementByDirection(List<OpDettachement> l)
    {
        this.listOperationDeetachementByDirection = l;
    }

    public List<OpAttribution> getListOperationAttributionByMateriel()
    {
        return usermetierimpl.getListOpAttrByMat(getMateriel());
    }
    public void setListOperationAttributionByMateriel(List<OpAttribution> l)
    {
        this.listOperationAttributionByMateriel = l;
    }

    public List<OpDettachement> getListOperationDetachementByMateriel()
    {
        return usermetierimpl.getListOpDettByMat(getMateriel());
    }
    public void setListOperationDetachementByMateriel(List<OpDettachement> l)
    {
        this.listOperationDetachementByMateriel = l;
    }




    //----------------NEW SETTER AND GETTER---------------------

    public IUserMetier getUsermetierimpl() {
        return usermetierimpl;
    }

    public void setUsermetierimpl(IUserMetier usermetierimpl) {
        this.usermetierimpl = usermetierimpl;
    }

}
