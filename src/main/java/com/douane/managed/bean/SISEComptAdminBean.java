package com.douane.managed.bean;

import com.douane.entite.*;
import com.douane.metier.user.IUserMetier;
import com.douane.requesthttp.RequestFilter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hasina on 11/8/17.
 */
public class SISEComptAdminBean {

    @Autowired
    IUserMetier usermetierimpl;

    CodeArticle codeArticle;



    List<CodeArticle> listCodeArticle;



    List<CodeArticle> listCodeArticleByTypeObj;
    Article article;



    Agent agentBenef;


    Long nombreArticle;

    //pour validation automatique
    public Article addArticleForValidation()
    {
        article = new Article();
        article.setCodeArticle(getCodeArticle());
        article.setNombre(getNombreArticle());
        article.setBeneficiaire(getAgentBenef());
        OpEntreeArticle opentreeart = usermetierimpl.reqEntrerArticle(article,(Agent) RequestFilter.getSession().getAttribute("agent"));

        usermetierimpl.entrerArticle(opentreeart);
        return this.article;
    }



    public CodeArticle getCodeArticle() {
        return codeArticle;
    }

    public void setCodeArticle(CodeArticle codeArticle) {
        this.codeArticle = codeArticle;
        usermetierimpl.addCodeArticle(codeArticle);
    }

    public void removeCodeArtcile(CodeArticle ca)
    {
        usermetierimpl.removeCodeArticle(ca);
    }

    public List<CodeArticle> getListCodeArticle()
    {
        return usermetierimpl.listCodeArticle();
    }

    public void setListCodeArticle(List<CodeArticle> listCodeArticle) {
        this.listCodeArticle = listCodeArticle;
    }

    public List<CodeArticle> getListCodeArticleByTypeObj(TypeObjet typeObj)
    {
        return usermetierimpl.listCodeArticleByTypeObj(typeObj);
    }

    public void setListCodeArticleByTypeObj(List<CodeArticle> listCodeArticleByTypeObj) {
        this.listCodeArticleByTypeObj = listCodeArticleByTypeObj;
    }

    public Long getNombreArticle() {
        return nombreArticle;
    }

    public void setNombreArticle(Long nombreArticle) {
        this.nombreArticle = nombreArticle;
    }

    public Agent getAgentBenef() {
        return agentBenef;
    }

    public void setAgentBenef(Agent agentBenef) {
        this.agentBenef = agentBenef;
    }
}
