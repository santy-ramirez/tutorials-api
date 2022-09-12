package com.santi.tutorial.service.serviceImpl;

import com.santi.tutorial.domain.Tutorial;
import com.santi.tutorial.dto.TutorialDTO;
import com.santi.tutorial.exepcion.NotFoundTutorialException;
import com.santi.tutorial.mapper.TutorialMapper;
import com.santi.tutorial.repository.TutorialRepository;
import com.santi.tutorial.service.TutorialService;
import com.santi.tutorial.specf.TitleSpecf;
import com.santi.tutorial.specf.DescriptionSpecf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
        tutorial.setPublished(true);
        Tutorial tutorialToSave = tutorialRepository.save(tutorial);
        return tutorialMapper.toDtoTutorial(tutorialToSave);
    }

    @Override
    public List<TutorialDTO> getAllTutorials() {
        List<Tutorial> tutorials = tutorialRepository.findAll();
        return tutorials.stream().map(tutorial -> tutorialMapper.toDtoTutorial(tutorial)).collect(Collectors.toList());
    }

    @Override
    public TutorialDTO getTutorialForId(Long id) {
        Tutorial tutorial = tutorialRepository.findById(id).orElseThrow(
                ()->   new NotFoundTutorialException("Not Found tutorial with id number: " + id)
        );
        return tutorialMapper.toDtoTutorial(tutorial);
    }

    @Override
    public void updateTutorial(Long id) {
        tutorialRepository.deleteById(id);
    }

    @Override
    public TutorialDTO updateTutorial(Long id, TutorialDTO tutorialDTO) {
        Tutorial tutorialEntity = tutorialRepository.findById(id).orElseThrow(
                ()-> new NotFoundTutorialException("Not Found Tutorial with id number: " + id)
        );
        tutorialEntity.setId(id);
        tutorialEntity.setTitle(tutorialDTO.getTitle());
        tutorialEntity.setDescription(tutorialDTO.getDescription());
        return tutorialMapper.toDtoTutorial(tutorialEntity);
    }

    @Override
    public void deleteAllTutorials() {
        tutorialRepository.deleteAll();
    }

    @Override
    public List<TutorialDTO> getAllTutorialPublished(Boolean published) {
        List<Tutorial> tutorials = tutorialRepository.findByPublished(published);
        return tutorials.stream().map(tutorial -> tutorialMapper.toDtoTutorial(tutorial)).collect(Collectors.toList());
    }

  /*  @Override
    public List<TutorialDTO> testQuery(String query) {
        List<Tutorial> tutorials = tutorialRepository.findByTitleContaining(query);


        return tutorials.stream().map(tutorial -> tutorialMapper.toDtoTutorial(tutorial)).collect(Collectors.toList());
    }*/

    @Override
    public List<TutorialDTO> testEspecification(String title,String description) {
       List<Tutorial> tutorials = tutorialRepository.findAll(Specification.where(new TitleSpecf(title).or(new DescriptionSpecf(title,description))));
       return tutorials.stream().map(tutorial -> tutorialMapper.toDtoTutorial(tutorial)).collect(Collectors.toList());
    }

}
