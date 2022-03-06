package com.project.gym.repository;

import com.project.gym.model.Felhasznaloszemelyiedzo;
import com.project.gym.model.Szemelyi_edzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FelhasznaloSzemelyiEdzoRep {


/*    @Procedure(name = "Szemelyi_edzoOlvasasFelhasznalo")
    String Szemelyi_edzoOlvasasFelhasznalo(@Param("szemelyi_edzoID") Long szemelyi_edzoID);*/
}
