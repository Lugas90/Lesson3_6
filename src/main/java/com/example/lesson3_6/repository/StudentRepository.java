package com.example.lesson3_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lesson3_6.model.Student;

import java.util.Collection;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {
    Collection <Student> findStudentsByAge(int age);

    Collection<Student> findStudentsByAgeBetween(int min, int max);
}

