package com.project.gym.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Adatbázis model rendelés tábla.
 */
@Entity
@Table(name = "Rendeles")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "RendelesOlvasByID", procedureName = "RendelesOlvasByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "rendeles_idopont", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "megjegyzes", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "termekID", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_vasarlasID", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felhasznaloID", type = Integer.class)
                }),
        @NamedStoredProcedureQuery(name = "RendelesOlvasBerletByID", procedureName = "RendelesOlvasBerletByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_vasarlasID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_tipus", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_ar", type = Long.class)
                }),
        @NamedStoredProcedureQuery(name = "RendelesOlvasFelhasznaloByID", procedureName = "RendelesOlvasFelhasznaloByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felhasznaloID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_vezeteknev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_keresztnev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_email", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_telefon", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "RendelesOlvasTermekByID", procedureName = "RendelesOlvasTermekByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "termekID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "termek_nev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kategoria", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ar", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kep", type = byte[].class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "leiras", type = String.class)
                })

})


public class Rendeles implements Serializable {

    /**
     * A rendelés azonosítója.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rendelesID", nullable = false, updatable = false)
    private Long rendelesID;

    /**
     * A rendelésnek a pontos időpontja.
     */
    @Column
    private Date rendeles_idopont;

    /**
     * Valamilyen megjegyzés a felhasználó által.
     */
    @Column
    private String megjegyzes;

    /**
     * Felhasználó által bevitt rendelt mennyiség korlátozva.
     */
    @Column
    private Integer mennyiseg;

    /**
     * A termék táblának az idegen kulcsa.
     */
    @Column(name = "termekID", insertable = false, updatable = false)
    private Long termekID;

    /**
     * A bérletvásárlás táblának az idegen kulcsa.
     */
    @Column(name = "berlet_vasarlasID", insertable = false, updatable = false)
    private Long berlet_vasarlasID;

    /**
     * A felhasználó táblának az idegen kulcsa.
     */
    @Column(name = "felhasznaloID", insertable = false, updatable = false)
    private Long felhasznaloID;


    /**
     * A rendelés konstruktora
     */
    public Rendeles() {
    }

    /**
     * A rendelés konstruktora adatokkal.
     *
     * @param rendelesID        the rendeles id
     * @param rendeles_idopont  the rendeles idopont
     * @param megjegyzes        the megjegyzes
     * @param mennyiseg         the mennyiseg
     * @param termekID          the termek id
     * @param berlet_vasarlasID the berlet vasarlas id
     * @param felhasznaloID     the felhasznalo id
     */
    public Rendeles(Long rendelesID, Date rendeles_idopont, String megjegyzes, Integer mennyiseg, Long termekID, Long berlet_vasarlasID, Long felhasznaloID) {
        this.rendelesID = rendelesID;
        this.rendeles_idopont = rendeles_idopont;
        this.megjegyzes = megjegyzes;
        this.mennyiseg = mennyiseg;
        this.termekID = termekID;
        this.berlet_vasarlasID = berlet_vasarlasID;
        this.felhasznaloID = felhasznaloID;
    }

    /**
     * Gets rendeles id.
     *
     * @return the rendeles id
     */
    public Long getRendelesID() {
        return rendelesID;
    }

    /**
     * Sets rendeles id.
     *
     * @param rendelesID the rendeles id
     */
    public void setRendelesID(Long rendelesID) {
        this.rendelesID = rendelesID;
    }

    /**
     * Gets rendeles idopont.
     *
     * @return the rendeles idopont
     */
    public Date getRendeles_idopont() {
        return rendeles_idopont;
    }

    /**
     * Sets rendeles idopont.
     *
     * @param rendeles_idopont the rendeles idopont
     */
    public void setRendeles_idopont(Date rendeles_idopont) {
        this.rendeles_idopont = rendeles_idopont;
    }

    /**
     * Gets megjegyzes.
     *
     * @return the megjegyzes
     */
    public String getMegjegyzes() {
        return megjegyzes;
    }

    /**
     * Sets megjegyzes.
     *
     * @param megjegyzes the megjegyzes
     */
    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    /**
     * Get mennyiseg integer.
     *
     * @return the integer
     */
    public Integer getMennyiseg(){
        return mennyiseg;
    }

    /**
     * Set mennyiseg.
     *
     * @param mennyiseg the mennyiseg
     */
    public void setMennyiseg(Integer mennyiseg){
        this.mennyiseg = mennyiseg;
    }

    /**
     * Gets termek id.
     *
     * @return the termek id
     */
    public Long getTermekID() {
        return termekID;
    }

    /**
     * Sets termek id.
     *
     * @param termekID the termek id
     */
    public void setTermekID(Long termekID) {
        this.termekID = termekID;
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
}
