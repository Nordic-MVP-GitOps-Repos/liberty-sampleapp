package com.ibm.ce.ejb;

import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless(name="TimeService")
@Local
@Path("time")
@Produces(MediaType.APPLICATION_JSON)
public class TimeServiceImpl implements TimeService {
    
    @Override
    @GET
    @Path("now")
    public Date getTime() {
        return new Date();
    }

    @Override
    @GET()
    @Path("yesterday")
    public Date getYesterday() {
        return new Date();
    }
    
    @Override
    @GET()
    @Path("tomorrow")
    public Date getTomorrow() {
        return new Date();
    }
}
