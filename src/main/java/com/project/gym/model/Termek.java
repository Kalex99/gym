package com.project.gym.model;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;

@Entity
@Table(name = "Termek")
public class Termek implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "termekID", nullable = false, updatable = false)
    private Long termekID;

    @Column
    private String termek_nev;

    @Column
    private String kategoria;

    @Column
    private Integer ar;

    @Column
    private byte[] kep;

    @Column
    private Integer keszlet;

    @Column
    private Boolean kaphato;

    @Column
    private String leiras;

    @Column(name = "cegID", insertable=false, updatable =false)
    private Long cegID;

    public Termek(){}

    public Termek(Long termekID, String termek_nev, String kategoria, Integer ar, byte[] kep, Integer keszlet, Boolean kaphato, String leiras, Long cegID) {
        this.termekID = termekID;
        this.termek_nev = termek_nev;
        this.kategoria = kategoria;
        this.ar = ar;
        this.kep = kep;
        this.keszlet = keszlet;
        this.kaphato = kaphato;
        this.leiras = leiras;
        this.cegID = cegID;
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

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public Integer getAr() {
        return ar;
    }

    public void setAr(Integer ar) {
        this.ar = ar;
    }

    public byte[] getKep() {
        return kep;
    }

    public void setKep(byte[] kep) {
        this.kep = kep;
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

    public Long getCegID() {
        return cegID;
    }

    public void setCegID(Long cegID) {
        this.cegID = cegID;
    }

    @Override
    public String toString() {
        return "Termek{" +
                "termekID=" + termekID +
                ", termek_nev='" + termek_nev + '\'' +
                ", kategoria='" + kategoria + '\'' +
                ", ar=" + ar +
                ", kep=" + Arrays.toString(kep) +
                ", keszlet=" + keszlet +
                ", kaphato=" + kaphato +
                ", leiras='" + leiras + '\'' +
                ", cegID=" + cegID +
                '}';
    }
}
