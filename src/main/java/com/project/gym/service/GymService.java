package com.project.gym.service;

import com.project.gym.exception.FelhasznaloNemTalalhatoException;
import com.project.gym.model.*;
import com.project.gym.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    @Autowired
    private FelhasznaloRep felhasznaloRep;

    public List<Felhasznalo> FelhasznaloOlvasas() {
        return felhasznaloRep.FelhasznaloOlvasas();
    }

    public String BejelentkezesRendeles(Long felhasznaloID) {
        return felhasznaloRep.BejelentkezesRendeles(felhasznaloID);
    }

    public String BejelentkezesSzemelyiEdzo(Long felhasznaloID) {
        return felhasznaloRep.BejelentkezesSzemelyiEdzo(felhasznaloID);
    }

    public String BejelentkezesTartozkodasihely(Long felhasznaloID) {
        return felhasznaloRep.BejelentkezesTartozkodasihely(felhasznaloID);
    }

    public void FelhasznaloLetrehoz(Felhasznalo felhasznalo) {
        felhasznaloRep.FelhasznaloLetrehoz(felhasznalo.getFelhasznalonev(),
                felhasznalo.getJelszo(),
                felhasznalo.getFelh_vezeteknev(),
                felhasznalo.getFelh_keresztnev(),
                felhasznalo.getFelh_email(),
                felhasznalo.getSzuletesi_datum(),
                felhasznalo.getFelh_telefon(),
                felhasznalo.getTartozkodasihelyID());
    }

    public void FelhasznaloTorles(Long felhasznaloID) {
        felhasznaloRep.FelhasznaloTorles(felhasznaloID);
    }

    public void FelhasznaloModosit(Felhasznalo felhasznalo) {
        felhasznaloRep.FelhasznaloModosit(felhasznalo.getFelhasznaloID(),
                felhasznalo.getFelhasznalonev(),
                felhasznalo.getJelszo(),
                felhasznalo.getFelh_vezeteknev(),
                felhasznalo.getFelh_keresztnev(),
                felhasznalo.getFelh_email(),
                felhasznalo.getFelh_telefon(),
                felhasznalo.getTartozkodasihelyID());
    }

    @Autowired
    private TartozkodasihelyRep tartozkodasihelyRep;

    public String TartozkodasihelyOlvasas(Long tartozkodasihelyID) {
        return tartozkodasihelyRep.TartozkodasihelyOlvasas(tartozkodasihelyID);
    }

    public void TartozkodasihelyLetrehoz(Tartozkodasihely tartozkodasihely) {
        tartozkodasihelyRep.TartozkodasihelyLetrehoz(tartozkodasihely.getIranyitoszam(),
                tartozkodasihely.getVaros(),
                tartozkodasihely.getKozterulet_neve(),
                tartozkodasihely.getKozterulet_jellege(),
                tartozkodasihely.getHaz_szam());
    }

    public void TartozkodasihelyTorles(Long tartozkodasihelyID) {
        tartozkodasihelyRep.TartozkodasihelyTorles(tartozkodasihelyID);
    }

    public void TartozkodasihelyModosit(Tartozkodasihely tartozkodasihely) {
        tartozkodasihelyRep.TartozkodasihelyModosit(tartozkodasihely.getTartozkodasihelyID(),
                tartozkodasihely.getIranyitoszam(),
                tartozkodasihely.getVaros(),
                tartozkodasihely.getKozterulet_neve(),
                tartozkodasihely.getKozterulet_jellege(),
                tartozkodasihely.getHaz_szam());
    }

    @Autowired
    private Berlet_vasarlasRep berlet_vasarlasRep;

    public String Berlet_vasarlasOlvasas(Long berlet_vasarlasID) {
        return berlet_vasarlasRep.Berlet_vasarlasOlvasas(berlet_vasarlasID);
    }

    public void Berlet_vasarlasLetrehoz(Berlet_vasarlas berlet_vasarlas) {
        berlet_vasarlasRep.Berlet_vasarlasLetrehoz(
                berlet_vasarlas.getBerlet_tipus(),
                berlet_vasarlas.getBerlet_ar());
    }

    public void Berlet_vasarlasTorles(Long berlet_vasarlasID) {
        berlet_vasarlasRep.Berlet_vasarlasTorles(berlet_vasarlasID);
    }

    public void Berlet_vasarlasModosit(Berlet_vasarlas berlet_vasarlas) {
        berlet_vasarlasRep.Berlet_vasarlasModosit(
                berlet_vasarlas.getBerlet_vasarlasID(),
                berlet_vasarlas.getBerlet_tipus(),
                berlet_vasarlas.getBerlet_ar());
    }

    @Autowired
    private RendelesRep rendelesRep;

    public String RendelesOlvasas(Long rendelesID) {
        return rendelesRep.RendelesOlvasas(rendelesID);
    }

    public String RendelesOlvasasBerlet(Long rendelesID) {
        return rendelesRep.RendelesOlvasasBerlet(rendelesID);

    }

    public String RendelesOlvasasFelhasznalo(Long rendelesID) {
        return rendelesRep.RendelesOlvasasFelhasznalo(rendelesID);
    }

    public String RendelesOlvasasTermek(Long rendelesID) {
        return rendelesRep.RendelesOlvasasTermek(rendelesID);
    }

    public void RendelesLetrehoz(Rendeles rendeles) {
        rendelesRep.RendelesLetrehoz(
                rendeles.getMegjegyzes(),
                rendeles.getTermekID(),
                rendeles.getBerlet_vasarlasID(),
                rendeles.getFelhasznaloID()
        );
    }

    public void RendelesTorles(Long rendelesID) {
        rendelesRep.RendelesTorles(rendelesID);
    }

    @Autowired
    private CegRep cegRep;

    public String CegOlvasas(Long cegID) {
        return cegRep.CegOlvasas(cegID);
    }

    public String CegOlvasasTartozkodasihely(Long cegID) {
        return cegRep.CegOlvasasTartozkodasihely(cegID);
    }

    public void CegLetrehoz(Ceg ceg) {
        cegRep.CegLetrehoz(
                ceg.getCeg_nev(),
                ceg.getCeg_email(),
                ceg.getCeg_telefon(),
                ceg.getTartozkodasihelyID());
    }

    public void CegTorles(Long cegID) {
        cegRep.CegTorles(cegID);
    }

    public void CegModosit(Ceg ceg) {
        cegRep.CegModosit(
                ceg.getCegID(),
                ceg.getCeg_nev(),
                ceg.getCeg_email(),
                ceg.getCeg_telefon(),
                ceg.getTartozkodasihelyID());
    }

    @Autowired
    private TermekRep termekRep;

    public String TermekOlvasas(Long termekID) {
        return termekRep.TermekOlvasas(termekID);
    }

    public String TermekOlvasasCeg(Long termekID) {
        return termekRep.TermekOlvasasCeg(termekID);
    }

    public void TermekLetrehoz(Termek termek) {
        termekRep.TermekLetrehoz(
                termek.getTermek_nev(),
                termek.getKategoria(),
                termek.getAr(),
                termek.getKep(),
                termek.getKeszlet(),
                termek.getLeiras(),
                termek.getCegID());
    }

    public void TermekTorles(Long termekID) {
        termekRep.TermekTorles(termekID);
    }

    public void TermekModosit(Termek termek) {
        termekRep.TermekModosit(
                termek.getTermekID(),
                termek.getTermek_nev(),
                termek.getKategoria(),
                termek.getAr(),
                termek.getKep(),
                termek.getKeszlet(),
                termek.getKaphato(),
                termek.getLeiras(),
                termek.getCegID());
    }

    @Autowired
    private Szemelyi_edzoRep szemelyi_edzoRep;

    public String Szemelyi_edzoOlvasas(Long szemelyi_edzoID) {
        return szemelyi_edzoRep.Szemelyi_edzoOlvasas(szemelyi_edzoID);
    }

    public String Szemelyi_edzoOlvasasFelhasznalo(Long szemelyi_edzoID) {
        return szemelyi_edzoRep.Szemelyi_edzoOlvasasFelhasznalo(szemelyi_edzoID);
    }

    public String Szemelyi_edzoOlvasasTartozkodasihely(Long szemelyi_edzoID) {
        return szemelyi_edzoRep.Szemelyi_edzoOlvasasTartozkodasihely(szemelyi_edzoID);
    }


    public void Szemelyi_edzoLetrehoz(Szemelyi_edzo szemelyiEdzo) {
        szemelyi_edzoRep.Szemelyi_edzoLetrehoz(
                szemelyiEdzo.getSzemedz_vezeteknev(),
                szemelyiEdzo.getSzemedz_keresztnev(),
                szemelyiEdzo.getPortre(),
                szemelyiEdzo.getSzemedz_email(),
                szemelyiEdzo.getSzemedz_telefon(),
                szemelyiEdzo.getTartozkodasihelyID());
    }

    public void Szemelyi_edzoTorles(Long szemelyi_edzoID) {
        szemelyi_edzoRep.Szemelyi_edzoTorles(szemelyi_edzoID);
    }

    public void Szemelyi_edzoModosit(Szemelyi_edzo szemelyiEdzo) {
        szemelyi_edzoRep.Szemelyi_edzoModosit(
                szemelyiEdzo.getSzemelyi_edzoID(),
                szemelyiEdzo.getSzemedz_vezeteknev(),
                szemelyiEdzo.getSzemedz_keresztnev(),
                szemelyiEdzo.getPortre(),
                szemelyiEdzo.getSzemedz_email(),
                szemelyiEdzo.getSzemedz_telefon(),
                szemelyiEdzo.getTartozkodasihelyID());
    }

/*    @Autowired
    private FelhasznaloSzemelyiEdzoRep felhasznaloSzemelyiEdzoRep;*/
}
