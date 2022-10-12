package com.example.lesson3_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lesson3_6.model.Faculty;

import java.util.Collection;

@Repository
public interface FacultyRepository extends JpaRepository <Faculty, Long> {

    Collection<Faculty> findFacultyByColor(String color);

    Collection<Faculty> findFacultyByColorIgnoreCaseOrNameIgnoreCase(String color, String name);
}
