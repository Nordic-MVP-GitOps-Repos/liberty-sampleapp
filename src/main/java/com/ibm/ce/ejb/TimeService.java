package com.ibm.ce.ejb;

import java.util.Date;

import javax.jws.WebService;

@WebService(name = "TimeServicePortType")
public interface TimeService {
    Date getTime();
    Date getYesterday();
    Date getTomorrow();
}