package com.ibm.ce.rest;

import java.util.Properties;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.ce.ejb.TimeService;

@Stateless
@Path("properties")
public class PropertiesResource {

    @EJB
    TimeService timeService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Properties getProperties() {

        System.out.println("TimeService: " + timeService.getTime());
        System.getProperties().put("new", "value");
        return System.getProperties();
    }
}