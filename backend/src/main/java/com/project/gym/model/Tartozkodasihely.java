package com.project.gym.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tartozkodasihely")
@NamedStoredProcedureQuery(name = "TartozkodasihelyOlvasByID", procedureName = "TartozkodasihelyOlvasByID",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "tartozkodasihelyID", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "iranyitoszam", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "varos", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kozterulet_neve", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kozterulet_jellege", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "haz_szam", type = String.class)
        })
public class Tartozkodasihely implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tartozkodasihelyID", nullable = false, updatable = false)
    private Long tartozkodasihelyID;
    @Column
    private Integer iranyitoszam;
    @Column
    private String varos;
    @Column
    private String kozterulet_neve;
    @Column
    private String kozterulet_jellege;
    @Column
    private Integer haz_szam;

    public Tartozkodasihely() {
    }

    @Autowired
    public Tartozkodasihely(Long tartozkodasihelyID, int iranyitoszam, String varos, String kozterulet_neve, String kozterulet_jellege, int haz_szam) {
        this.tartozkodasihelyID = tartozkodasihelyID;
        this.iranyitoszam = iranyitoszam;
        this.varos = varos;
        this.kozterulet_neve = kozterulet_neve;
        this.kozterulet_jellege = kozterulet_jellege;
        this.haz_szam = haz_szam;
    }

    public Long getTartozkodasihelyID() {
        return tartozkodasihelyID;
    }

    public void setTartozkodasihelyID(Long tartozkodasihelyID) {
        this.tartozkodasihelyID = tartozkodasihelyID;
    }

    public int getIranyitoszam() {
        return iranyitoszam;
    }

    public void setIranyitoszam(int iranyitoszam) {
        this.iranyitoszam = iranyitoszam;
    }

    public String getVaros() {
        return varos;
    }

    public void setVaros(String varos) {
        this.varos = varos;
    }

    public String getKozterulet_neve() {
        return kozterulet_neve;
    }

    public void setKozterulet_neve(String kozterulet_neve) {
        this.kozterulet_neve = kozterulet_neve;
    }

    public String getKozterulet_jellege() {
        return kozterulet_jellege;
    }

    public void setKozterulet_jellege(String kozterulet_jellege) {
        this.kozterulet_jellege = kozterulet_jellege;
    }

    public int getHaz_szam() {
        return haz_szam;
    }

    public void setHaz_szam(int haz_szam) {
        this.haz_szam = haz_szam;
    }

    @Override
    public String toString() {
        return "Tartozkodasihely{" +
                "tartozkodasihelyID=" + tartozkodasihelyID +
                ", Iranyitoszam=" + iranyitoszam +
                ", Varos='" + varos + '\'' +
                ", Kozterulet_neve='" + kozterulet_neve + '\'' +
                ", Kozterulet_jellege='" + kozterulet_jellege + '\'' +
                ", Haz_szam='" + haz_szam + '\'' +
                '}';
    }
}
