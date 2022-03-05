package com.project.gym.repository;

import com.project.gym.model.Rendeles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface RendelesRep extends JpaRepository<Rendeles, Long> {
    @Procedure(name = "RendelesOlvasas")
    String RendelesOlvasas(@Param("rendelesID") Long rendelesID);

    @Procedure(name = "RendelesOlvasasBerlet")
    String RendelesOlvasasBerlet(@Param("rendelesID") Long rendelesID);

    @Procedure(name = "RendelesOlvasasFelhasznalo")
    String RendelesOlvasasFelhasznalo(@Param("rendelesID") Long rendelesID);

    @Procedure(name = "RendelesOlvasasTermek")
    String RendelesOlvasasTermek(@Param("rendelesID") Long rendelesID);


    @Transactional
    @Modifying
    @Query(value = "{call RendelesLetrehoz(:megjegyzes, :termekID, :berlet_vasarlasID, :felhasznaloID)}", nativeQuery = true)
    void RendelesLetrehoz(
            @Param("megjegyzes") String berlet_tipus,
            @Param("termekID") Long termekID,
            @Param("berlet_vasarlasID") Long berlet_vasarlasID,
            @Param("felhasznaloID") Long felhasznaloID
    );

    @Transactional
    @Modifying
    @Query(value = "{call RendelesTorles(:rendelesID)}", nativeQuery = true)
    void RendelesTorles(@Param("rendelesID") Long rendelesID);

}
