package com.in28mnutes.jpa.hibernate.demo.repository;

import com.in28mnutes.jpa.hibernate.demo.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest
class CriteriaQueryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    @Test
    void all_courses() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resList = query.getResultList();
        logger.info("TYped Query -> {}", resList);
    }

    @Test
    void all_courses_having_100steps() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Predicate likespring = cb.like(courseRoot.get("name"),"Spring");
        cq.where(likespring);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resList = query.getResultList();
        logger.info("TYped Query -> {}", resList);
    }

    @Test
    void join() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);
        Join<Object, Object> join =  courseRoot.join("students", JoinType.LEFT);
        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
        List<Course> resList = query.getResultList();
        logger.info("TYped Query -> {}", resList);
    }
}
