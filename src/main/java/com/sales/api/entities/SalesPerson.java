package com.sales.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class SalesPerson {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "salesPerson")
    private List<Sales> sales;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
