package com.douane.exception;

/**
 * Created by hasina on 9/26/17.
 */

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;
import javax.faces.context.FacesContext;

public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {
    FacesContext context;
    private ExceptionHandlerFactory exceptionHandlerFactory;

    public CustomExceptionHandlerFactory() {
    }

    public CustomExceptionHandlerFactory(ExceptionHandlerFactory exceptionHandlerFactory) {
        context = FacesContext.getCurrentInstance();
        this.exceptionHandlerFactory = exceptionHandlerFactory;
    }

    @Override
    public ExceptionHandler getExceptionHandler() {
        return new CustomExceptionHandler(exceptionHandlerFactory.getExceptionHandler(), context);
    }
}
