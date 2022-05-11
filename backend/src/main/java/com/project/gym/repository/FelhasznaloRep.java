package com.project.gym.repository;

import com.project.gym.model.Felhasznalo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Felhasználó repository interface.
 */
@Repository
public interface FelhasznaloRep extends JpaRepository<Felhasznalo, Long> {

    /**
     * Felhasznalo olvas list.
     *
     * @return egy listát amelyben benne van az összes felhasználó és a hozzájuk tartozó adatok.
     */
    @Query(value = "{call FelhasznaloOlvas()}", nativeQuery = true)
    List<Felhasznalo> FelhasznaloOlvas();


    /**
     * Felhasznalo olvas by id iterable.
     *
     * @param felhasznaloID the felhasznalo id
     * @return egy iterable-t a megadott ID-hoz tartozó felhasználói adatokkal egy stringben.
     */
    @Procedure(name = "FelhasznaloOlvasByID")
    Iterable<String> FelhasznaloOlvasByID(@Param("felhasznaloID") Long felhasznaloID);

    /**
     * Felhasznalo letrehoz.
     *
     * @param felhasznalonev  the felhasznalonev
     * @param jelszo          the jelszo
     * @param felh_vezeteknev the felh vezeteknev
     * @param felh_keresztnev the felh keresztnev
     * @param felh_email      the felh email
     * @param szuletesi_datum the szuletesi datum
     * @param felh_telefon    the felh telefon
     */
    @Transactional
    @Modifying
    @Query(value = "{call FelhasznaloLetrehoz(:felhasznalonev, :jelszo, :felh_vezeteknev, :felh_keresztnev, :felh_email, :szuletesi_datum, :felh_telefon)}", nativeQuery = true)
    void FelhasznaloLetrehoz(
            @Param("felhasznalonev") String felhasznalonev,
            @Param("jelszo") String jelszo,
            @Param("felh_vezeteknev") String felh_vezeteknev,
            @Param("felh_keresztnev") String felh_keresztnev,
            @Param("felh_email") String felh_email,
            @Param("szuletesi_datum") Date szuletesi_datum,
            @Param("felh_telefon") String felh_telefon
    );

    /**
     * Felhasznalo torles.
     *
     * @param felhasznaloID the felhasznalo id
     */
    @Transactional
    @Modifying
    @Query(value = "{call FelhasznaloTorles(:felhasznaloID)}", nativeQuery = true)
    void FelhasznaloTorles(@Param("felhasznaloID") Long felhasznaloID);

    /**
     * Felhasznalo modosit.
     *
     * @param felhasznaloID   the felhasznalo id
     * @param felhasznalonev  the felhasznalonev
     * @param jelszo          the jelszo
     * @param felh_vezeteknev the felh vezeteknev
     * @param felh_keresztnev the felh keresztnev
     * @param felh_email      the felh email
     * @param felh_telefon    the felh telefon
     */
    @Transactional
    @Modifying
    @Query(value = "{call FelhasznaloModosit(:felhasznaloID,:felhasznalonev, :jelszo, :felh_vezeteknev, :felh_keresztnev, :felh_email, :felh_telefon)}", nativeQuery = true)
    void FelhasznaloModosit(
            @Param("felhasznaloID") Long felhasznaloID,
            @Param("felhasznalonev") String felhasznalonev,
            @Param("jelszo") String jelszo,
            @Param("felh_vezeteknev") String felh_vezeteknev,
            @Param("felh_keresztnev") String felh_keresztnev,
            @Param("felh_email") String felh_email,
            @Param("felh_telefon") String felh_telefon
    );

}
