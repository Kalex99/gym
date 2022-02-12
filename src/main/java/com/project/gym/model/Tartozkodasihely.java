package com.project.gym.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tartozkodasihely")
@NamedStoredProcedureQuery(name = "TartozkodasihelyOlvasas", procedureName = "TartozkodasihelyOlvasas",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "tartozkodasihelyID", type = Long.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "iranyitoszam", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "varos", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kozterulet_neve", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kozterulet_jellege", type = String.class)
        })
public class Tartozkodasihely implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tartozkodasihelyID", nullable = false, updatable = false)
    private Long tartozkodasihelyID;
    @Column
    private int Iranyitoszam;
    @Column
    private String Varos;
    @Column
    private String Kozterulet_neve;
    @Column
    private String Kozterulet_jellege;
    @Column
    private int Haz_szam;

    //@OneToOne (mappedBy = "Tartozkodasihely",cascade = CascadeType.ALL)
    //private Felhasznalo felhasznalo;

    public Tartozkodasihely(){}
    @Autowired
    public Tartozkodasihely(Long tartozkodasihelyID, int iranyitoszam, String varos, String kozterulet_neve, String kozterulet_jellege, int haz_szam) {
        this.tartozkodasihelyID = tartozkodasihelyID;
        this.Iranyitoszam = iranyitoszam;
        this.Varos = varos;
        this.Kozterulet_neve = kozterulet_neve;
        this.Kozterulet_jellege = kozterulet_jellege;
        this.Haz_szam=haz_szam;
    }

    public Long getTartozkodasihelyID() {
        return tartozkodasihelyID;
    }

    public void setTartozkodasihelyID(Long tartozkodasihelyID) {
        this.tartozkodasihelyID = tartozkodasihelyID;
    }

    public int getIranyitoszam() {
        return Iranyitoszam;
    }

    public void setIranyitoszam(int iranyitoszam) {
        this.Iranyitoszam = iranyitoszam;
    }

    public String getVaros() {
        return Varos;
    }

    public void setVaros(String varos) {
        this.Varos = varos;
    }

    public String getKozterulet_neve() {
        return Kozterulet_neve;
    }

    public void setKozterulet_neve(String kozterulet_neve) {
        this.Kozterulet_neve = kozterulet_neve;
    }

    public String getKozterulet_jellege() {
        return Kozterulet_jellege;
    }

    public void setKozterulet_jellege(String kozterulet_jellege) {
        this.Kozterulet_jellege = kozterulet_jellege;
    }

    public int getHaz_szam() {
        return Haz_szam;
    }

    public void setHaz_szam(int haz_szam) {
        this.Haz_szam = haz_szam;
    }

    @Override
    public String toString() {
        return "Tartozkodasihely{" +
                "tartozkodasihelyID=" + tartozkodasihelyID +
                ", Iranyitoszam=" + Iranyitoszam +
                ", Varos='" + Varos + '\'' +
                ", Kozterulet_neve='" + Kozterulet_neve + '\'' +
                ", Kozterulet_jellege='" + Kozterulet_jellege + '\'' +
                ", Haz_szam='" + Haz_szam + '\''+
                '}';
    }
}
