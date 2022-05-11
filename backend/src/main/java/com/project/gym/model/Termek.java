package com.project.gym.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Adatbázis model Termek tábla.
 */
@Entity
@Table(name = "Termek")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "TermekOlvasByID", procedureName = "TermekOlvasByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "termekID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "termek_nev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ar", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "keszlet", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kaphato", type = Boolean.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "leiras", type = String.class)
                })
})
public class Termek implements Serializable {
    /**
     * A termékek azonosítója.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "termekID", nullable = false, updatable = false)
    private Long termekID;

    /**
     * A termékek megnevezése.
     */
    @Column
    private String termek_nev;

    /**
     * A termékek ára.
     */
    @Column
    private Integer ar;

    /**
     * Hány darab készlet van az adott termékből.
     */
    @Column
    private Integer keszlet;

    /**
     * Az adott termék kapható-e.
     */
    @Column
    private Boolean kaphato;

    /**
     * A termék leírása.
     */
    @Column
    private String leiras;

    /**
     * Termék konstruktora.
     */
    public Termek() {
    }

    /**
     * Termék konstruktora adatokkal.
     *
     * @param termekID   the termek id
     * @param termek_nev the termek nev
     * @param ar         the ar
     * @param keszlet    the keszlet
     * @param kaphato    the kaphato
     * @param leiras     the leiras
     */
    public Termek(Long termekID, String termek_nev,Integer ar, Integer keszlet, Boolean kaphato, String leiras) {
        this.termekID = termekID;
        this.termek_nev = termek_nev;
        this.ar = ar;
        this.keszlet = keszlet;
        this.kaphato = kaphato;
        this.leiras = leiras;
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
     * Gets termek nev.
     *
     * @return the termek nev
     */
    public String getTermek_nev() {
        return termek_nev;
    }

    /**
     * Sets termek nev.
     *
     * @param termek_nev the termek nev
     */
    public void setTermek_nev(String termek_nev) {
        this.termek_nev = termek_nev;
    }

    /**
     * Gets ar.
     *
     * @return the ar
     */
    public Integer getAr() {
        return ar;
    }

    /**
     * Sets ar.
     *
     * @param ar the ar
     */
    public void setAr(Integer ar) {
        this.ar = ar;
    }

    /**
     * Gets keszlet.
     *
     * @return the keszlet
     */
    public Integer getKeszlet() {
        return keszlet;
    }

    /**
     * Sets keszlet.
     *
     * @param keszlet the keszlet
     */
    public void setKeszlet(Integer keszlet) {
        this.keszlet = keszlet;
    }

    /**
     * Gets kaphato.
     *
     * @return the kaphato
     */
    public Boolean getKaphato() {
        return kaphato;
    }

    /**
     * Sets kaphato.
     *
     * @param kaphato the kaphato
     */
    public void setKaphato(Boolean kaphato) {
        this.kaphato = kaphato;
    }

    /**
     * Gets leiras.
     *
     * @return the leiras
     */
    public String getLeiras() {
        return leiras;
    }

    /**
     * Sets leiras.
     *
     * @param leiras the leiras
     */
    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

}
