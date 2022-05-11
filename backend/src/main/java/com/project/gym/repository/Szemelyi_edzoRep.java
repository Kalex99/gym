package com.project.gym.repository;

import com.project.gym.model.Szemelyi_edzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * személyi edző repository interface
 */
@Repository
public interface Szemelyi_edzoRep extends JpaRepository<Szemelyi_edzo, Long> {

    /**
     * Szemelyi edzo olvas list.
     *
     * @return a listát amelyben benne van az összes személyi edző adata.
     */
    @Query(value = "{call Szemelyi_edzoOlvas()}", nativeQuery = true)
    List<Szemelyi_edzo> Szemelyi_edzoOlvas();

    /**
     * Szemelyi edzo olvas by id iterable.
     *
     * @param szemelyi_edzoID the szemelyi edzo id
     * @return iterable-t a megadott személyiedzőID-hoz tartozó személyi edző adatokkal string formátumban.
     */
    @Procedure(name = "Szemelyi_edzoOlvasByID")
    Iterable<String> Szemelyi_edzoOlvasByID(@Param("szemelyi_edzoID") Long szemelyi_edzoID);

    /**
     * Szemelyi edzo letrehoz.
     *
     * @param szemedz_vezeteknev the szemedz vezeteknev
     * @param szemedz_keresztnev the szemedz keresztnev
     * @param szemedz_email      the szemedz email
     * @param szemedz_telefon    the szemedz telefon
     */
    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoLetrehoz(:szemedz_vezeteknev, :szemedz_keresztnev, :szemedz_email, :szemedz_telefon)}", nativeQuery = true)
    void Szemelyi_edzoLetrehoz(
            @Param("szemedz_vezeteknev") String szemedz_vezeteknev,
            @Param("szemedz_keresztnev") String szemedz_keresztnev,
            @Param("szemedz_email") String szemedz_email,
            @Param("szemedz_telefon") String szemedz_telefon
    );

    /**
     * Szemelyi edzo torles.
     *
     * @param szemelyi_edzoID the szemelyi edzo id
     */
    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoTorles(:szemelyi_edzoID)}", nativeQuery = true)
    void Szemelyi_edzoTorles(@Param("szemelyi_edzoID") Long szemelyi_edzoID);

    /**
     * Szemelyi edzo modosit.
     *
     * @param szemelyi_edzoID    the szemelyi edzo id
     * @param szemedz_vezeteknev the szemedz vezeteknev
     * @param szemedz_keresztnev the szemedz keresztnev
     * @param szemedz_email      the szemedz email
     * @param szemedz_telefon    the szemedz telefon
     */
    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoModosit(:szemelyi_edzoID,:szemedz_vezeteknev, :szemedz_keresztnev, :szemedz_email, :szemedz_telefon)}", nativeQuery = true)
    void Szemelyi_edzoModosit(
            @Param("szemelyi_edzoID") Long szemelyi_edzoID,
            @Param("szemedz_vezeteknev") String szemedz_vezeteknev,
            @Param("szemedz_keresztnev") String szemedz_keresztnev,
            @Param("szemedz_email") String szemedz_email,
            @Param("szemedz_telefon") String szemedz_telefon
    );
}
