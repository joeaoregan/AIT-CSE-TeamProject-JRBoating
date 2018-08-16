package com.ait.nav;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;

public class Helper {

    public static <T> T getBean(String beanName, Class<T> type) {

        // Get the FacesContext object.
        FacesContext context = FacesContext.getCurrentInstance();

        // Get the Application object for the current context.
        Application application = context.getApplication();

        // Evaluate an EL expression, to get the bean with the specified name.
        return application.evaluateExpressionGet(
        		context, 
        		"#{" + beanName + "}", 
        		type);
    }
}
