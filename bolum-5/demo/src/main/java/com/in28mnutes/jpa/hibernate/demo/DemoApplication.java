package com.in28mnutes.jpa.hibernate.demo;

import com.in28mnutes.jpa.hibernate.demo.inheritance.FullTimeEmployee;
import com.in28mnutes.jpa.hibernate.demo.inheritance.PartTimeEmployee;
import com.in28mnutes.jpa.hibernate.demo.inheritanceRepository.EmployeeRepository;
import com.in28mnutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28mnutes.jpa.hibernate.demo.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        Course course = courseRepository.findById(10001L);
//		logger.info("Course 10001 is {}", course);
//        courseRepository.deleyeById(10001L);
//        courseRepository.save(new Course("Microservices in 100 steps"));
//        courseRepository.playWithEntityManager();
//        studentRepository.saveStudentWithPassport();

//        courseRepository.addReviewsForCOurse();
//        List<Review> reviews = new ArrayList<>();
//        reviews.add(new Review("5", "GreatHnadsof stuff"));
//        reviews.add(new Review("5", "hatsadas."));
//        courseRepository.addReviewsForCOurse(10003L, reviews);

//        studentRepository.insertStudentAndCourse();
//        studentRepository.insertStudentAndCourse2(new Student("asdas"), new Course("deneme"));

        // inheritance examples
//    employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
//    employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));
////    logger.info("employyes -> {}", employeeRepository.retrieveEmployees());
//
//    logger.info("emlopees -> {}", employeeRepository.retrieveAllParttimeEmployees());
//        logger.info("emlopees -> {}", employeeRepository.retrieveAllFulltimeEmployees());

    }
}
