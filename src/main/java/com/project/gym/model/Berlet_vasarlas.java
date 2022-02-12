package com.project.gym.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "berlet_vasarlas")
public class Berlet_vasarlas implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "berlet_vasarlasID", nullable = false, updatable = false)
    private Long berlet_vasarlasID;

    @Column
    private String berlet_tipus;

    @Column
    private Integer berlet_ar;


    public Berlet_vasarlas(){}
    public Berlet_vasarlas(Long berlet_vasarlasID, String berlet_tipus, Integer berlet_ar) {
        this.berlet_vasarlasID = berlet_vasarlasID;
        this.berlet_tipus = berlet_tipus;
        this.berlet_ar = berlet_ar;
    }

    public Long getBerlet_vasarlasID() {
        return berlet_vasarlasID;
    }

    public void setBerlet_vasarlasID(Long berlet_vasarlasID) {
        this.berlet_vasarlasID = berlet_vasarlasID;
    }

    public String getBerlet_tipus() {
        return berlet_tipus;
    }

    public void setBerlet_tipus(String berlet_tipus) {
        this.berlet_tipus = berlet_tipus;
    }

    public Integer getBerlet_ar() {
        return berlet_ar;
    }

    public void setBerlet_ar(Integer berlet_ar) {
        this.berlet_ar = berlet_ar;
    }

    @Override
    public String toString() {
        return "Berlet_vasarlas{" +
                "berlet_vasarlasID=" + berlet_vasarlasID +
                ", berlet_tipus='" + berlet_tipus + '\'' +
                ", berlet_ar=" + berlet_ar +
                '}';
    }
}
