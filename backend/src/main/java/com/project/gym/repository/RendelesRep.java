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

/**
 * Rendelés repository interface.
 */
@Repository
public interface RendelesRep extends JpaRepository<Rendeles, Long> {

    /**
     * Rendeles olvas list.
     *
     * @return a listát amelyben benne van az összes rendelés és a hozzájuk tartozó adatok.
     */
    @Query(value = "{call RendelesOlvas()}", nativeQuery = true)
    List<Rendeles> RendelesOlvas();


    /**
     * Rendeles olvas by id iterable.
     *
     * @param rendelesID the rendeles id
     * @return iterable-t a megadott rendelésID-hoz tartozó rendelés adatokkal string formátumban.
     */
    @Procedure(name = "RendelesOlvasByID")
    Iterable<String> RendelesOlvasByID(@Param("rendelesID") Long rendelesID);


    /**
     * Rendeles olvas berlet by id iterable.
     *
     * @param rendelesID the rendeles id
     * @return iterable-t a megadott rendelésID-hoz tartozó bérlet adatokkal string formátumban.
     */
    @Procedure(name = "RendelesOlvasBerletByID")
    Iterable<String> RendelesOlvasBerletByID(@Param("rendelesID") Long rendelesID);


    /**
     * Rendeles olvas felhasznalo by id iterable.
     *
     * @param rendelesID the rendeles id
     * @return iterable-t a megadott rendelésID-hoz tartozó felhasználó adatokkal string formátumban.
     */
    @Procedure(name = "RendelesOlvasFelhasznaloByID")
    Iterable<String> RendelesOlvasFelhasznaloByID(@Param("rendelesID") Long rendelesID);


    /**
     * Rendeles olvas termek by id iterable.
     *
     * @param rendelesID the rendeles id
     * @return iterable-t a megadott ID-hoz tartozó termék adatokkal string formátumban.
     */
    @Procedure(name = "RendelesOlvasTermekByID")
    Iterable<String> RendelesOlvasTermekByID(@Param("rendelesID") Long rendelesID);


    /**
     * Rendeles letrehoz berlet.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     * @param megjegyzes        the megjegyzes
     * @param felhasznaloID     the felhasznalo id
     */
    @Transactional
    @Modifying
    @Query(value = "{call RendelesLetrehozBerlet(:berlet_vasarlasID, :megjegyzes, :felhasznaloID)}", nativeQuery = true)
    void RendelesLetrehozBerlet(
            @Param("berlet_vasarlasID") Long berlet_vasarlasID,
            @Param("megjegyzes") String megjegyzes,
            @Param("felhasznaloID") Long felhasznaloID
    );

    /**
     * Rendeles letrehoz termek.
     *
     * @param termekID      the termek id
     * @param megjegyzes    the megjegyzes
     * @param mennyiseg     the mennyiseg
     * @param felhasznaloID the felhasznalo id
     */
    @Transactional
    @Modifying
    @Query(value = "{call RendelesLetrehozTermek(:termekID, :megjegyzes, :mennyiseg, :felhasznaloID)}", nativeQuery = true)
    void RendelesLetrehozTermek(
            @Param("termekID") Long termekID,
            @Param("megjegyzes") String megjegyzes,
            @Param("mennyiseg") Integer mennyiseg,
            @Param("felhasznaloID") Long felhasznaloID
    );

    /**
     * Rendeles torles.
     *
     * @param rendelesID the rendeles id
     */
    @Transactional
    @Modifying
    @Query(value = "{call RendelesTorles(:rendelesID)}", nativeQuery = true)
    void RendelesTorles(@Param("rendelesID") Long rendelesID);

}
