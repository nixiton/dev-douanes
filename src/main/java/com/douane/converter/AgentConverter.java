package com.douane.converter;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.metier.user.IUserMetier;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by hasina on 11/11/17.
 */

@ManagedBean
@RequestScoped
public class AgentConverter implements Converter{



    @ManagedProperty(value="#{usermetier}")
    IUserMetier userMetier;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("***************************AGENT CONV*****ERRORR********************************");
        if(value != null && value.trim().length() > 0)
        {
            try {
                return this.userMetier.findAgentByIm(Long.parseLong(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        System.out.println("***************************AGENT CONV*****ERRORR********************************");
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if(object != null) {
            return String.valueOf(((Agent) object).getIm());
        }
        else {
            return null;
        }
    }

    public IUserMetier getUserMetier() {
        return userMetier;
    }

    public void setUserMetier(IUserMetier userMetier) {
        this.userMetier = userMetier;
    }
}
