package com.in28mnutes.jpa.hibernate.demo.repository;

import com.in28mnutes.jpa.hibernate.demo.entity.Course;
import com.in28mnutes.jpa.hibernate.demo.entity.Student;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest
class JPQLTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void findById() {
        List resultLİst = em.createQuery("select c from Course c").getResultList();
        logger.info("select c from course c -> {}", resultLİst);
    }

    @Test
    public void jpql_courses_without_students(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results-> {}", resultList);
    }

    @Test
    public void jpql_courses_with_atleast_2_students(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c where size(c.students) >= 2", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results-> {}", resultList);
    }

    @Test
    public void jpql_courses_orderedby_students(){
        TypedQuery<Course> query = em.createQuery("Select c from Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Results-> {}", resultList);
    }

    @Test
    public void jpql_students_with_passports_in_a_certain_pattern(){
        TypedQuery<Student> query = em.createQuery("Select s from Student s where s.passport.number like '%123%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("Results-> {}", resultList);
    }

    @Test
    public void join() {
        Query query = em.createQuery("select c, s from Course c join c.students s");
        List resultList = query.getResultList();
        logger.info("results size -> {}", resultList.size());
    }

    @Test
    public void left_join() {
        Query query = em.createQuery("select c, s from Course c left join c.students s");
        List resultList = query.getResultList();
        logger.info("results size -> {}", resultList.size());
    }

}
