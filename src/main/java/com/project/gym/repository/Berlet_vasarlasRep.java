package com.project.gym.repository;

import com.project.gym.model.Berlet_vasarlas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface Berlet_vasarlasRep extends JpaRepository<Berlet_vasarlas, Long> {

    @Procedure(name = "Berlet_vasarlasOlvasas")
    Iterable<String> Berlet_vasarlasOlvasas(@Param("berlet_vasarlasID") Long berlet_vasarlasID);


    @Transactional
    @Modifying
    @Query(value = "{call Berlet_vasarlasLetrehoz(:berlet_tipus, :berlet_ar)}", nativeQuery = true)
    void Berlet_vasarlasLetrehoz(
            @Param("berlet_tipus") String berlet_tipus,
            @Param("berlet_ar") Integer berlet_ar
    );

    @Transactional
    @Modifying
    @Query(value = "{call Berlet_vasarlasTorles(:berlet_vasarlasID)}", nativeQuery = true)
    void Berlet_vasarlasTorles(@Param("berlet_vasarlasID") Long berlet_vasarlasID);

    @Transactional
    @Modifying
    @Query(value = "{call Berlet_vasarlasModosit(:berlet_vasarlasID,:berlet_tipus, :berlet_ar)}", nativeQuery = true)
    void Berlet_vasarlasModosit(
            @Param("berlet_vasarlasID") Long tartozkodasihelyID,
            @Param("berlet_tipus") String berlet_tipus,
            @Param("berlet_ar") Integer berlet_ar
    );

}
