package com.ecole221.l3devweb.second.service.mapper;

import com.ecole221.l3devweb.common.service.dto.PersonneAgeDto;
import com.ecole221.l3devweb.second.service.entity.AgePersonne;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class PersonneMapper {


    public AgePersonne personneDtoToPersonneEntity(PersonneAgeDto personneDto) throws ParseException {
        return AgePersonne.builder()
                .personneId(personneDto.getPersonneId())
                .age(personneDto.getAge())
                .ageStatus(personneDto.getAgeStatus())
                .build();
    }

    public PersonneAgeDto personneEntityToPersonneDto(AgePersonne personne) throws ParseException {
        return PersonneAgeDto.builder()
                .personneId(personne.getPersonneId())
                .age(personne.getAge())
                .ageStatus(personne.getAgeStatus())
                .build();
    }

}
