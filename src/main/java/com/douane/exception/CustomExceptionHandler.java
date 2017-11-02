package com.douane.exception;

/**
 * Created by hasina on 9/26/17.
 */
import java.util.Iterator;
import java.util.Map;
import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

@RequestScoped
public class CustomExceptionHandler extends ExceptionHandlerWrapper {
    private ExceptionHandler wrapped;

    private FacesContext context;

    public CustomExceptionHandler(ExceptionHandler wrapped,FacesContext context)
    {
        this.wrapped = wrapped;
        this.context = context;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return wrapped;
    }

    @Override
    public void handle() throws FacesException {
        final Iterator<ExceptionQueuedEvent> queue = getUnhandledExceptionQueuedEvents().iterator();

        while (queue.hasNext()){
            ExceptionQueuedEvent item = queue.next();
            ExceptionQueuedEventContext exceptionQueuedEventContext = (ExceptionQueuedEventContext)item.getSource();
            FacesContext context2 = FacesContext.getCurrentInstance();
            try {
                Throwable throwable = exceptionQueuedEventContext.getException();
                System.err.println("Exception: " + throwable.getMessage());

                context2.setViewRoot(context.getViewRoot());
                context2.getViewRoot().getViewId();
                context2.getViewRoot().setViewId("j_id1");
                UIViewRoot root = context.getViewRoot();
                String viewId = context.getViewRoot().getViewId();
                Map<String, Object> requestMap = context2.getExternalContext().getRequestMap();
                NavigationHandler nav = context2.getApplication().getNavigationHandler();

                requestMap.put("error-message", throwable.getMessage());
                requestMap.put("error-stack", throwable.getStackTrace());
                nav.handleNavigation(context2, null, "/error");

                context2.renderResponse();

            } finally {
                queue.remove();
            }
        }
    }
}
