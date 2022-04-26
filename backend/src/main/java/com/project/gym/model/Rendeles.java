package com.project.gym.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Rendeles")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "RendelesOlvasByID", procedureName = "RendelesOlvasByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "rendeles_idopont", type = Date.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "megjegyzes", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "termekID", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_vasarlasID", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felhasznaloID", type = Integer.class)
                }),
        @NamedStoredProcedureQuery(name = "RendelesOlvasBerletByID", procedureName = "RendelesOlvasBerletByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_vasarlasID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_tipus", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "berlet_ar", type = Long.class)
                }),
        @NamedStoredProcedureQuery(name = "RendelesOlvasFelhasznaloByID", procedureName = "RendelesOlvasFelhasznaloByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felhasznaloID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_vezeteknev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_keresztnev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_email", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "felh_telefon", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "RendelesOlvasTermekByID", procedureName = "RendelesOlvasTermekByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "rendelesID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "termekID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "termek_nev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kategoria", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "ar", type = Integer.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "kep", type = byte[].class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "leiras", type = String.class)
                })

})

public class Rendeles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rendelesID", nullable = false, updatable = false)
    private Long rendelesID;

    @Column
    private Date rendeles_idopont;

    @Column
    private String megjegyzes;

    @Column(name = "termekID", insertable = false, updatable = false)
    private Long termekID;

    @Column(name = "berlet_vasarlasID", insertable = false, updatable = false)
    private Long berlet_vasarlasID;

    @Column(name = "felhasznaloID", insertable = false, updatable = false)
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
}
