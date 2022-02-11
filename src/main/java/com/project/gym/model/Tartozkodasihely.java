package com.project.gym.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tartozkodasihely")
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

    //@OneToOne//(mappedBy = "Tartozkodasihely",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Felhasznalo felhasznalo;

    public Tartozkodasihely(){}
    public Tartozkodasihely(Long tartozkodasihelyID, int iranyitoszam, String varos, String kozterulet_neve, String kozterulet_jellege) {
        this.tartozkodasihelyID = tartozkodasihelyID;
        this.Iranyitoszam = iranyitoszam;
        this.Varos = varos;
        this.Kozterulet_neve = kozterulet_neve;
        this.Kozterulet_jellege = kozterulet_jellege;
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
        Iranyitoszam = iranyitoszam;
    }

    public String getVaros() {
        return Varos;
    }

    public void setVaros(String varos) {
        Varos = varos;
    }

    public String getKozterulet_neve() {
        return Kozterulet_neve;
    }

    public void setKozterulet_neve(String kozterulet_neve) {
        Kozterulet_neve = kozterulet_neve;
    }

    public String getKozterulet_jellege() {
        return Kozterulet_jellege;
    }

    public void setKozterulet_jellege(String kozterulet_jellege) {
        Kozterulet_jellege = kozterulet_jellege;
    }

    @Override
    public String toString() {
        return "Tartozkodasihely{" +
                "tartozkodasihelyID=" + tartozkodasihelyID +
                ", Iranyitoszam=" + Iranyitoszam +
                ", Varos='" + Varos + '\'' +
                ", Kozterulet_neve='" + Kozterulet_neve + '\'' +
                ", Kozterulet_jellege='" + Kozterulet_jellege + '\'' +
                '}';
    }
}
