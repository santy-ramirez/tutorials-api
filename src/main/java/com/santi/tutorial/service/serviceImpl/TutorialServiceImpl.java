package com.santi.tutorial.service.serviceImpl;

import com.santi.tutorial.domain.Tutorial;
import com.santi.tutorial.dto.TutorialDTO;
import com.santi.tutorial.mapper.TutorialMapper;
import com.santi.tutorial.repository.TutorialRepository;
import com.santi.tutorial.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    private TutorialRepository tutorialRepository;
    @Autowired
    private TutorialMapper tutorialMapper;


    @Override
    public String geAll(String hola) {
    return  hola;
    }

    @Override
    public TutorialDTO createTutorial(TutorialDTO tutorialDTO) {
        Tutorial tutorial = tutorialMapper.toEntityTutorial(tutorialDTO);
        Tutorial tutorialToSave = tutorialRepository.save(tutorial);
        return tutorialMapper.toDtoTutorialDto(tutorialToSave);
    }

    @Override
    public List<TutorialDTO> getAllTutoriales() {
        List<Tutorial> tutorials = tutorialRepository.findAll();
        return tutorials.stream().map(tutorial -> tutorialMapper.toDtoTutorialDto(tutorial)).collect(Collectors.toList());
    }


}
