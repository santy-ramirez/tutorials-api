package com.santi.tutorial.service.serviceImpl;

import com.santi.tutorial.domain.Tutorial;
import com.santi.tutorial.dto.TutorialDTO;
import com.santi.tutorial.repository.TutorialRepository;
import com.santi.tutorial.service.TutorialService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;


    ModelMapper modelMapper = new ModelMapper();

    @Override
    public String geAll(String hola) {
    return  hola;
    }

    @Override
    public TutorialDTO createTutorial(TutorialDTO tutorialDTO) {
        Tutorial tutorial = modelMapper.map(tutorialDTO,Tutorial.class);
        Tutorial tutorialToSave = tutorialRepository.save(tutorial);
        return modelMapper.map(tutorialToSave,TutorialDTO.class);
    }
}
