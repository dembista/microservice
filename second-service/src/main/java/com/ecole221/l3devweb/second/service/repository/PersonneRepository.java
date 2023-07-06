package com.ecole221.l3devweb.second.service.repository;

import com.ecole221.l3devweb.second.service.entity.AgePersonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonneRepository extends JpaRepository<AgePersonne,UUID > {
}
