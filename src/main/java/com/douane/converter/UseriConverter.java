package com.douane.converter;

import com.douane.entite.*;
import com.douane.metier.referentiel.IRefMetier;
import com.douane.metier.user.IUserMetier;
import com.douane.metier.utilisateur.IUtilisateurMetier;

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
public class UseriConverter implements Converter {




    @ManagedProperty(value="#{utilisateurmetier}")
    private IUtilisateurMetier utilisateurmetierimpl;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0)
        {
            try {
                return this.utilisateurmetierimpl.findById(Integer.parseInt(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object object) {
        if(object != null) {
            return String.valueOf(((Useri) object).getIdUser());
        }
        else {
            return null;
        }
    }


    public IUtilisateurMetier getUtilisateurmetierimpl() {
        return utilisateurmetierimpl;
    }

    public void setUtilisateurmetierimpl(IUtilisateurMetier utilisateurmetierimpl) {
        this.utilisateurmetierimpl = utilisateurmetierimpl;
    }
}
