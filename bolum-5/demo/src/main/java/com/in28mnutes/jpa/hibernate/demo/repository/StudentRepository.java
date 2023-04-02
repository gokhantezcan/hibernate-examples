package com.in28mnutes.jpa.hibernate.demo.repository;

import com.in28mnutes.jpa.hibernate.demo.entity.Course;
import com.in28mnutes.jpa.hibernate.demo.entity.Passport;
import com.in28mnutes.jpa.hibernate.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    private EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void deleyeById(Long id) {
        Student Student = findById(id);
        entityManager.remove(Student);
    }

    public Student save(Student Student) {
        if (Student.getId() == null) {
            entityManager.persist(Student);
        } else {
            entityManager.merge(Student);
        }
        return Student;
    }

    public void saveStudentWithPassport() {
        Passport passport = new Passport("Z324234");
        entityManager.persist(passport);
        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }

    public void insertStudentAndCourse(){
        Student student = new Student("Jack");
        Course course = new Course("microserivicce");
        entityManager.persist(student);
        entityManager.persist(course);

        student.addCourse(course);
        course.addStudent(student);
//        entityManager.persist(student); // owning side bu ksıım çünkü
    }

    public void insertStudentAndCourse2(Student student, Course course){
        entityManager.persist(student);
        entityManager.persist(course);
        student.addCourse(course);
        course.addStudent(student);
    }

}
