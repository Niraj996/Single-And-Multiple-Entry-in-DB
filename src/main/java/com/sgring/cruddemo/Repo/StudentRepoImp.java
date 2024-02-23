package com.sgring.cruddemo.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sgring.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository // Supports Component Scan also translates JDBC exception
public class StudentRepoImp implements StudentRepo {

    /*
     * define field for entity manager-> why do we need entityManager ->
     * to create and remove persistent entity instances
     * to find entities by their primary key, and to query over entities
     */
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public StudentRepoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional // https://www.geeksforgeeks.org/spring-boot-transaction-management-using-transactional-annotation/#:~:text=In%20Spring%20Boot%2C%20%40Transactional%20annotation,provides%20data%20reliability%20and%20consistency.
    public void save(Student theStudent) {
            entityManager.persist(theStudent); // this will actually save the student entity
    }

}
