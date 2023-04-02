package com.in28mnutes.jpa.hibernate.demo.repository;

import com.in28mnutes.jpa.hibernate.demo.entity.Course;
import com.in28mnutes.jpa.hibernate.demo.entity.Review;
import com.in28mnutes.jpa.hibernate.demo.entity.ReviewRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseRepository {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager entityManager;

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleyeById(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }

    public Course save(Course course) {
        if (course.getId() == null) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    public void playWithEntityManager() {
        Course course1 = new Course("WEb Service in 100 steps");
        entityManager.persist(course1);
        course1.setName("web services updated");
        entityManager.flush();
        Course course2 = new Course("angular");
        entityManager.flush();
        entityManager.persist(course2);
        entityManager.detach(course2);
        course2.setName("angular updated");
    }

    public void addReviewsForCOurse() {
        Course course = findById(10003L);
        logger.info("course.getReviews() ->  {}", course.getReviews());
        Review review = new Review(ReviewRating.FIVE, "Great hands-on Stuff.");
        Review review2 = new Review(ReviewRating.FIVE, "Hatssof");
        course.addReview(review);
        review.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);
        entityManager.persist(review);
        entityManager.persist(review2);
    }

    public void addReviewsForCOurse(Long courseId, List<Review> reviews) {
        Course course = findById(courseId);
        logger.info("course.getReviews() ->  {}", course.getReviews());

        for(Review review: reviews){
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
    }

}
