package com.project.gym.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "felhasznaloszemelyiedzo")
public class Felhasznaloszemelyiedzo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "felhasznaloID", nullable = false, updatable = false)
    private Long felhasznaloID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "szemelyi_edzoID", nullable = false, updatable = false)
    private Long szemelyi_edzoID;

    public Felhasznaloszemelyiedzo() {
    }

    public Felhasznaloszemelyiedzo(Long felhasznaloID, Long szemelyi_edzoID) {
        this.felhasznaloID = felhasznaloID;
        this.szemelyi_edzoID = szemelyi_edzoID;
    }

    public Long getFelhasznaloID() {
        return felhasznaloID;
    }

    public void setFelhasznaloID(Long felhasznaloID) {
        this.felhasznaloID = felhasznaloID;
    }

    public Long getSzemelyi_edzoID() {
        return szemelyi_edzoID;
    }

    public void setSzemelyi_edzoID(Long szemelyi_edzoID) {
        this.szemelyi_edzoID = szemelyi_edzoID;
    }

    @Override
    public String toString() {
        return "felhasznaloszemelyiedzo{" +
                "felhasznaloID=" + felhasznaloID +
                ", szemelyi_edzoID=" + szemelyi_edzoID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Felhasznaloszemelyiedzo that = (Felhasznaloszemelyiedzo) o;
        return Objects.equals(felhasznaloID, that.felhasznaloID) && Objects.equals(szemelyi_edzoID, that.szemelyi_edzoID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(felhasznaloID, szemelyi_edzoID);
    }
}
