package com.ecole221.l3devweb.first.controller;


import com.ecole221.l3devweb.common.service.dto.PersonneDto;
import com.ecole221.l3devweb.first.entity.Personne;
import com.ecole221.l3devweb.first.service.PersonneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;

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
    public ResponseEntity<Object> save(@RequestBody  PersonneDto personneDto) throws ParseException {

        Personne personne = personneService.save(personneDto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(personne.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

}
