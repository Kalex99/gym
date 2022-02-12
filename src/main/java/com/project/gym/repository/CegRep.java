package com.project.gym.repository;

import com.project.gym.model.Ceg;
import com.project.gym.model.Felhasznalo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CegRep extends JpaRepository<Ceg,Integer> {
}
