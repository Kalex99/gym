package com.project.gym.repository;

import com.project.gym.model.Termek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TermekRep extends JpaRepository<Termek, Long> {

    @Procedure(name = "TermekOlvasas")
    String TermekOlvasas(@Param("termekID") Long termekID);

    @Procedure(name = "TermekOlvasasCeg")
    String TermekOlvasasCeg(@Param("termekID") Long termekID);


    @Transactional
    @Modifying
    @Query(value = "{call TermekLetrehoz(:termek_nev, :kategoria, :ar, :kep, :keszlet, :leiras, :cegID)}", nativeQuery = true)
    void TermekLetrehoz(
            @Param("termek_nev") String termek_nev,
            @Param("kategoria") String kategoria,
            @Param("ar") Integer ar,
            @Param("kep") byte[] kep,
            @Param("keszlet") Integer keszlet,
            @Param("leiras") String leiras,
            @Param("cegID") Long cegID
    );

    @Transactional
    @Modifying
    @Query(value = "{call TermekTorles(:termekID)}", nativeQuery = true)
    void TermekTorles(@Param("termekID") Long termekID);

    @Transactional
    @Modifying
    @Query(value = "{call TermekModosit(:termekID,:termek_nev, :kategoria, :ar, :kep, :keszlet, :kaphato, :leiras, :cegID)}", nativeQuery = true)
    void TermekModosit(
            @Param("termekID") Long termekID,
            @Param("termek_nev") String termek_nev,
            @Param("kategoria") String kategoria,
            @Param("ar") Integer ar,
            @Param("kep") byte[] kep,
            @Param("keszlet") Integer keszlet,
            @Param("kaphato") Boolean kaphato,
            @Param("leiras") String leiras,
            @Param("cegID") Long cegID
    );
}
