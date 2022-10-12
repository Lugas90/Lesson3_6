package com.example.lesson3_6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.lesson3_6.model.Avatar;

import java.util.Optional;

@Repository
public interface AvatarRepository extends JpaRepository <Avatar, Long> {

    Optional<Avatar> findByStudentId (Long studentId);
}
