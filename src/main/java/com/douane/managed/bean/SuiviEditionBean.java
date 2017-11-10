package com.douane.managed.bean;

import com.douane.entite.*;
import com.douane.metier.user.IUserMetier;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ManagedBean;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Created by hasina on 11/3/17.
 */


@ManagedBean(name="suivieditionBean")
@Component
public class SuiviEditionBean {
    @Autowired
    IUserMetier usermetierimpl;

    private Agent agentOperateur;
    private Direction direction;
    private Date startDate;
    private Date endDate;



    private List<Operation> listAllOperation;
    private List<OpEntree> listOperationEntree;
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
    private List<OpDettachement> listOperationDetachementByMateriel;
    private Materiel materiel;

    public List<Operation> getListAllOperation()
    {
        return usermetierimpl.getListOp();
    }

    public List<OpEntree> getListOperationEntree()
    {
        return usermetierimpl.getListOpEntree();
    }

    public List<OpSortie> getListOperationSortie()
    {
        return usermetierimpl.getListOpSortie();
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

    public List<Operation> getListOperatoinByOperateur()
    {
        return usermetierimpl.getListOpByOperator(this.agentOperateur);
    }

    public List<OpEntree> getListOperationEntreeByOperator()
    {
        return usermetierimpl.getListOpEntreeByOperator(this.agentOperateur);
    }

    public List<OpSortie> getListOperationSortieByOperator()
    {
        return usermetierimpl.getListOpSortieByOperator(this.agentOperateur);
    }


    //-------------GET List of operations by DIRECTION --------------------------------
    public List<Operation> getListOperatoinByDirection()
    {
        return usermetierimpl.getListOpByDirection(this.direction);
    }

    public List<OpEntree> getListOperationEntreeByDirection()
    {
        return usermetierimpl.getListOpEntreeByDirection(this.direction);
    }

    public List<OpSortie> getListOperationSortieByDirection()
    {
        return usermetierimpl.getListOpSortieByDirection(this.direction);
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

    public List<OpSortie> getListOperationSortieByMateriel()
    {
        return usermetierimpl.getListOpSortieByMat(getMateriel());
    }

    //------------GET List of Materiel By Date-------------------
    public List<OpEntree> getListOperationEntreeByMaterielByDate(Date startDate, Date endDate)
    {
        return usermetierimpl.getListOpEntreeByMatBDate(getMateriel(),startDate,endDate);
    }

    public List<OpSortie> getListOperationSortieByMaterielByDate(Date startDate, Date endDate)
    {
        return usermetierimpl.getListOpSortieByMatBDate(getMateriel(),startDate,endDate);
    }

    //------------------liste des operations atributions et dettachements ---------------------
    public List<OpAttribution> getListOperationAttribution()
    {
        return usermetierimpl.getListOpAttribution();
    }
    public List<OpDettachement> getListOperationDetachement()
    {
        return usermetierimpl.getListOpDettachement();
    }

    public List<OpAttribution> getListOperationAttributionByOperator()
    {
        return usermetierimpl.getListOpAttrByOperator(getAgentOperateur());
    }
    public List<OpDettachement> getListOperationDetachementByOperator()
    {
        return usermetierimpl.getListOpDettByOperatort(getAgentOperateur());
    }

    public List<OpAttribution> getListOperationAttributionByDirection()
    {
        return usermetierimpl.getListOpAttrByDirection(getDirection());
    }

    public List<OpDettachement> getListOperationDeetachementByDirection()
    {
        return usermetierimpl.getListOpDettByDirection(getDirection());
    }

    public List<OpAttribution> getListOperationAttributionByMateriel()
    {
        return usermetierimpl.getListOpAttrByMat(getMateriel());
    }

    public List<OpDettachement> getListOperationDetachementByMateriel()
    {
        return usermetierimpl.getListOpDettByMat(getMateriel());
    }




    public void setListAllOperation(List<Operation> listAllOperation) {
        this.listAllOperation = listAllOperation;
    }

    public void setListOperationEntree(List<OpEntree> listOperationEntree) {
        this.listOperationEntree = listOperationEntree;
    }

    public void setListOperationSortie(List<OpSortie> listOperationSortie) {
        this.listOperationSortie = listOperationSortie;
    }

    public void setListOperatoinByOperateur(List<Operation> listOperatoinByOperateur) {
        this.listOperatoinByOperateur = listOperatoinByOperateur;
    }

    public void setListOperationEntreeByOperator(List<OpEntree> listOperationEntreeByOperator) {
        this.listOperationEntreeByOperator = listOperationEntreeByOperator;
    }

    public void setListOperationSortieByOperator(List<OpSortie> listOperationSortieByOperator) {
        this.listOperationSortieByOperator = listOperationSortieByOperator;
    }

    public void setListOperatoinByDirection(List<Operation> listOperatoinByDirection) {
        this.listOperatoinByDirection = listOperatoinByDirection;
    }

    public void setListOperationEntreeByDirection(List<OpEntree> listOperationEntreeByDirection) {
        this.listOperationEntreeByDirection = listOperationEntreeByDirection;
    }

    public void setListOperationSortieByDirection(List<OpSortie> listOperationSortieByDirection) {
        this.listOperationSortieByDirection = listOperationSortieByDirection;
    }

    public List<Operation> getListOperationBetween() {
        return listOperationBetween;
    }

    public void setListOperationBetween(List<Operation> listOperationBetween) {
        this.listOperationBetween = listOperationBetween;
    }

    public void setListOperationEntreeByMateriel(List<OpEntree> listOperationEntreeByMateriel) {
        this.listOperationEntreeByMateriel = listOperationEntreeByMateriel;
    }

    public void setListOperationSortieByMateriel(List<OpSortie> listOperationSortieByMateriel) {
        this.listOperationSortieByMateriel = listOperationSortieByMateriel;
    }

    public List<OpEntree> getListOperationEntreeByMaterielByDate() {
        return listOperationEntreeByMaterielByDate;
    }

    public void setListOperationEntreeByMaterielByDate(List<OpEntree> listOperationEntreeByMaterielByDate) {
        this.listOperationEntreeByMaterielByDate = listOperationEntreeByMaterielByDate;
    }

    public List<OpSortie> getListOperationSortieByMaterielByDate() {
        return listOperationSortieByMaterielByDate;
    }

    public void setListOperationSortieByMaterielByDate(List<OpSortie> listOperationSortieByMaterielByDate) {
        this.listOperationSortieByMaterielByDate = listOperationSortieByMaterielByDate;
    }

    public void setListOperationAttribution(List<OpAttribution> listOperationAttribution) {
        this.listOperationAttribution = listOperationAttribution;
    }

    public void setListOperationDetachement(List<OpDettachement> listOperationDetachement) {
        this.listOperationDetachement = listOperationDetachement;
    }

    public void setListOperationAttributionByOperator(List<OpAttribution> listOperationAttributionByOperator) {
        this.listOperationAttributionByOperator = listOperationAttributionByOperator;
    }

    public void setListOperationDetachementByOperator(List<OpDettachement> listOperationDetachementByOperator) {
        this.listOperationDetachementByOperator = listOperationDetachementByOperator;
    }

    public void setListOperationAttributionByDirection(List<OpAttribution> listOperationAttributionByDirection) {
        this.listOperationAttributionByDirection = listOperationAttributionByDirection;
    }

    public void setListOperationDeetachementByDirection(List<OpDettachement> listOperationDeetachementByDirection) {
        this.listOperationDeetachementByDirection = listOperationDeetachementByDirection;
    }

    public void setListOperationAttributionByMateriel(List<OpAttribution> listOperationAttributionByMateriel) {
        this.listOperationAttributionByMateriel = listOperationAttributionByMateriel;
    }

    public void setListOperationDetachementByMateriel(List<OpDettachement> listOperationDetachementByMateriel) {
        this.listOperationDetachementByMateriel = listOperationDetachementByMateriel;
    }
}
