package com.santi.tutorial.repository;

import com.santi.tutorial.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial,Long> , JpaSpecificationExecutor<Tutorial> {
    List<Tutorial> findByPublished(Boolean published);
   // List<Tutorial> findByTitleContaining(String query);
    List<Tutorial> findByTitleContaining(String title);
    List<Tutorial> findByDescriptionContaining(String description);
    List<Tutorial> findByTitleAndDescriptionContaining(String title, String description);

}
