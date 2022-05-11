package com.project.gym.repository;

import com.project.gym.model.Berlet_vasarlas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * A Berlet vasarlas modelnek a repository interface.
 */
@Repository
public interface Berlet_vasarlasRep extends JpaRepository<Berlet_vasarlas, Long> {

    /**
     * Berlet vasarlas olvas list.
     *
     * @return egy listát amelyben benne van az összes bérlet és a hozzájuk tartozó adatok.
     */
    @Query(value = "{call Berlet_vasarlasOlvas()}", nativeQuery = true)
    List<Berlet_vasarlas> Berlet_vasarlasOlvas();

    /**
     * Berlet vasarlas olvas by id iterable.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     * @return egy iterable-t a megadott ID-hoz tartozó bérlet adatokkal stringként.
     */
    @Procedure(name = "Berlet_vasarlasOlvasByID")
    Iterable<String> Berlet_vasarlasOlvasByID(@Param("berlet_vasarlasID") Long berlet_vasarlasID);

    /**
     * Berlet vasarlas letrehoz.
     *
     * @param berlet_tipus the berlet tipus
     * @param berlet_ar    the berlet ar
     */
    @Transactional
    @Modifying
    @Query(value = "{call Berlet_vasarlasLetrehoz(:berlet_tipus, :berlet_ar)}", nativeQuery = true)
    void Berlet_vasarlasLetrehoz(
            @Param("berlet_tipus") String berlet_tipus,
            @Param("berlet_ar") Integer berlet_ar
    );

    /**
     * Berlet vasarlas torles.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     */
    @Transactional
    @Modifying
    @Query(value = "{call Berlet_vasarlasTorles(:berlet_vasarlasID)}", nativeQuery = true)
    void Berlet_vasarlasTorles(@Param("berlet_vasarlasID") Long berlet_vasarlasID);

    /**
     * Berlet vasarlas modosit.
     *
     * @param tartozkodasihelyID the tartozkodasihely id
     * @param berlet_tipus       the berlet tipus
     * @param berlet_ar          the berlet ar
     */
    @Transactional
    @Modifying
    @Query(value = "{call Berlet_vasarlasModosit(:berlet_vasarlasID,:berlet_tipus, :berlet_ar)}", nativeQuery = true)
    void Berlet_vasarlasModosit(
            @Param("berlet_vasarlasID") Long tartozkodasihelyID,
            @Param("berlet_tipus") String berlet_tipus,
            @Param("berlet_ar") Integer berlet_ar
    );

}
