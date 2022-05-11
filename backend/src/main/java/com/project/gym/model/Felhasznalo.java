package com.project.gym.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Date;

/**
 * Adatbázis model felhasználó tábla, mind regisztáció és belépés céljára.
 */
@Entity
@Table(name = "felhasznalo")
@NamedStoredProcedureQuery(name = "FelhasznaloOlvasByID", procedureName = "FelhasznaloOlvasByID",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "felhasznaloID", type = Long.class)
        })


public class Felhasznalo implements Serializable {
    /**
     * A felhasználónak automatikusan generált száma/ID-ja.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "felhasznaloID", nullable = false, updatable = false)
    private Long felhasznaloID;

    /**
     * Az elfogadható felhasználónév.
     */
    @Column
    private String felhasznalonev;

    /**
     * Az elfogadható jelszó.
     */
    @Column
    private String jelszo;

    /**
     * A megadott felhasználói vezetéknév.
     */
    @Column
    private String felh_vezeteknev;

    /**
     * A megadott felhasználói keresztnév
     */
    @Column
    private String felh_keresztnev;

    /**
     * Felhasználó születési dátuma.
     */
    @Column
    private Date szuletesi_datum;

    /**
     * A felhasználó email címe.
     */
    @Column
    private String felh_email;

    /**
     * A felhasználónak a telefonszáma.
     */
    @Column
    private String felh_telefon;

    /**
     * Felhasználó konstruktor
     */
    public Felhasznalo() {
    }

    /**
     * Felhasználó konstruktor már adatokkal.
     *
     * @param felhasznaloID   the felhasznalo id
     * @param felhasznalonev  the felhasznalonev
     * @param jelszo          the jelszo
     * @param felh_vezeteknev the felh vezeteknev
     * @param felh_keresztnev the felh keresztnev
     * @param szuletesi_datum the szuletesi datum
     * @param felh_email      the felh email
     * @param felh_telefon    the felh telefon
     */
    @Autowired
    public Felhasznalo(Long felhasznaloID, String felhasznalonev, String jelszo, String felh_vezeteknev, String felh_keresztnev, Date szuletesi_datum, String felh_email, String felh_telefon) {
        this.felhasznaloID = felhasznaloID;
        this.felhasznalonev = felhasznalonev;
        this.jelszo = jelszo;
        this.felh_vezeteknev = felh_vezeteknev;
        this.felh_keresztnev = felh_keresztnev;
        this.szuletesi_datum = szuletesi_datum;
        this.felh_email = felh_email;
        this.felh_telefon = felh_telefon;
    }


    /**
     * Gets felhasznalo id.
     *
     * @return the felhasznalo id
     */
    public Long getFelhasznaloID() {
        return felhasznaloID;
    }

    /**
     * Sets felhasznalo id.
     *
     * @param felhasznaloID the felhasznalo id
     */
    public void setFelhasznaloID(Long felhasznaloID) {
        this.felhasznaloID = felhasznaloID;
    }

    /**
     * Gets felhasznalonev.
     *
     * @return the felhasznalonev
     */
    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    /**
     * Sets felhasznalonev.
     *
     * @param felhasznalonev the felhasznalonev
     */
    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    /**
     * Gets jelszo.
     *
     * @return the jelszo
     */
    public String getJelszo() {
        return jelszo;
    }

    /**
     * Sets jelszo.
     *
     * @param jelszo the jelszo
     */
    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    /**
     * Gets felh vezeteknev.
     *
     * @return the felh vezeteknev
     */
    public String getFelh_vezeteknev() {
        return felh_vezeteknev;
    }

    /**
     * Sets felh vezeteknev.
     *
     * @param felh_vezeteknev the felh vezeteknev
     */
    public void setFelh_vezeteknev(String felh_vezeteknev) {
        this.felh_vezeteknev = felh_vezeteknev;
    }

    /**
     * Gets felh keresztnev.
     *
     * @return the felh keresztnev
     */
    public String getFelh_keresztnev() {
        return felh_keresztnev;
    }

    /**
     * Sets felh keresztnev.
     *
     * @param felh_keresztnev the felh keresztnev
     */
    public void setFelh_keresztnev(String felh_keresztnev) {
        this.felh_keresztnev = felh_keresztnev;
    }

    /**
     * Gets szuletesi datum.
     *
     * @return the szuletesi datum
     */
    public Date getSzuletesi_datum() {
        return szuletesi_datum;
    }

    /**
     * Sets szuletesi datum.
     *
     * @param szuletesi_datum the szuletesi datum
     */
    public void setSzuletesi_datum(Date szuletesi_datum) {
        this.szuletesi_datum = szuletesi_datum;
    }

    /**
     * Gets felh email.
     *
     * @return the felh email
     */
    public String getFelh_email() {
        return felh_email;
    }

    /**
     * Sets felh email.
     *
     * @param felh_email the felh email
     */
    public void setFelh_email(String felh_email) {
        this.felh_email = felh_email;
    }

    /**
     * Gets felh telefon.
     *
     * @return the felh telefon
     */
    public String getFelh_telefon() {
        return felh_telefon;
    }

    /**
     * Sets felh telefon.
     *
     * @param felh_telefon the felh telefon
     */
    public void setFelh_telefon(String felh_telefon) {
        this.felh_telefon = felh_telefon;
    }

}