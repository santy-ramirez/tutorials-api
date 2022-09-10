package com.santi.tutorial.mapper;

import com.santi.tutorial.domain.Tutorial;
import com.santi.tutorial.dto.TutorialDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.FIELD)
public interface TutorialMapper {


TutorialDTO toDtoTutorial(Tutorial tutorial);

Tutorial toEntityTutorial(TutorialDTO tutorialDTO);


}
