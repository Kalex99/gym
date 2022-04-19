package com.project.gym.repository;

import com.project.gym.model.Rendeles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface RendelesRep extends JpaRepository<Rendeles, Long> {

    @Query(value = "{call RendelesOlvas()}", nativeQuery = true)
    List<Rendeles> RendelesOlvas();

    @Procedure(name = "RendelesOlvasByID")
    Iterable<String> RendelesOlvasByID(@Param("rendelesID") Long rendelesID);

    @Procedure(name = "RendelesOlvasBerletByID")
    Iterable<String> RendelesOlvasBerletByID(@Param("rendelesID") Long rendelesID);

    @Procedure(name = "RendelesOlvasFelhasznaloByID")
    Iterable<String> RendelesOlvasFelhasznaloByID(@Param("rendelesID") Long rendelesID);

    @Procedure(name = "RendelesOlvasTermekByID")
    Iterable<String> RendelesOlvasTermekByID(@Param("rendelesID") Long rendelesID);


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
