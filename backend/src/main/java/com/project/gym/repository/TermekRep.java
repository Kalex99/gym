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

/**
 * Termék repositry interface.
 */
@Repository
public interface TermekRep extends JpaRepository<Termek, Long> {

    /**
     * Termek olvas list.
     *
     * @return a listát amelyben benne van az összes termék adata.
     */
    @Query(value = "{call TermekOlvas()}", nativeQuery = true)
    List<Termek> TermekOlvas();

    /**
     * Termek olvas by id iterable.
     *
     * @param termekID the termek id
     * @return iterable-t a megadott termekID-hoz tartozó termék adatokkal string formátumban.
     */
    @Procedure(name = "TermekOlvasByID")
    Iterable<String> TermekOlvasByID(@Param("termekID") Long termekID);

    /**
     * Termek letrehoz.
     *
     * @param termek_nev the termek nev
     * @param ar         the ar
     * @param keszlet    the keszlet
     * @param leiras     the leiras
     */
    @Transactional
    @Modifying
    @Query(value = "{call TermekLetrehoz(:termek_nev, :ar, :keszlet, :leiras)}", nativeQuery = true)
    void TermekLetrehoz(
            @Param("termek_nev") String termek_nev,
            @Param("ar") Integer ar,
            @Param("keszlet") Integer keszlet,
            @Param("leiras") String leiras
    );

    /**
     * Termek torles.
     *
     * @param termekID the termek id
     */
    @Transactional
    @Modifying
    @Query(value = "{call TermekTorles(:termekID)}", nativeQuery = true)
    void TermekTorles(@Param("termekID") Long termekID);

    /**
     * Termek modosit.
     *
     * @param termekID   the termek id
     * @param termek_nev the termek nev
     * @param ar         the ar
     * @param keszlet    the keszlet
     * @param kaphato    the kaphato
     * @param leiras     the leiras
     */
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
