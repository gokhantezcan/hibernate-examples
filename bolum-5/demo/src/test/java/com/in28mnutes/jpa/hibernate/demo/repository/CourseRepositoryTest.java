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
import javax.transaction.Transactional;

@SpringBootTest
class CourseRepositoryTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    @Autowired
    CourseRepository courseRepository;

    @Test
    void findById() {
        Course course = courseRepository.findById(10001L);
        Assert.assertEquals("jpa in 50 steps", course.getName());
    }

    @Test
    @org.springframework.transaction.annotation.Transactional
    void findById_first_level_cache() {
        Course course = courseRepository.findById(10001L);
        logger.info("First course retrieved {}", course);
        Course course1 = courseRepository.findById(10001L);
        logger.info("First course retrieved {}", course1);
        Assert.assertEquals("jpa in 50 steps", course.getName());
        Assert.assertEquals("jpa in 50 steps", course1.getName());
    }

    @Test
    @DirtiesContext
    void deleyeById() {
        courseRepository.deleyeById(10002L);
        Assert.assertNull(courseRepository.findById(10002l));
    }

    @Test
    @DirtiesContext
    void save() {
        Course course = courseRepository.findById(10001L);
        Assert.assertEquals("jpa in 50 steps", course.getName());
        course.setName("jpa in 50 steps - updated");
        courseRepository.save(course);

        Course course1 = courseRepository.findById(10001L);
        Assert.assertEquals("jpa in 50 steps - updated", course1.getName());
    }

    @Test
    @DirtiesContext
    void playWithEntityManager() {
        courseRepository.playWithEntityManager();
    }

    @Test
    @DirtiesContext
    @Transactional
    void retrieveReviews4Course() {
        Course course = courseRepository.findById(10001L);
        logger.info("Reviews:  {}", course.getReviews());
    }

    @Test
    @DirtiesContext
    @Transactional
    void retrieveCourse4Review() {
        Review review = entityManager.find(Review.class, 50001L);
        logger.info("Courses: {}", review.getCourse());
    }

    @Test
    @org.springframework.transaction.annotation.Transactional(isolation = Isolation.DEFAULT)
    void retrieveCourse4Reviews() {
        Review review = entityManager.find(Review.class, 50001L);
        logger.info("Courses: {}", review.getCourse());
    }


}
