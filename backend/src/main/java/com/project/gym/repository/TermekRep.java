package com.project.gym.repository;

import com.project.gym.model.Termek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface TermekRep extends JpaRepository<Termek, Long> {

    @Query(value = "{call TermekOlvas()}", nativeQuery = true)
    List<Termek> TermekOlvas();

    @Procedure(name = "TermekOlvasByID")
    Iterable<String> TermekOlvasByID(@Param("termekID") Long termekID);

    @Transactional
    @Modifying
    @Query(value = "{call TermekLetrehoz(:termek_nev, :ar, :keszlet, :leiras)}", nativeQuery = true)
    void TermekLetrehoz(
            @Param("termek_nev") String termek_nev,
            @Param("ar") Integer ar,
            @Param("keszlet") Integer keszlet,
            @Param("leiras") String leiras
    );

    @Transactional
    @Modifying
    @Query(value = "{call TermekTorles(:termekID)}", nativeQuery = true)
    void TermekTorles(@Param("termekID") Long termekID);

    @Transactional
    @Modifying
    @Query(value = "{call TermekModosit(:termekID,:termek_nev, :ar, :keszlet, :kaphato, :leiras)}", nativeQuery = true)
    void TermekModosit(
            @Param("termekID") Long termekID,
            @Param("termek_nev") String termek_nev,
            @Param("ar") Integer ar,
            @Param("keszlet") Integer keszlet,
            @Param("kaphato") Boolean kaphato,
            @Param("leiras") String leiras
    );
}
