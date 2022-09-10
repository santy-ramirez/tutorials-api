package com.santi.tutorial.repository;

import com.santi.tutorial.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial,Long> {
    List<Tutorial> findByPublished(Boolean published);
}
