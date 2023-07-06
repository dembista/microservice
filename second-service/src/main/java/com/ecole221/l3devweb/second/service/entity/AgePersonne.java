package com.ecole221.l3devweb.second.service.entity;

import com.ecole221.l3devweb.common.service.event.AgeStatus;
import com.ecole221.l3devweb.common.service.event.PersonneStatus;
import com.ecole221.l3devweb.first.entity.Personne;
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
public class AgePersonne {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, columnDefinition = "UUID default gen_random_uuid()")
    private UUID personneId;

    private AgeStatus ageStatus;
    private long age;

    /*@ManyToOne
    @JoinColumn(name = "personne" ,referencedColumnName = "id")
    private Personne personne;*/

}
