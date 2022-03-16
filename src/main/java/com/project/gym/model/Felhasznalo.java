package com.project.gym.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;


import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "felhasznalo")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "BejelentkezesRendeles", procedureName = "BejelentkezesRendeles",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "felhasznaloID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "rendeles_idopont", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "megjegyzes", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "termekID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_vasarlasID", type = Long.class)
                }),
        @NamedStoredProcedureQuery(name = "FelhasznaloOlvasasByID", procedureName = "FelhasznaloOlvasasByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "felhasznaloID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felhasznalonev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "jelszo", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_vezeteknev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_keresztnev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szuletesi_datum", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_email", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_telefon", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "tartozkodasihelyID", type = Long.class)
                }),
        @NamedStoredProcedureQuery(name = "BejelentkezesSzemelyiEdzo", procedureName = "BejelentkezesSzemelyiEdzo",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "felhasznaloID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemelyi_edzoID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_vezeteknev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_keresztnev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "portre", type = byte[].class)
                }),
        @NamedStoredProcedureQuery(name = "BejelentkezesTartozkodasihely", procedureName = "BejelentkezesTartozkodasihely",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "felhasznaloID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "tartozkodasihelyID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "iranyitoszam", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "varos", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kozterulet_neve", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kozterulet_jellege", type = byte[].class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "haz_szam", type = String.class)
                })

})

public class Felhasznalo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "felhasznaloID", nullable = false, updatable = false)
    private Long felhasznaloID;
    @Column
    private String felhasznalonev;
    @Column
    private String jelszo;
    @Column
    private String felh_vezeteknev;
    @Column
    private String felh_keresztnev;
    @Column
    private Date szuletesi_datum;
    @Column
    private String felh_email;
    @Column
    private String felh_telefon;

    @Column(name = "tartozkodasihelyID", insertable = false, updatable = false)
    private Long tartozkodasihelyID;

    public Felhasznalo() {
    }

    @Autowired
    public Felhasznalo(Long felhasznaloID, String felhasznalonev, String jelszo, String felh_vezeteknev, String felh_keresztnev, Date szuletesi_datum, String felh_email, String felh_telefon, Long tartozkodasihelyID) {
        this.felhasznaloID = felhasznaloID;
        this.felhasznalonev = felhasznalonev;
        this.jelszo = jelszo;
        this.felh_vezeteknev = felh_vezeteknev;
        this.felh_keresztnev = felh_keresztnev;
        this.szuletesi_datum = szuletesi_datum;
        this.felh_email = felh_email;
        this.felh_telefon = felh_telefon;
        this.tartozkodasihelyID = tartozkodasihelyID;
    }


    public Long getFelhasznaloID() {
        return felhasznaloID;
    }

    public void setFelhasznaloID(Long felhasznaloID) {
        this.felhasznaloID = felhasznaloID;
    }

    public String getFelhasznalonev() {
        return felhasznalonev;
    }

    public void setFelhasznalonev(String felhasznalonev) {
        this.felhasznalonev = felhasznalonev;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    public String getFelh_vezeteknev() {
        return felh_vezeteknev;
    }

    public void setFelh_vezeteknev(String felh_vezeteknev) {
        this.felh_vezeteknev = felh_vezeteknev;
    }

    public String getFelh_keresztnev() {
        return felh_keresztnev;
    }

    public void setFelh_keresztnev(String felh_keresztnev) {
        this.felh_keresztnev = felh_keresztnev;
    }

    public Date getSzuletesi_datum() {
        return szuletesi_datum;
    }

    public void setSzuletesi_datum(Date szuletesi_datum) {
        this.szuletesi_datum = szuletesi_datum;
    }

    public String getFelh_email() {
        return felh_email;
    }

    public void setFelh_email(String felh_email) {
        this.felh_email = felh_email;
    }

    public String getFelh_telefon() {
        return felh_telefon;
    }

    public void setFelh_telefon(String felh_telefon) {
        this.felh_telefon = felh_telefon;
    }

    public Long getTartozkodasihelyID() {
        return tartozkodasihelyID;
    }

    public void setTartozkodasihelyID(Long tartozkodasihelyID) {
        this.tartozkodasihelyID = tartozkodasihelyID;
    }

    @Override
    public String toString() {
        return "Felhasznalo{" +
                "felhasznaloID=" + felhasznaloID +
                ", felhasznalonev='" + felhasznalonev + '\'' +
                ", jelszo='" + jelszo + '\'' +
                ", felh_vezeteknev='" + felh_vezeteknev + '\'' +
                ", felh_keresztnev='" + felh_keresztnev + '\'' +
                ", szuletesi_datum=" + szuletesi_datum +
                ", felh_email='" + felh_email + '\'' +
                ", felh_telefon='" + felh_telefon + '\'' +
                ", tartozkodasihelyID='" + tartozkodasihelyID + '\'' +
                '}';
    }


}
