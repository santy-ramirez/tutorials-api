package com.santi.tutorial.service;

import com.santi.tutorial.dto.TutorialDTO;

import java.util.List;


public interface TutorialService {

    public String geAll(String hola);
    public TutorialDTO createTutorial(TutorialDTO tutorialDTO);
    public List<TutorialDTO> getAllTutoriales();




}
