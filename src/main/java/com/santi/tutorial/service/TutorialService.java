package com.santi.tutorial.service;

import com.santi.tutorial.dto.TutorialDTO;
import org.springframework.stereotype.Service;


public interface TutorialService {

    public String geAll(String hola);
    public TutorialDTO createTutorial(TutorialDTO tutorialDTO);

}
