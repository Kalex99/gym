package com.project.gym.test;

import com.project.gym.model.Felhasznalo;
import com.project.gym.model.Tartozkodasihely;

public class FelhasznaloTartozkodasihely {

    public Tartozkodasihely tartozkodasihely;

    public Felhasznalo felhasznalo;






    public int getIranyitoszam() {
        return tartozkodasihely.getIranyitoszam();
    }
    public String getVaros() {
        return tartozkodasihely.getVaros();
    }

    public String getFelhasznalonev() {
        return felhasznalo.getFelhasznalonev();
    }
    public String getJelszo() {
        return felhasznalo.getJelszo();
    }
}
