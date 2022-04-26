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

@Repository
public interface Szemelyi_edzoRep extends JpaRepository<Szemelyi_edzo, Long> {

    @Query(value = "{call Szemelyi_edzoOlvas()}", nativeQuery = true)
    List<Szemelyi_edzo> Szemelyi_edzoOlvas();

    @Procedure(name = "Szemelyi_edzoOlvasByID")
    Iterable<String> Szemelyi_edzoOlvasByID(@Param("szemelyi_edzoID") Long szemelyi_edzoID);

    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoLetrehoz(:szemedz_vezeteknev, :szemedz_keresztnev, :portre, :szemedz_email, :szemedz_telefon)}", nativeQuery = true)
    void Szemelyi_edzoLetrehoz(
            @Param("szemedz_vezeteknev") String szemedz_vezeteknev,
            @Param("szemedz_keresztnev") String szemedz_keresztnev,
            @Param("portre") byte[] portre,
            @Param("szemedz_email") String szemedz_email,
            @Param("szemedz_telefon") String szemedz_telefon
    );

    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoTorles(:szemelyi_edzoID)}", nativeQuery = true)
    void Szemelyi_edzoTorles(@Param("szemelyi_edzoID") Long szemelyi_edzoID);

    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoModosit(:szemelyi_edzoID,:szemedz_vezeteknev, :szemedz_keresztnev, :portre, :szemedz_email, :szemedz_telefon)}", nativeQuery = true)
    void Szemelyi_edzoModosit(
            @Param("szemelyi_edzoID") Long szemelyi_edzoID,
            @Param("szemedz_vezeteknev") String szemedz_vezeteknev,
            @Param("szemedz_keresztnev") String szemedz_keresztnev,
            @Param("portre") byte[] portre,
            @Param("szemedz_email") String szemedz_email,
            @Param("szemedz_telefon") String szemedz_telefon
    );
}
