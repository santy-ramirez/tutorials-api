package com.santi.tutorial.controller;

import com.santi.tutorial.dto.TutorialDTO;
import com.santi.tutorial.service.TutorialService;
import com.santi.tutorial.service.serviceImpl.TutorialServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tutorial")
public class TutorialController {
    @Autowired
    private TutorialService  tutorialService;
    @GetMapping()
    public String hola(@RequestParam String hola){
        return tutorialService.geAll(hola);
    }
    @PostMapping
    public ResponseEntity<?> createTutoriales(@RequestBody TutorialDTO tutorialDTO){
        return new ResponseEntity<>(tutorialService.createTutorial(tutorialDTO), HttpStatus.OK);
    }
}
