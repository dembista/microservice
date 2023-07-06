package com.ecole221.l3devweb.second.service.service;

import com.ecole221.l3devweb.common.service.dto.PersonneAgeDto;
import com.ecole221.l3devweb.common.service.dto.PersonneDto;
import com.ecole221.l3devweb.common.service.event.AgeStatus;
import com.ecole221.l3devweb.common.service.event.PersonneStatus;
import com.ecole221.l3devweb.second.service.entity.AgePersonne;
import com.ecole221.l3devweb.second.service.mapper.PersonneMapper;
import com.ecole221.l3devweb.second.service.repository.AgePersonneRepositorie;
import com.ecole221.l3devweb.second.service.repository.PersonneRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PersonneService {

    private final AgePersonneRepositorie personneRepository;
    //private final PersonneRepository personneRepositorys;

    private final PersonneMapper personneMapper;


    public PersonneService(AgePersonneRepositorie personneRepository, PersonneMapper personneMapper) {
        this.personneRepository = personneRepository;
        this.personneMapper = personneMapper;
    }

    public AgePersonne save(PersonneAgeDto personneDto) throws ParseException {

        personneDto.setAgeStatus(AgeStatus.INIT);
      return   personneRepository.save(personneMapper.personneDtoToPersonneEntity(personneDto));
    }

    public List<PersonneAgeDto> allPersonnes(){
        return  personneRepository.findAll().stream()
                .map(personne -> new PersonneAgeDto(personne.getPersonneId(),personne.getAge(),
                      personne.getAgeStatus()))
                .toList();
    }
}
