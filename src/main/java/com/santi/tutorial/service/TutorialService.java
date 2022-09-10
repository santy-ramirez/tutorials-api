package com.santi.tutorial.service;

import com.santi.tutorial.dto.TutorialDTO;

import java.util.List;


public interface TutorialService {

    public String geAll(String hola);
    public TutorialDTO createTutorial(TutorialDTO tutorialDTO);
    public List<TutorialDTO> getAllTutorials();
    public  TutorialDTO getTutorialForId(Long id);
    public void updateTutorial(Long id);
    public TutorialDTO updateTutorial(Long id, TutorialDTO tutorialDTO);
    public void  deleteAllTutorials();

    public List<TutorialDTO> getAllTutorialPublished(Boolean published);




}
