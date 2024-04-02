package com.ibm.ce.ejb;

import java.time.Instant;
import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebService(serviceName = "TimeService", portName = "TimeServicePort")
@Stateless(name="TimeService")
@Local
@Path("time")
@Produces(MediaType.APPLICATION_JSON)
public class TimeServiceImpl implements TimeService {

    private static final long SECONDS_IN_24HRS = 24*60*60L;

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
        Instant instant = Instant.now();
        instant = instant.minusSeconds(SECONDS_IN_24HRS);
        return Date.from(instant);
    }
    
    @Override
    @GET()
    @Path("tomorrow")
    public Date getTomorrow() {
        Instant instant = Instant.now();
        instant = instant.plusSeconds(SECONDS_IN_24HRS);
        return Date.from(instant);
    }
}