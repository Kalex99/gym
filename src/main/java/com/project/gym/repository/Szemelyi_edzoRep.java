package com.project.gym.repository;

import com.project.gym.model.Szemelyi_edzo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Szemelyi_edzoRep extends JpaRepository<Szemelyi_edzo, Long> {

    @Procedure(name = "Szemelyi_edzoOlvasas")
    Iterable<String> Szemelyi_edzoOlvasas(@Param("szemelyi_edzoID") Long szemelyi_edzoID);

    @Procedure(name = "Szemelyi_edzoOlvasasFelhasznalo")
    Iterable<String> Szemelyi_edzoOlvasasFelhasznalo(@Param("szemelyi_edzoID") Long szemelyi_edzoID);

    @Procedure(name = "Szemelyi_edzoOlvasasTartozkodasihely")
    Iterable<String> Szemelyi_edzoOlvasasTartozkodasihely(@Param("szemelyi_edzoID") Long szemelyi_edzoID);


    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoLetrehoz(:szemedz_vezeteknev, :szemedz_keresztnev, :portre, :szemedz_email, :szemedz_telefon, :tartozkodasihelyID)}", nativeQuery = true)
    void Szemelyi_edzoLetrehoz(
            @Param("szemedz_vezeteknev") String szemedz_vezeteknev,
            @Param("szemedz_keresztnev") String szemedz_keresztnev,
            @Param("portre") byte[] portre,
            @Param("szemedz_email") String szemedz_email,
            @Param("szemedz_telefon") String szemedz_telefon,
            @Param("tartozkodasihelyID") Long tartozkodasihelyID
    );

    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoTorles(:szemelyi_edzoID)}", nativeQuery = true)
    void Szemelyi_edzoTorles(@Param("szemelyi_edzoID") Long szemelyi_edzoID);

    @Transactional
    @Modifying
    @Query(value = "{call Szemelyi_edzoModosit(:szemelyi_edzoID,:szemedz_vezeteknev, :szemedz_keresztnev, :portre, :szemedz_email, :szemedz_telefon, :tartozkodasihelyID)}", nativeQuery = true)
    void Szemelyi_edzoModosit(
            @Param("szemelyi_edzoID") Long szemelyi_edzoID,
            @Param("szemedz_vezeteknev") String szemedz_vezeteknev,
            @Param("szemedz_keresztnev") String szemedz_keresztnev,
            @Param("portre") byte[] portre,
            @Param("szemedz_email") String szemedz_email,
            @Param("szemedz_telefon") String szemedz_telefon,
            @Param("tartozkodasihelyID") Long tartozkodasihelyID
    );
}
