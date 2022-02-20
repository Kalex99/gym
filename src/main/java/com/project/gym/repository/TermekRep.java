package com.project.gym.repository;

import com.project.gym.model.Felhasznalo;
import com.project.gym.model.Termek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermekRep extends JpaRepository<Termek,Long> {
}
