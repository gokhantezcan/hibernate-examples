package com.in28mnutes.jpa.hibernate.demo.repository;

import com.in28mnutes.jpa.hibernate.demo.entity.Address;
import com.in28mnutes.jpa.hibernate.demo.entity.Passport;
import com.in28mnutes.jpa.hibernate.demo.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
class StudentRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional // persistence context
    public void someTest(){
        // database operation 1 retrieve student
        Student student = entityManager.find(Student.class, 20001L);
        // persistence context (student)

        // database operation 1 retrieve passport
        Passport passport = student.getPassport();
        // persistence context (student, passport)

        // database operation 3 update passport
        passport.setNumber("TY5675");

        // database operation 4 update student
        student.setName("Rnaga updated");
    }

    @Test
    @Transactional
    void retrieveStudentAndPassportDetails() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    void setAddressDetails() {
        Student student = entityManager.find(Student.class, 20001L);
        student.setAddress(new Address("NO 101", "Some Street", "HYderabad"));
        entityManager.flush();
        logger.info("student -> {}", student);
        logger.info("passport -> {}", student.getPassport());
    }

    @Test
    @Transactional
    void retrieveassportAndAssociatedStudentDetails() {
        Passport passport = entityManager.find(Passport.class, 40001L);
        logger.info("passport -> {}", passport);
        logger.info("student -> {}", passport.getStudent());
    }

    @Test
    @Transactional
    void retrieveStudentAndCourses() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("student -> {}", student);
        logger.info("courses -> {}", student.getCourses());
    }


}
