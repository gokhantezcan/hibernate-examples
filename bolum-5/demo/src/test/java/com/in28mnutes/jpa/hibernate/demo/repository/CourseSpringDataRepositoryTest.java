package com.in28mnutes.jpa.hibernate.demo.repository;

import com.in28mnutes.jpa.hibernate.demo.entity.Course;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import java.util.Optional;

@SpringBootTest
class CourseSpringDataRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Autowired
    CourseSpringDataRepository courseSpringDataRepository;

    @Test
    void findById_CoursePresent() {
        Optional<Course> courseOptional = courseSpringDataRepository.findById(10001L);
        Assert.assertTrue(courseOptional.isPresent());
    }

    @Test
    void findById_CourseNotPresent() {
        Optional<Course> courseOptional = courseSpringDataRepository.findById(20001L);
        Assert.assertTrue(courseOptional.isPresent());
    }

    @Test
    void playAround() {
//        Course course = new Course("Microservices in 100 steps");
//        courseSpringDataRepository.save(course);
//
//        course.setName("updated");
//        courseSpringDataRepository.save(course);
//        Sort sort = new Sort(Sort.Direction.DESC, "name");
        logger.info("courses -> {} ", courseSpringDataRepository.findAll());
    }

    @Test
    void pagination() {
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<Course> firstPage = courseSpringDataRepository.findAll(pageRequest);
        logger.info("First page -> {}", firstPage.getContent());
    }

    @Test
    void findUsingname() {
        logger.info("FindByName -> {}", courseSpringDataRepository.findByName("Spring boot in 50 steps"));
    }

}
