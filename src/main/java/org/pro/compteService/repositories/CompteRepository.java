package org.pro.compteService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.pro.compteService.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}