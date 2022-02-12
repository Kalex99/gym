package com.project.gym.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ceg")
public class Ceg implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cegID", nullable = false, updatable = false)
    private Long cegID;

    @Column
    private String ceg_nev;

    @Column
    private String ceg_email;

    @Column
    private String ceg_telefon;

    @Column(name = "tartozkodasihelyID", insertable=false, updatable =false)
    private Long tartozkodasihelyID;

    private Ceg(){}

    public Ceg(Long cegID, String ceg_nev, String ceg_email, String ceg_telefon, Long tartozkodasihelyID) {
        this.cegID = cegID;
        this.ceg_nev = ceg_nev;
        this.ceg_email = ceg_email;
        this.ceg_telefon = ceg_telefon;
        this.tartozkodasihelyID = tartozkodasihelyID;
    }

    public Long getCegID() {
        return cegID;
    }

    public void setCegID(Long cegID) {
        this.cegID = cegID;
    }

    public String getCeg_nev() {
        return ceg_nev;
    }

    public void setCeg_nev(String ceg_nev) {
        this.ceg_nev = ceg_nev;
    }

    public String getCeg_email() {
        return ceg_email;
    }

    public void setCeg_email(String ceg_email) {
        this.ceg_email = ceg_email;
    }

    public String getCeg_telefon() {
        return ceg_telefon;
    }

    public void setCeg_telefon(String ceg_telefon) {
        this.ceg_telefon = ceg_telefon;
    }

    public Long getTartozkodasihelyID() {
        return tartozkodasihelyID;
    }

    public void setTartozkodasihelyID(Long tartozkodasihelyID) {
        this.tartozkodasihelyID = tartozkodasihelyID;
    }

    @Override
    public String toString() {
        return "Ceg{" +
                "cegID=" + cegID +
                ", ceg_nev='" + ceg_nev + '\'' +
                ", ceg_email='" + ceg_email + '\'' +
                ", ceg_telefon='" + ceg_telefon + '\'' +
                ", tartozkodasihelyID=" + tartozkodasihelyID +
                '}';
    }
}
