package com.ecole221.l3devweb.first.entity;

import com.ecole221.l3devweb.common.service.event.AgeStatus;
import com.ecole221.l3devweb.common.service.event.PersonneStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID id;

    private String nomComplet;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;

    private PersonneStatus personneStatus;

    private AgeStatus ageStatus;




}
