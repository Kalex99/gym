package com.project.gym.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "szemelyi_edzo")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Szemelyi_edzoOlvasas", procedureName = "Szemelyi_edzoOlvasas",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "szemelyi_edzoID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_vezeteknev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_keresztnev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "portre", type = byte[].class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_email", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_telefon", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "tartozkodasihelyID", type = Long.class)
                }),
        @NamedStoredProcedureQuery(name = "Szemelyi_edzoOlvasasFelhasznalo", procedureName = "Szemelyi_edzoOlvasasFelhasznalo",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "szemelyi_edzoID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felhasznaloID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_vezeteknev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_keresztnev", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "Szemelyi_edzoOlvasasTartozkodasihely", procedureName = "Szemelyi_edzoOlvasasTartozkodasihely",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "szemelyi_edzoID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "tartozkodasihelyID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "iranyitoszam", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "varos", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kozterulet_neve", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kozterulet_jellege", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "haz_szam", type = Integer.class)
                })

})

public class Szemelyi_edzo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "szemelyi_edzoID", nullable = false, updatable = false)
    private Long szemelyi_edzoID;

    @Column
    private String szemedz_vezeteknev;

    @Column
    private String szemedz_keresztnev;

    @Column
    private byte[] portre;

    @Column
    private String szemedz_email;

    @Column
    private String szemedz_telefon;

    @Column(name = "tartozkodasihelyID", insertable = false, updatable = false)
    private Long tartozkodasihelyID;

    public Szemelyi_edzo() {
    }

    public Szemelyi_edzo(Long szemelyi_edzoID, String szemedz_vezeteknev, String szemedz_keresztnev, byte[] portre, String szemedz_email, String szemedz_telefon, Long tartozkodasihelyID) {
        this.szemelyi_edzoID = szemelyi_edzoID;
        this.szemedz_vezeteknev = szemedz_vezeteknev;
        this.szemedz_keresztnev = szemedz_keresztnev;
        this.portre = portre;
        this.szemedz_email = szemedz_email;
        this.szemedz_telefon = szemedz_telefon;
        this.tartozkodasihelyID = tartozkodasihelyID;
    }

    public Long getSzemelyi_edzoID() {
        return szemelyi_edzoID;
    }

    public void setSzemelyi_edzoID(Long szemelyi_edzoID) {
        this.szemelyi_edzoID = szemelyi_edzoID;
    }

    public String getSzemedz_vezeteknev() {
        return szemedz_vezeteknev;
    }

    public void setSzemedz_vezeteknev(String szemedz_vezeteknev) {
        this.szemedz_vezeteknev = szemedz_vezeteknev;
    }

    public String getSzemedz_keresztnev() {
        return szemedz_keresztnev;
    }

    public void setSzemedz_keresztnev(String szemedz_keresztnev) {
        this.szemedz_keresztnev = szemedz_keresztnev;
    }

    public byte[] getPortre() {
        return portre;
    }

    public void setPortre(byte[] portre) {
        this.portre = portre;
    }

    public String getSzemedz_email() {
        return szemedz_email;
    }

    public void setSzemedz_email(String szemedz_email) {
        this.szemedz_email = szemedz_email;
    }

    public String getSzemedz_telefon() {
        return szemedz_telefon;
    }

    public void setSzemedz_telefon(String szemedz_telefon) {
        this.szemedz_telefon = szemedz_telefon;
    }

    public Long getTartozkodasihelyID() {
        return tartozkodasihelyID;
    }

    public void setTartozkodasihelyID(Long tartozkodasihelyID) {
        this.tartozkodasihelyID = tartozkodasihelyID;
    }

    @Override
    public String toString() {
        return "szemelyi_edzo{" +
                "szemelyi_edzoID=" + szemelyi_edzoID +
                ", szemedz_vezeteknev='" + szemedz_vezeteknev + '\'' +
                ", szemedz_keresztnev='" + szemedz_keresztnev + '\'' +
                ", portre=" + Arrays.toString(portre) +
                ", szemedz_email='" + szemedz_email + '\'' +
                ", szemedz_telefon='" + szemedz_telefon + '\'' +
                ", tartozkodasihelyID=" + tartozkodasihelyID +
                '}';
    }
}
