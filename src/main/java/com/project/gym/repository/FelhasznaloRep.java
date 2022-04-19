package com.project.gym.repository;

import com.project.gym.model.Felhasznalo;
import com.project.gym.model.Tartozkodasihely;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
public interface FelhasznaloRep extends JpaRepository<Felhasznalo, Long> {

    @Query(value = "{call FelhasznaloOlvas()}", nativeQuery = true)
    List<Felhasznalo> FelhasznaloOlvas();


    @Procedure(name = "BejelentkezesRendeles")
    Iterable<String> BejelentkezesRendeles(@Param("felhasznaloID") Long felhasznaloID);

    @Procedure(name = "FelhasznaloOlvasByID")
    Iterable<String> FelhasznaloOlvasByID(@Param("felhasznaloID") Long felhasznaloID);

    @Procedure(name = "BejelentkezesSzemelyiEdzo")
    Iterable<String> BejelentkezesSzemelyiEdzo(@Param("felhasznaloID") Long felhasznaloID);

    @Procedure(name = "BejelentkezesTartozkodasihely")
    Iterable<String> BejelentkezesTartozkodasihely(@Param("felhasznaloID") Long felhasznaloID);


    @Transactional
    @Modifying
    @Query(value = "{call FelhasznaloLetrehoz(:felhasznalonev, :jelszo, :felh_vezeteknev, :felh_keresztnev, :felh_email, :szuletesi_datum, :felh_telefon, :tartozkodasihelyID)}", nativeQuery = true)
    void FelhasznaloLetrehoz(
            @Param("felhasznalonev") String felhasznalonev,
            @Param("jelszo") String jelszo,
            @Param("felh_vezeteknev") String felh_vezeteknev,
            @Param("felh_keresztnev") String felh_keresztnev,
            @Param("felh_email") String felh_email,
            @Param("szuletesi_datum") Date szuletesi_datum,
            @Param("felh_telefon") String felh_telefon,
            @Param("tartozkodasihelyID") Long tartozkodasihelyID
    );

    @Transactional
    @Modifying
    @Query(value = "{call Test(:iranyitoszam, :varos, :felhasznalonev, :jelszo)}", nativeQuery = true)
    void Test(
            @Param("iranyitoszam") Integer iranyitoszam,
            @Param("varos") String varos,
            @Param("felhasznalonev") String felhasznalonev,
            @Param("jelszo") String jelszo
    );


    @Transactional
    @Modifying
    @Query(value = "{call FelhasznaloTorles(:felhasznaloID)}", nativeQuery = true)
    void FelhasznaloTorles(@Param("felhasznaloID") Long felhasznaloID);

    @Transactional
    @Modifying
    @Query(value = "{call FelhasznaloModosit(:felhasznaloID,:felhasznalonev, :jelszo, :felh_vezeteknev, :felh_keresztnev, :felh_email, :felh_telefon, :tartozkodasihelyID)}", nativeQuery = true)
    void FelhasznaloModosit(
            @Param("felhasznaloID") Long felhasznaloID,
            @Param("felhasznalonev") String felhasznalonev,
            @Param("jelszo") String jelszo,
            @Param("felh_vezeteknev") String felh_vezeteknev,
            @Param("felh_keresztnev") String felh_keresztnev,
            @Param("felh_email") String felh_email,
            @Param("felh_telefon") String felh_telefon,
            @Param("tartozkodasihelyID") Long tartozkodasihelyID
    );
}
