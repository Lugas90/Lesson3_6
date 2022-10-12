package com.example.lesson3_6.service;

import org.springframework.stereotype.Service;
import com.example.lesson3_6.model.Faculty;
import com.example.lesson3_6.repository.FacultyRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(Long id, Faculty faculty) {
        Optional<Faculty> optional = facultyRepository.findById(id);
        if (optional.isPresent()) {
            Faculty fromDB = optional.get();
            fromDB.setName(fromDB.getName());
            fromDB.setColor(fromDB.getColor());
            return facultyRepository.save(fromDB);
        }
        return null;
    }

    public void deleteFaculty(Long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getFacultyToColor(String color) {
        return facultyRepository.findFacultyByColor(color);
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findFacultyByColorIgnoreCaseOrNameIgnoreCase(String color, String name) {
        return facultyRepository.findFacultyByColorIgnoreCaseOrNameIgnoreCase(color, name);
    }
}
