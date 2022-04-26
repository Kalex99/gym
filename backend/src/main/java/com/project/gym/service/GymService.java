package com.project.gym.service;

import com.project.gym.exception.BadRequestE.ApiBadRequestException;
import com.project.gym.model.*;
import com.project.gym.repository.*;
import com.project.gym.test.FelhasznaloTartozkodasihely;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    @Autowired
    private FelhasznaloRep felhasznaloRep;

    public List<Felhasznalo> FelhasznaloOlvas() {
        return felhasznaloRep.FelhasznaloOlvas();
    }

    public Iterable<String> BejelentkezesRendeles(Long felhasznaloID) {
        return felhasznaloRep.BejelentkezesRendeles(felhasznaloID);
    }

    public Iterable<String> BejelentkezesSzemelyiEdzo(Long felhasznaloID) {
        return felhasznaloRep.BejelentkezesSzemelyiEdzo(felhasznaloID);
    }

    public Iterable<String> BejelentkezesTartozkodasihely(Long felhasznaloID) {
        return felhasznaloRep.BejelentkezesTartozkodasihely(felhasznaloID);
    }

    public Iterable<String> FelhasznaloOlvasByID(Long felhasznaloID) {
        return felhasznaloRep.FelhasznaloOlvasByID(felhasznaloID);
    }

    public void FelhasznaloLetrehoz(Felhasznalo felhasznalo) {
        if (isNull(felhasznalo.getFelhasznalonev())
                && isNull(felhasznalo.getJelszo())
                && isNull(felhasznalo.getFelh_vezeteknev())
                && isNull(felhasznalo.getFelh_keresztnev())
                && isNull(felhasznalo.getFelh_email())
                && isNull(felhasznalo.getSzuletesi_datum())
                && isNull(felhasznalo.getFelh_telefon())) {
            felhasznaloRep.FelhasznaloLetrehoz(
                    felhasznalo.getFelhasznalonev(),
                    felhasznalo.getJelszo(),
                    felhasznalo.getFelh_vezeteknev(),
                    felhasznalo.getFelh_keresztnev(),
                    felhasznalo.getFelh_email(),
                    felhasznalo.getSzuletesi_datum(),
                    felhasznalo.getFelh_telefon(),
                    felhasznalo.getTartozkodasihelyID());
        } else {
            throw new ApiBadRequestException("Nem tartalmazhat null-t!");
        }
    }

    public void Test(FelhasznaloTartozkodasihely felhasznaloTartozkodasihely) {
//        if (isNull(tartozkodasihely.getIranyitoszam())
//                && isNull(tartozkodasihely.getVaros())
//                && isNull(felhasznalo.getFelhasznalonev())
//                && isNull(felhasznalo.getJelszo())) {
        felhasznaloRep.Test(
                felhasznaloTartozkodasihely.getIranyitoszam(),
                felhasznaloTartozkodasihely.getVaros(),
                felhasznaloTartozkodasihely.getFelhasznalonev(),
                felhasznaloTartozkodasihely.getJelszo());
//        } else {
//            throw new ApiBadRequestException("Nem tartalmazhat null-t!");
//        }
    }

    public void FelhasznaloTorles(Long felhasznaloID) {
        felhasznaloRep.FelhasznaloTorles(felhasznaloID);
    }

    public void FelhasznaloModosit(Felhasznalo felhasznalo) {
        if (isNull(felhasznalo.getFelhasznaloID())
                && isNull(felhasznalo.getFelhasznalonev())
                && isNull(felhasznalo.getJelszo())
                && isNull(felhasznalo.getFelh_vezeteknev())
                && isNull(felhasznalo.getFelh_keresztnev())
                && isNull(felhasznalo.getFelh_email())
                && isNull(felhasznalo.getSzuletesi_datum())
                && isNull(felhasznalo.getFelh_telefon())) {
            felhasznaloRep.FelhasznaloModosit(
                    felhasznalo.getFelhasznaloID(),
                    felhasznalo.getFelhasznalonev(),
                    felhasznalo.getJelszo(),
                    felhasznalo.getFelh_vezeteknev(),
                    felhasznalo.getFelh_keresztnev(),
                    felhasznalo.getFelh_email(),
                    felhasznalo.getFelh_telefon(),
                    felhasznalo.getTartozkodasihelyID());
        } else {
            throw new ApiBadRequestException("Felhasználó módosításnál nem lehet null érték megadva!");
        }
    }

    @Autowired
    private TartozkodasihelyRep tartozkodasihelyRep;

    public List<Tartozkodasihely> TartozkodasihelyOlvas() {
        return tartozkodasihelyRep.TartozkodasihelyOlvas();
    }

    public Iterable<String> TartozkodasihelyOlvasByID(Long tartozkodasihelyID) {
        return tartozkodasihelyRep.TartozkodasihelyOlvasByID(tartozkodasihelyID);
    }

    public void TartozkodasihelyLetrehoz(Tartozkodasihely tartozkodasihely) {
        if (isNull(tartozkodasihely.getIranyitoszam())
                && isNull(tartozkodasihely.getVaros())
                && isNull(tartozkodasihely.getKozterulet_neve())
                && isNull(tartozkodasihely.getKozterulet_jellege())
                && isNull(tartozkodasihely.getHaz_szam())) {
            tartozkodasihelyRep.TartozkodasihelyLetrehoz(
                    tartozkodasihely.getIranyitoszam(),
                    tartozkodasihely.getVaros(),
                    tartozkodasihely.getKozterulet_neve(),
                    tartozkodasihely.getKozterulet_jellege(),
                    tartozkodasihely.getHaz_szam());
        } else {
            throw new ApiBadRequestException("Nem lehet üresen semmelyik bemenő érték!");
        }
    }

    public void TartozkodasihelyTorles(Long tartozkodasihelyID) {
        tartozkodasihelyRep.TartozkodasihelyTorles(tartozkodasihelyID);
    }

    public void TartozkodasihelyModosit(Tartozkodasihely tartozkodasihely) {
        if (isNull(tartozkodasihely.getTartozkodasihelyID())
                && isNull(tartozkodasihely.getIranyitoszam())
                && isNull(tartozkodasihely.getVaros())
                && isNull(tartozkodasihely.getKozterulet_neve())
                && isNull(tartozkodasihely.getKozterulet_jellege())
                && isNull(tartozkodasihely.getHaz_szam())) {
            tartozkodasihelyRep.TartozkodasihelyModosit(
                    tartozkodasihely.getTartozkodasihelyID(),
                    tartozkodasihely.getIranyitoszam(),
                    tartozkodasihely.getVaros(),
                    tartozkodasihely.getKozterulet_neve(),
                    tartozkodasihely.getKozterulet_jellege(),
                    tartozkodasihely.getHaz_szam());
        } else {
            throw new ApiBadRequestException("Nem maradhat üresen semmi a tartozkodási hely módosításnál!");
        }
    }

    @Autowired
    private Berlet_vasarlasRep berlet_vasarlasRep;

    public List<Berlet_vasarlas> Berlet_vasarlasOlvas() {
        return berlet_vasarlasRep.Berlet_vasarlasOlvas();
    }

    public Iterable<String> Berlet_vasarlasOlvasByID(Long berlet_vasarlasID) {
        return berlet_vasarlasRep.Berlet_vasarlasOlvasByID(berlet_vasarlasID);
    }

    public void Berlet_vasarlasLetrehoz(Berlet_vasarlas berlet_vasarlas) {
        if (isNull(berlet_vasarlas.getBerlet_tipus())
                && isNull(berlet_vasarlas.getBerlet_ar())) {
            berlet_vasarlasRep.Berlet_vasarlasLetrehoz(
                    berlet_vasarlas.getBerlet_tipus(),
                    berlet_vasarlas.getBerlet_ar());
        } else {
            throw new ApiBadRequestException("Valahol nem lett érték megadva!");
        }
    }

    public void Berlet_vasarlasTorles(Long berlet_vasarlasID) {
        berlet_vasarlasRep.Berlet_vasarlasTorles(berlet_vasarlasID);
    }

    public void Berlet_vasarlasModosit(Berlet_vasarlas berlet_vasarlas) {
        if (isNull(berlet_vasarlas.getBerlet_vasarlasID())
                && isNull(berlet_vasarlas.getBerlet_tipus())
                && isNull(berlet_vasarlas.getBerlet_ar())) {
            berlet_vasarlasRep.Berlet_vasarlasModosit(
                    berlet_vasarlas.getBerlet_vasarlasID(),
                    berlet_vasarlas.getBerlet_tipus(),
                    berlet_vasarlas.getBerlet_ar());
        } else {
            throw new ApiBadRequestException("Null érték fellelhető valamely résznél!");
        }
    }

    @Autowired
    private RendelesRep rendelesRep;

    public List<Rendeles> RendelesOlvas() {
        return rendelesRep.RendelesOlvas();
    }

    public Iterable<String> RendelesOlvasByID(Long rendelesID) {
        return rendelesRep.RendelesOlvasByID(rendelesID);
    }

    public Iterable<String> RendelesOlvasBerletByID(Long rendelesID) {
        return rendelesRep.RendelesOlvasBerletByID(rendelesID);
    }

    public Iterable<String> RendelesOlvasFelhasznaloByID(Long rendelesID) {
        return rendelesRep.RendelesOlvasFelhasznaloByID(rendelesID);
    }

    public Iterable<String> RendelesOlvasTermekByID(Long rendelesID) {
        return rendelesRep.RendelesOlvasTermekByID(rendelesID);
    }

    public void RendelesLetrehoz(Rendeles rendeles) {
        rendelesRep.RendelesLetrehoz(
                rendeles.getMegjegyzes(),
                rendeles.getTermekID(),
                rendeles.getBerlet_vasarlasID(),
                rendeles.getFelhasznaloID());
    }

    public void RendelesTorles(Long rendelesID) {
        rendelesRep.RendelesTorles(rendelesID);
    }

    @Autowired
    private CegRep cegRep;

    public List<Ceg> CegOlvas() {
        return cegRep.CegOlvas();
    }

    public Iterable<String> CegOlvasByID(Long cegID) {
        return cegRep.CegOlvasByID(cegID);
    }

    public Iterable<String> CegOlvasTartozkodasihelyByID(Long cegID) {
        return cegRep.CegOlvasTartozkodasihelyByID(cegID);
    }

    public void CegLetrehoz(Ceg ceg) {
        if (isNull(ceg.getCeg_nev())
                && isNull(ceg.getCeg_email())
                && isNull(ceg.getCeg_telefon())) {
            cegRep.CegLetrehoz(
                    ceg.getCeg_nev(),
                    ceg.getCeg_email(),
                    ceg.getCeg_telefon(),
                    ceg.getTartozkodasihelyID());
        } else {
            throw new ApiBadRequestException("Null érték található a létrehozásnál!");
        }
    }

    public void CegTorles(Long cegID) {
        cegRep.CegTorles(cegID);
    }

    public void CegModosit(Ceg ceg) {
        if (isNull(ceg.getCegID())
                && isNull(ceg.getCeg_nev())
                && isNull(ceg.getCeg_email())
                && isNull(ceg.getCeg_telefon())) {
            cegRep.CegModosit(
                    ceg.getCegID(),
                    ceg.getCeg_nev(),
                    ceg.getCeg_email(),
                    ceg.getCeg_telefon(),
                    ceg.getTartozkodasihelyID());
        } else {
            throw new ApiBadRequestException("Valamely értek üres adatot kapott!");
        }
    }

    @Autowired
    private TermekRep termekRep;

    public List<Termek> TermekOlvas() {
        return termekRep.TermekOlvas();
    }

    public Iterable<String> TermekOlvasByID(Long termekID) {
        return termekRep.TermekOlvasByID(termekID);
    }

    public Iterable<String> TermekOlvasCegByID(Long termekID) {
        return termekRep.TermekOlvasCegByID(termekID);
    }

    public void TermekLetrehoz(Termek termek) {
        if (isNull(termek.getTermek_nev())
                && isNull(termek.getKategoria())
                && isNull(termek.getAr())
                && isNull(termek.getKep())
                && isNull(termek.getKeszlet())
                && isNull(termek.getKaphato())
                && isNull(termek.getLeiras())) {
            termekRep.TermekLetrehoz(
                    termek.getTermek_nev(),
                    termek.getKategoria(),
                    termek.getAr(),
                    termek.getKep(),
                    termek.getKeszlet(),
                    termek.getLeiras(),
                    termek.getCegID());
        } else {
            throw new ApiBadRequestException("Nem lehet null érték semmelyik érték megadásnál!");
        }
    }

    public void TermekTorles(Long termekID) {
        termekRep.TermekTorles(termekID);
    }

    public void TermekModosit(Termek termek) {
        if (isNull(termek.getTermekID())
                && isNull(termek.getTermek_nev())
                && isNull(termek.getKategoria())
                && isNull(termek.getAr())
                && isNull(termek.getKep())
                && isNull(termek.getKeszlet())
                && isNull(termek.getKaphato())
                && isNull(termek.getLeiras())) {
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
        } else {
            throw new ApiBadRequestException("Néhány érték null értéket kapott!");
        }
    }

    @Autowired
    private Szemelyi_edzoRep szemelyi_edzoRep;

    public List<Szemelyi_edzo> Szemelyi_edzoOlvas() {
        return szemelyi_edzoRep.Szemelyi_edzoOlvas();
    }

    public Iterable<String> Szemelyi_edzoOlvasByID(Long szemelyi_edzoID) {
        return szemelyi_edzoRep.Szemelyi_edzoOlvasByID(szemelyi_edzoID);
    }

    public Iterable<String> Szemelyi_edzoOlvasFelhasznaloByID(Long szemelyi_edzoID) {
        return szemelyi_edzoRep.Szemelyi_edzoOlvasFelhasznaloByID(szemelyi_edzoID);
    }

    public Iterable<String> Szemelyi_edzoOlvasTartozkodasihelyByID(Long szemelyi_edzoID) {
        return szemelyi_edzoRep.Szemelyi_edzoOlvasTartozkodasihelyByID(szemelyi_edzoID);
    }


    public void Szemelyi_edzoLetrehoz(Szemelyi_edzo szemelyiEdzo) {
        if (isNull(szemelyiEdzo.getSzemedz_vezeteknev())
                && isNull(szemelyiEdzo.getSzemedz_keresztnev())
                && isNull(szemelyiEdzo.getPortre())
                && isNull(szemelyiEdzo.getSzemedz_email())
                && isNull(szemelyiEdzo.getSzemedz_telefon())) {
            szemelyi_edzoRep.Szemelyi_edzoLetrehoz(
                    szemelyiEdzo.getSzemedz_vezeteknev(),
                    szemelyiEdzo.getSzemedz_keresztnev(),
                    szemelyiEdzo.getPortre(),
                    szemelyiEdzo.getSzemedz_email(),
                    szemelyiEdzo.getSzemedz_telefon(),
                    szemelyiEdzo.getTartozkodasihelyID());
        } else {
            throw new ApiBadRequestException("Egy vagy több érték üresen a személyi edző létrehozásnál maradt!");
        }

    }

    public void Szemelyi_edzoTorles(Long szemelyi_edzoID) {
        szemelyi_edzoRep.Szemelyi_edzoTorles(szemelyi_edzoID);
    }

    public void Szemelyi_edzoModosit(Szemelyi_edzo szemelyiEdzo) {
        if (isNull(szemelyiEdzo.getSzemelyi_edzoID())
                && isNull(szemelyiEdzo.getSzemedz_vezeteknev())
                && isNull(szemelyiEdzo.getSzemedz_keresztnev())
                && isNull(szemelyiEdzo.getPortre())
                && isNull(szemelyiEdzo.getSzemedz_email())
                && isNull(szemelyiEdzo.getSzemedz_telefon())) {
            szemelyi_edzoRep.Szemelyi_edzoModosit(
                    szemelyiEdzo.getSzemelyi_edzoID(),
                    szemelyiEdzo.getSzemedz_vezeteknev(),
                    szemelyiEdzo.getSzemedz_keresztnev(),
                    szemelyiEdzo.getPortre(),
                    szemelyiEdzo.getSzemedz_email(),
                    szemelyiEdzo.getSzemedz_telefon(),
                    szemelyiEdzo.getTartozkodasihelyID());
        } else {
            throw new ApiBadRequestException("Módosításnál minden érték legyen kitöltve!");
        }
    }

    public static boolean isNull(Object obj) {
        return obj != null && !"".equals(obj);
    }
}