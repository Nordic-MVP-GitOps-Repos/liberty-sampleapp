package com.ibm.ce.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.ibm.ce.ejb.TimeServiceImpl;

@ApplicationPath("/api")
public class RestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(PropertiesResource.class);
        classes.add(TimeServiceImpl.class);
        return classes;
    }
}