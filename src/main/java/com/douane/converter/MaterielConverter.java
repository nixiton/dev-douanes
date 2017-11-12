package com.douane.converter;

import com.douane.entite.Materiel;
import com.douane.entite.Useri;
import com.douane.metier.user.IUserMetier;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

/**
 * Created by hasina on 11/11/17.
 */

@ManagedBean
@RequestScoped
public class MaterielConverter implements Converter {

    @ManagedProperty(value="#{usermetier}")
    IUserMetier userMetier;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0)
        {
            try {
                System.out.println("***************************MATERIEL CONV*****ERRORR********************************");
                return this.userMetier.getMatById(Long.parseLong(value));
            } catch(Exception e) {
                System.out.println("***************************MATERIEL1 CONV*****ERRORR********************************");
                e.printStackTrace();
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if(object != null) {
            return String.valueOf(((Materiel) object).getIdMateriel());
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
