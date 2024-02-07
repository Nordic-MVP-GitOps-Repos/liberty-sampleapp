package com.ibm.ce.ejb;

import java.util.Date;

public interface TimeService {
    Date getTime();
    Date getYesterday();
    Date getTomorrow();
}