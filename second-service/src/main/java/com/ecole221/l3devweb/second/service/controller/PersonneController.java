package com.ecole221.l3devweb.second.service.controller;


import com.ecole221.l3devweb.common.service.dto.PersonneAgeDto;
import com.ecole221.l3devweb.common.service.dto.PersonneDto;
import com.ecole221.l3devweb.second.service.entity.AgePersonne;
import com.ecole221.l3devweb.second.service.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.time.LocalDate;

@RestController
public class PersonneController {

    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @ResponseBody
    @GetMapping("/personne/all")
    public ResponseEntity getAll(){
        return new ResponseEntity(personneService.allPersonnes(), HttpStatus.OK);
    }

    @PostMapping("/personne/add")
    public ResponseEntity<Object> save(@RequestBody PersonneAgeDto personneDto) throws ParseException {

        AgePersonne personne = personneService.save(personneDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(personne.getPersonneId()).toUri();

        return ResponseEntity.created(location).build();

    }

}
