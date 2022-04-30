package com.project.gym.model;


import javax.persistence.*;
import java.io.Serializable;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "termekID", nullable = false, updatable = false)
    private Long termekID;

    @Column
    private String termek_nev;

    @Column
    private Integer ar;

    @Column
    private Integer keszlet;

    @Column
    private Boolean kaphato;

    @Column
    private String leiras;

    public Termek() {
    }

    public Termek(Long termekID, String termek_nev,Integer ar, Integer keszlet, Boolean kaphato, String leiras) {
        this.termekID = termekID;
        this.termek_nev = termek_nev;
        this.ar = ar;
        this.keszlet = keszlet;
        this.kaphato = kaphato;
        this.leiras = leiras;
    }

    public Long getTermekID() {
        return termekID;
    }

    public void setTermekID(Long termekID) {
        this.termekID = termekID;
    }

    public String getTermek_nev() {
        return termek_nev;
    }

    public void setTermek_nev(String termek_nev) {
        this.termek_nev = termek_nev;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public Integer getKeszlet() {
        return keszlet;
    }

    public void setKeszlet(Integer keszlet) {
        this.keszlet = keszlet;
    }

    public Boolean getKaphato() {
        return kaphato;
    }

    public void setKaphato(Boolean kaphato) {
        this.kaphato = kaphato;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

}
