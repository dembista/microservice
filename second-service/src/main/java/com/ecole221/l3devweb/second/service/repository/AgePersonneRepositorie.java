package com.ecole221.l3devweb.second.service.repository;

import com.ecole221.l3devweb.second.service.entity.AgePersonne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AgePersonneRepositorie extends JpaRepository<AgePersonne, UUID> {

}
