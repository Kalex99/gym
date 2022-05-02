package com.project.gym.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

@Entity
@Table(name = "szemelyi_edzo")
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "Szemelyi_edzoOlvasByID", procedureName = "Szemelyi_edzoOlvasByID",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "szemelyi_edzoID", type = Long.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_vezeteknev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_keresztnev", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_email", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "szemedz_telefon", type = String.class)
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
    private String szemedz_email;

    @Column
    private String szemedz_telefon;

    public Szemelyi_edzo() {
    }

    public Szemelyi_edzo(Long szemelyi_edzoID, String szemedz_vezeteknev, String szemedz_keresztnev, String szemedz_email, String szemedz_telefon, Long tartozkodasihelyID) {
        this.szemelyi_edzoID = szemelyi_edzoID;
        this.szemedz_vezeteknev = szemedz_vezeteknev;
        this.szemedz_keresztnev = szemedz_keresztnev;
        this.szemedz_email = szemedz_email;
        this.szemedz_telefon = szemedz_telefon;
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
}
