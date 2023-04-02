package com.in28mnutes.jpa.hibernate.demo.repository;

import com.in28mnutes.jpa.hibernate.demo.entity.Course;
import com.in28mnutes.jpa.hibernate.demo.entity.Review;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Isolation;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class NativeQueriesTes {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;


    @Test
    void basic() {
        Query query = entityManager.createNativeQuery("SELECT * FROM COURSE", Course.class);
        List resultList = query.getResultList();
        logger.info("************************select * from course -> {}", resultList);
    }


}
