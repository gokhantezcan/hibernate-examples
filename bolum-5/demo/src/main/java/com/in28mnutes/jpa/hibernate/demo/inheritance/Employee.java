package com.in28mnutes.jpa.hibernate.demo.inheritance;

import com.in28mnutes.jpa.hibernate.demo.entity.Review;
import com.in28mnutes.jpa.hibernate.demo.entity.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "EmployeeTYpe")
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
