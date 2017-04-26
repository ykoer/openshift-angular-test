package com.redhat.www.containercatalog.management.application;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // root context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        //rootContext.register(....); // register an application configuration if it is required
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // rest api context
        AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
        restContext.setParent(rootContext);
        restContext.register(ApplicationConfiguration.class);
        ServletRegistration.Dynamic dispatcher1 =
                servletContext.addServlet("DispatcherServlet", new DispatcherServlet(restContext));
        dispatcher1.setLoadOnStartup(1);
        dispatcher1.addMapping("/rest/*");
    }
}
