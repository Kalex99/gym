package com.project.gym.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Rendeles")
public class Rendeles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rendelesID",nullable = false, updatable = false)
    private Long rendelesID;

    @Column
    private Date rendeles_idopont;

    @Column
    private String megjegyzes;

    @Column(name = "termekID", insertable=false, updatable =false)
    private Long termekID;

    @Column(name = "berlet_vasarlasID", insertable=false, updatable =false)
    private Long berlet_vasarlasID;

    @Column(name = "felhasznaloID", insertable=false, updatable =false)
    private Long felhasznaloID;


    public Rendeles() {
    }

    public Rendeles(Long rendelesID, Date rendeles_idopont, String megjegyzes, Long termekID, Long berlet_vasarlasID, Long felhasznaloID) {
        this.rendelesID = rendelesID;
        this.rendeles_idopont = rendeles_idopont;
        this.megjegyzes = megjegyzes;
        this.termekID = termekID;
        this.berlet_vasarlasID = berlet_vasarlasID;
        this.felhasznaloID = felhasznaloID;
    }

    public Long getRendelesID() {
        return rendelesID;
    }

    public void setRendelesID(Long rendelesID) {
        this.rendelesID = rendelesID;
    }

    public Date getRendeles_idopont() {
        return rendeles_idopont;
    }

    public void setRendeles_idopont(Date rendeles_idopont) {
        this.rendeles_idopont = rendeles_idopont;
    }

    public String getMegjegyzes() {
        return megjegyzes;
    }

    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }

    public Long getTermekID() {
        return termekID;
    }

    public void setTermekID(Long termekID) {
        this.termekID = termekID;
    }

    public Long getBerlet_vasarlasID() {
        return berlet_vasarlasID;
    }

    public void setBerlet_vasarlasID(Long berlet_vasarlasID) {
        this.berlet_vasarlasID = berlet_vasarlasID;
    }

    public Long getFelhasznaloID() {
        return felhasznaloID;
    }

    public void setFelhasznaloID(Long felhasznaloID) {
        this.felhasznaloID = felhasznaloID;
    }

    @Override
    public String toString() {
        return "Rendeles{" +
                "rendelesID=" + rendelesID +
                ", rendeles_idopont=" + rendeles_idopont +
                ", megjegyzes='" + megjegyzes + '\'' +
                ", termekID=" + termekID +
                ", berlet_vasarlasID=" + berlet_vasarlasID +
                ", felhasznaloID=" + felhasznaloID +
                '}';
    }
}
