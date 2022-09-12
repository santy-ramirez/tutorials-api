package com.santi.tutorial.controller;

import com.santi.tutorial.dto.TutorialDTO;
import com.santi.tutorial.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("api/v1/tutorial")
public class TutorialController {
    @Autowired
    private TutorialService  tutorialService;
    @GetMapping(params = "hola")
    public String hola(@RequestParam String hola){
        return tutorialService.geAll(hola);
    }
    @PostMapping
    public ResponseEntity<?> createTutoriales(@RequestBody @Valid TutorialDTO tutorialDTO){
        return new ResponseEntity<>(tutorialService.createTutorial(tutorialDTO), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTutoriales(){
        return new ResponseEntity<>(tutorialService.getAllTutorials(),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getTutorialForId(@PathVariable Long id){
        return new ResponseEntity<>(tutorialService.getTutorialForId(id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public  ResponseEntity<?> deleteTutorial(@PathVariable Long id){
        tutorialService.updateTutorial(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteAllTutorial(){
        tutorialService.deleteAllTutorials();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<?> updateTutorial(@PathVariable Long id, @RequestBody @Valid TutorialDTO tutorialDTO){
        return new ResponseEntity<>(tutorialService.updateTutorial(id,tutorialDTO),HttpStatus.OK);
    }
    @GetMapping(params = "published")
    public ResponseEntity<?> getAllTutorials(@RequestParam Boolean published){
        return new ResponseEntity<>(tutorialService.getAllTutorialPublished(published),HttpStatus.OK);
    }

    @GetMapping(params = "query")
    public ResponseEntity<?> testQuery(@RequestParam String query){
        return new ResponseEntity<>(tutorialService.testQuery(query),HttpStatus.OK);
    }


}
