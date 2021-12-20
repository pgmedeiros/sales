package com.sales.api.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Sales {

    @Id
    @GeneratedValue
    private long id;
    private double value;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private SalesPerson salesPerson;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SalesPerson getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(SalesPerson salesPerson) {
        this.salesPerson = salesPerson;
    }
}