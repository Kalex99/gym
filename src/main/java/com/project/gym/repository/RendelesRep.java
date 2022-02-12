package com.project.gym.repository;

import com.project.gym.model.Felhasznalo;
import com.project.gym.model.Rendeles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendelesRep extends JpaRepository<Rendeles,Integer> {
}
