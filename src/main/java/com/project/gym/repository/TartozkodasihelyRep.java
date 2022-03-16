package com.project.gym.repository;

import com.project.gym.model.Tartozkodasihely;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface TartozkodasihelyRep extends JpaRepository<Tartozkodasihely, Long> {

    @Procedure(name = "TartozkodasihelyOlvasas")
    Iterable<String> TartozkodasihelyOlvasas(@Param("tartozkodasihelyID") Long tartozkodasihelyID);


    @Transactional
    @Modifying
    @Query(value = "{call TartozkodasihelyLetrehoz(:iranyitoszam, :varos, :kozterulet_neve, :kozterulet_jellege, :haz_szam)}", nativeQuery = true)
    void TartozkodasihelyLetrehoz(
            @Param("iranyitoszam") Integer iranyitoszam,
            @Param("varos") String varos,
            @Param("kozterulet_neve") String kozterulet_neve,
            @Param("kozterulet_jellege") String kozterulet_jellege,
            @Param("haz_szam") Integer haz_szam
    );

    @Transactional
    @Modifying
    @Query(value = "{call TartozkodasihelyTorles(:tartozkodasihelyID)}", nativeQuery = true)
    void TartozkodasihelyTorles(@Param("tartozkodasihelyID") Long tartozkodasihelyID);

    @Transactional
    @Modifying
    @Query(value = "{call TartozkodasihelyModosit(:tartozkodasihelyID,:iranyitoszam, :varos, :kozterulet_neve, :kozterulet_jellege, :haz_szam)}", nativeQuery = true)
    void TartozkodasihelyModosit(
            @Param("tartozkodasihelyID") Long tartozkodasihelyID,
            @Param("iranyitoszam") Integer iranyitoszam,
            @Param("varos") String varos,
            @Param("kozterulet_neve") String kozterulet_neve,
            @Param("kozterulet_jellege") String kozterulet_jelleg,
            @Param("haz_szam") Integer haz_szam
    );
}
