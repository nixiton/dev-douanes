package com.douane.beanerror;

/**
 * Created by hasina on 9/26/17.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ErrorBean {

    public RuntimeException getThrowError(){
         return new RuntimeException("throwing new error");
    }
}
