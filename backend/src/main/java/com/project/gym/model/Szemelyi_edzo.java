package com.project.gym.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Adatbázis model szemelyi edzo tábla.
 */
@Entity
@Table(name = "szemelyi_edzo")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Szemelyi_edzoOlvasByID", procedureName = "Szemelyi_edzoOlvasByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "szemelyi_edzoID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_vezeteknev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_keresztnev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_email", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_telefon", type = String.class)
                })
})

public class Szemelyi_edzo implements Serializable {
    /**
     * Személyi edzők azonosítója.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "szemelyi_edzoID", nullable = false, updatable = false)
    private Long szemelyi_edzoID;

    /**
     * Személyi edző vezetékneve.
     */
    @Column
    private String szemedz_vezeteknev;

    /**
     * Személyi edző keresztneve.
     */
    @Column
    private String szemedz_keresztnev;

    /**
     * Személyi edző email címe.
     */
    @Column
    private String szemedz_email;

    /**
     * Személyi edző telefonszáma.
     */
    @Column
    private String szemedz_telefon;

    /**
     * Személyi edző model konstruktora.
     */
    public Szemelyi_edzo() {
    }

    /**
     * Személyi edző model konstruktora adatokkal.
     *
     * @param szemelyi_edzoID    the szemelyi edzo id
     * @param szemedz_vezeteknev the szemedz vezeteknev
     * @param szemedz_keresztnev the szemedz keresztnev
     * @param szemedz_email      the szemedz email
     * @param szemedz_telefon    the szemedz telefon
     * @param tartozkodasihelyID the tartozkodasihely id
     */
    public Szemelyi_edzo(Long szemelyi_edzoID, String szemedz_vezeteknev, String szemedz_keresztnev, String szemedz_email, String szemedz_telefon, Long tartozkodasihelyID) {
        this.szemelyi_edzoID = szemelyi_edzoID;
        this.szemedz_vezeteknev = szemedz_vezeteknev;
        this.szemedz_keresztnev = szemedz_keresztnev;
        this.szemedz_email = szemedz_email;
        this.szemedz_telefon = szemedz_telefon;
    }

    /**
     * Gets szemelyi edzo id.
     *
     * @return the szemelyi edzo id
     */
    public Long getSzemelyi_edzoID() {
        return szemelyi_edzoID;
    }

    /**
     * Sets szemelyi edzo id.
     *
     * @param szemelyi_edzoID the szemelyi edzo id
     */
    public void setSzemelyi_edzoID(Long szemelyi_edzoID) {
        this.szemelyi_edzoID = szemelyi_edzoID;
    }

    /**
     * Gets szemedz vezeteknev.
     *
     * @return the szemedz vezeteknev
     */
    public String getSzemedz_vezeteknev() {
        return szemedz_vezeteknev;
    }

    /**
     * Sets szemedz vezeteknev.
     *
     * @param szemedz_vezeteknev the szemedz vezeteknev
     */
    public void setSzemedz_vezeteknev(String szemedz_vezeteknev) {
        this.szemedz_vezeteknev = szemedz_vezeteknev;
    }

    /**
     * Gets szemedz keresztnev.
     *
     * @return the szemedz keresztnev
     */
    public String getSzemedz_keresztnev() {
        return szemedz_keresztnev;
    }

    /**
     * Sets szemedz keresztnev.
     *
     * @param szemedz_keresztnev the szemedz keresztnev
     */
    public void setSzemedz_keresztnev(String szemedz_keresztnev) {
        this.szemedz_keresztnev = szemedz_keresztnev;
    }

    /**
     * Gets szemedz email.
     *
     * @return the szemedz email
     */
    public String getSzemedz_email() {
        return szemedz_email;
    }

    /**
     * Sets szemedz email.
     *
     * @param szemedz_email the szemedz email
     */
    public void setSzemedz_email(String szemedz_email) {
        this.szemedz_email = szemedz_email;
    }

    /**
     * Gets szemedz telefon.
     *
     * @return the szemedz telefon
     */
    public String getSzemedz_telefon() {
        return szemedz_telefon;
    }

    /**
     * Sets szemedz telefon.
     *
     * @param szemedz_telefon the szemedz telefon
     */
    public void setSzemedz_telefon(String szemedz_telefon) {
        this.szemedz_telefon = szemedz_telefon;
    }
}
