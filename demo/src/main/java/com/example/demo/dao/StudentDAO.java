package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void save(Student student) {
        entityManager.persist(student);
    }

    public void update(Student student) {
        entityManager.merge(student);
    }

    public void delete(Student student) {
        entityManager.remove(student);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    public List<Student> findByName(String name) {
        return entityManager.createQuery("from Student where name = :name", Student.class)
                .setParameter("name", name)
                .getResultList();
    }
}