package com.douane.managed.bean;

import com.douane.entite.*;
import com.douane.metier.user.IUserMetier;
import com.douane.repository.OpRepository;
import com.douane.requesthttp.RequestFilter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.HashMap;
import java.util.List;

/**
 * Created by hasina on 11/3/17.
 */


@ManagedBean(name="gacBean")
public class GACBean {
    @ManagedProperty(value="#{usermetier}")
    IUserMetier usermetierimpl;

    private List<Agent> listAgent;


    private HashMap<Agent,List<Operation>> AgentOp = new HashMap<Agent, List<Operation>>();
    private Agent gac;

    public HashMap<Agent,List<Operation>> getOperationAndDepositaire()
    {
        //first get direction of GAC
        gac = (Agent) RequestFilter.getSession().getAttribute("agent");
        //get all operation request for each agent
        listAgent = getAllAgents();
        for (Agent a: listAgent)
        {
            if(a.getDirection().getCodeDirection().equals(gac.getDirection().getCodeDirection()))
            {
                AgentOp.put(a,usermetierimpl.getListOpByOperator(a));
            }
        }

        return AgentOp;
    }

    public void validatePrisEnChargeEntreMat(OpEntree op)
    {
        usermetierimpl.entrerMateriel(op);
    }

    public void validateAttributionDetenteur(OpAttribution attr)
    {
        usermetierimpl.attriuberMateriel(attr);
    }

    public void validateDechargeSortie(OpSortie sortie) throws Exception {
        usermetierimpl.sortirMateriel(sortie);
    }

    private List<Agent> getAllAgents()
    {
        return usermetierimpl.findAllAgents();
    }
}
//r