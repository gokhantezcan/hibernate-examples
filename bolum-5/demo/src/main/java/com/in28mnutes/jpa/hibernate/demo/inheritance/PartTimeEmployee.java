package com.in28mnutes.jpa.hibernate.demo.inheritance;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class PartTimeEmployee extends Employee{

    private BigDecimal hourlyWage;

    protected PartTimeEmployee(){}

    public PartTimeEmployee(String name, BigDecimal hourlyWage) {
        super(name);
        this.hourlyWage = hourlyWage;
    }
}
