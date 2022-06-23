
package com.tii.springboot.app.models.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class DateRange {

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateFrom;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateTo;

}