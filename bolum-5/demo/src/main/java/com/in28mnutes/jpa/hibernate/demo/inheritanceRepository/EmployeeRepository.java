package com.in28mnutes.jpa.hibernate.demo.inheritanceRepository;

import com.in28mnutes.jpa.hibernate.demo.entity.Course;
import com.in28mnutes.jpa.hibernate.demo.entity.Review;
import com.in28mnutes.jpa.hibernate.demo.inheritance.Employee;
import com.in28mnutes.jpa.hibernate.demo.inheritance.FullTimeEmployee;
import com.in28mnutes.jpa.hibernate.demo.inheritance.PartTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public void insert(Employee employee){
        entityManager.persist(employee);
    }

    public List<Employee> retrieveEmployees(){
        return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
    }


    public List<PartTimeEmployee> retrieveAllParttimeEmployees(){
        return entityManager.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }

    public List<FullTimeEmployee> retrieveAllFulltimeEmployees(){
        return entityManager.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }

}
