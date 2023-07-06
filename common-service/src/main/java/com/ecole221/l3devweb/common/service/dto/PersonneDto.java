package com.ecole221.l3devweb.common.service.dto;

import com.ecole221.l3devweb.common.service.event.AgeStatus;
import com.ecole221.l3devweb.common.service.event.PersonneStatus;
import lombok.*;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneDto {

    private UUID id;

    private String nomComplet;

    private String dateNaissance;

    private PersonneStatus personneStatus;

    private AgeStatus ageStatus;


}
