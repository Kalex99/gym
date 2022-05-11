package com.project.gym.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Adatbázis model berlet_vasarlas tábla.
 */
@Entity
@Table(name = "berlet_vasarlas")
@NamedStoredProcedureQuery(name = "Berlet_vasarlasOlvasByID", procedureName = "Berlet_vasarlasOlvasByID",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "berlet_vasarlasID", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_tipus", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_ar", type = Integer.class),
        })

public class Berlet_vasarlas implements Serializable {
    /**
     * A bérlet létrehozásnál automatikusan kapott ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "berlet_vasarlasID", nullable = false, updatable = false)
    private Long berlet_vasarlasID;

    /**
     * Az adott bérletnek a típusa.
     */
    @Column
    private String berlet_tipus;

    /**
     * A megadott bérlet típusnak az ára.
     */
    @Column
    private Integer berlet_ar;


    /**
     * A Berlet vasarlas konstruktora.
     */
    public Berlet_vasarlas() {
    }

    /**
     * Berlet vasarlas konstruktora.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     * @param berlet_tipus      the berlet tipus
     * @param berlet_ar         the berlet ar
     */
    public Berlet_vasarlas(Long berlet_vasarlasID, String berlet_tipus, Integer berlet_ar) {
        this.berlet_vasarlasID = berlet_vasarlasID;
        this.berlet_tipus = berlet_tipus;
        this.berlet_ar = berlet_ar;
    }

    /**
     * Gets berlet vasarlas id.
     *
     * @return the berlet vasarlas id
     */
    public Long getBerlet_vasarlasID() {
        return berlet_vasarlasID;
    }

    /**
     * Sets berlet vasarlas id.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     */
    public void setBerlet_vasarlasID(Long berlet_vasarlasID) {
        this.berlet_vasarlasID = berlet_vasarlasID;
    }

    /**
     * Gets berlet tipus.
     *
     * @return the berlet tipus
     */
    public String getBerlet_tipus() {
        return berlet_tipus;
    }

    /**
     * Sets berlet tipus.
     *
     * @param berlet_tipus the berlet tipus
     */
    public void setBerlet_tipus(String berlet_tipus) {
        this.berlet_tipus = berlet_tipus;
    }

    /**
     * Gets berlet ar.
     *
     * @return the berlet ar
     */
    public Integer getBerlet_ar() {
        return berlet_ar;
    }

    /**
     * Sets berlet ar.
     *
     * @param berlet_ar the berlet ar
     */
    public void setBerlet_ar(Integer berlet_ar) {
        this.berlet_ar = berlet_ar;
    }

}
