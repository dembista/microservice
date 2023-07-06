package com.ecole221.l3devweb.common.service.dto;

import com.ecole221.l3devweb.common.service.event.AgeStatus;
import lombok.*;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonneAgeDto {

    private UUID personneId;

    private long age;

    private AgeStatus ageStatus;

}
