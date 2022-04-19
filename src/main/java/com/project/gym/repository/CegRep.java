package com.project.gym.repository;

import com.project.gym.model.Ceg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CegRep extends JpaRepository<Ceg, Long> {

    @Query(value = "{call CegOlvas()}", nativeQuery = true)
    List<Ceg> CegOlvas();

    @Procedure(name = "CegOlvasByID")
    Iterable<String> CegOlvasByID(@Param("cegID") Long cegID);

    @Procedure(name = "CegOlvasTartozkodasihelyByID")
    Iterable<String> CegOlvasTartozkodasihelyByID(@Param("cegID") Long cegID);


    @Transactional
    @Modifying
    @Query(value = "{call CegLetrehoz(:ceg_nev, :ceg_email, :ceg_telefon, :tartozkodasihelyID)}", nativeQuery = true)
    void CegLetrehoz(
            @Param("ceg_nev") String ceg_nev,
            @Param("ceg_email") String ceg_email,
            @Param("ceg_telefon") String ceg_telefon,
            @Param("tartozkodasihelyID") Long tartozkodasihelyID
    );

    @Transactional
    @Modifying
    @Query(value = "{call CegTorles(:cegID)}", nativeQuery = true)
    void CegTorles(@Param("cegID") Long cegID);

    @Transactional
    @Modifying
    @Query(value = "{call CegModosit(:cegID,:ceg_nev, :ceg_email, :ceg_telefon, :tartozkodasihelyID)}", nativeQuery = true)
    void CegModosit(
            @Param("cegID") Long cegID,
            @Param("ceg_nev") String ceg_nev,
            @Param("ceg_email") String ceg_email,
            @Param("ceg_telefon") String ceg_telefon,
            @Param("tartozkodasihelyID") Long tartozkodasihelyID
    );
}
