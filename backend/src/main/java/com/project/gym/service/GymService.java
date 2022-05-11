package com.project.gym.service;

import com.project.gym.exception.BadRequestE.ApiBadRequestException;
import com.project.gym.model.*;
import com.project.gym.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.event.ObjectChangeListener;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

/**
 * Gym projekt Service rétege.
 */
@Service
public class GymService {

    @Autowired
    private FelhasznaloRep felhasznaloRep;

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Felhasznalo olvas list.
     *
     * @return the list
     */
    public List<Felhasznalo> FelhasznaloOlvas() {
        return felhasznaloRep.FelhasznaloOlvas();
    }


    /**
     * Felhasznalo olvas by id iterable.
     *
     * @param felhasznaloID the felhasznalo id
     * @return the iterable
     */
    public Iterable<String> FelhasznaloOlvasByID(Long felhasznaloID) {
        return felhasznaloRep.FelhasznaloOlvasByID(felhasznaloID);
    }

    /**
     * Felhasznalo letrehoz.
     *
     * @param felhasznalo the felhasznalo
     */
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
                    felhasznalo.getFelh_telefon());
        } else {
            throw new ApiBadRequestException("Nem tartalmazhat null-t!");
        }
    }

    /**
     * Felhasznalo torles.
     *
     * @param felhasznaloID the felhasznalo id
     */
    public void FelhasznaloTorles(Long felhasznaloID) {
        felhasznaloRep.FelhasznaloTorles(felhasznaloID);
    }

    /**
     * Felhasznalo modosit.
     *
     * @param felhasznalo the felhasznalo
     */
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
                    felhasznalo.getFelh_telefon());
        } else {
            throw new ApiBadRequestException("Felhasználó módosításnál nem lehet null érték megadva!");
        }
    }


    @Autowired
    private Berlet_vasarlasRep berlet_vasarlasRep;

    /**
     * Berlet vasarlas olvas list.
     *
     * @return the list
     */
    public List<Berlet_vasarlas> Berlet_vasarlasOlvas() {
        return berlet_vasarlasRep.Berlet_vasarlasOlvas();
    }

    /**
     * Berlet vasarlas olvas by id iterable.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     * @return the iterable
     */
    public Iterable<String> Berlet_vasarlasOlvasByID(Long berlet_vasarlasID) {
        return berlet_vasarlasRep.Berlet_vasarlasOlvasByID(berlet_vasarlasID);
    }

    /**
     * Berlet vasarlas letrehoz.
     *
     * @param berlet_vasarlas the berlet vasarlas
     */
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

    /**
     * Berlet vasarlas torles.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     */
    public void Berlet_vasarlasTorles(Long berlet_vasarlasID) {
        berlet_vasarlasRep.Berlet_vasarlasTorles(berlet_vasarlasID);
    }

    /**
     * Berlet vasarlas modosit.
     *
     * @param berlet_vasarlas the berlet vasarlas
     */
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

    /**
     * Rendeles olvas list.
     *
     * @return the list
     */
    public List<Rendeles> RendelesOlvas() {
        return rendelesRep.RendelesOlvas();
    }

    /**
     * Rendeles olvas by id iterable.
     *
     * @param rendelesID the rendeles id
     * @return the iterable
     */
    public Iterable<String> RendelesOlvasByID(Long rendelesID) {
        return rendelesRep.RendelesOlvasByID(rendelesID);
    }

    /**
     * Rendeles olvas berlet by id iterable.
     *
     * @param rendelesID the rendeles id
     * @return the iterable
     */
    public Iterable<String> RendelesOlvasBerletByID(Long rendelesID) {
        return rendelesRep.RendelesOlvasBerletByID(rendelesID);
    }

    /**
     * Rendeles olvas felhasznalo by id iterable.
     *
     * @param rendelesID the rendeles id
     * @return the iterable
     */
    public Iterable<String> RendelesOlvasFelhasznaloByID(Long rendelesID) {
        return rendelesRep.RendelesOlvasFelhasznaloByID(rendelesID);
    }

    /**
     * Rendeles olvas termek by id iterable.
     *
     * @param rendelesID the rendeles id
     * @return the iterable
     */
    public Iterable<String> RendelesOlvasTermekByID(Long rendelesID) {
        return rendelesRep.RendelesOlvasTermekByID(rendelesID);
    }

    /**
     * Rendeles letrehoz berlet.
     *
     * @param rendeles the rendeles
     */
    public void RendelesLetrehozBerlet(Rendeles rendeles) {
        if (isNull(rendeles.getBerlet_vasarlasID())
                && isNull(rendeles.getFelhasznaloID())) {
            rendelesRep.RendelesLetrehozBerlet(
                    rendeles.getBerlet_vasarlasID(),
                    rendeles.getMegjegyzes(),
                    rendeles.getFelhasznaloID());
        } else {
            throw new ApiBadRequestException("Nem lehet null érték semmelyik érték megadásnál!");
        }
    }

    /**
     * Rendeles letrehoz termek.
     *
     * @param rendeles the rendeles
     */
    public void RendelesLetrehozTermek(Rendeles rendeles) {
        if (isNull(rendeles.getTermekID())
                && isNull(rendeles.getMennyiseg())
                && isNull(rendeles.getFelhasznaloID())) {
            rendelesRep.RendelesLetrehozTermek(
                    rendeles.getTermekID(),
                    rendeles.getMegjegyzes(),
                    rendeles.getMennyiseg(),
                    rendeles.getFelhasznaloID());
        } else {
            throw new ApiBadRequestException("Nem lehet null érték semmelyik érték megadásnál!");
        }
    }

    /**
     * Rendeles torles.
     *
     * @param rendelesID the rendeles id
     */
    public void RendelesTorles(Long rendelesID) {
        rendelesRep.RendelesTorles(rendelesID);
    }

    @Autowired
    private TermekRep termekRep;

    /**
     * Termek olvas list.
     *
     * @return the list
     */
    public List<Termek> TermekOlvas() {
        return termekRep.TermekOlvas();
    }

    /**
     * Termek olvas by id iterable.
     *
     * @param termekID the termek id
     * @return the iterable
     */
    public Iterable<String> TermekOlvasByID(Long termekID) {
        return termekRep.TermekOlvasByID(termekID);
    }


    /**
     * Termek letrehoz.
     *
     * @param termek the termek
     */
    public void TermekLetrehoz(Termek termek) {
        if (isNull(termek.getTermek_nev())
                && isNull(termek.getAr())
                && isNull(termek.getKeszlet())
                && isNull(termek.getLeiras())) {
            termekRep.TermekLetrehoz(
                    termek.getTermek_nev(),
                    termek.getAr(),
                    termek.getKeszlet(),
                    termek.getLeiras());
        } else {
            throw new ApiBadRequestException("Nem lehet null érték semmelyik érték megadásnál!");
        }
    }

    /**
     * Termek torles.
     *
     * @param termekID the termek id
     */
    public void TermekTorles(Long termekID) {
        termekRep.TermekTorles(termekID);
    }

    /**
     * Termek modosit.
     *
     * @param termek the termek
     */
    public void TermekModosit(Termek termek) {
        if (isNull(termek.getTermekID())
                && isNull(termek.getTermek_nev())
                && isNull(termek.getAr())
                && isNull(termek.getKeszlet())
                && isNull(termek.getKaphato())
                && isNull(termek.getLeiras())) {
            termekRep.TermekModosit(
                    termek.getTermekID(),
                    termek.getTermek_nev(),
                    termek.getAr(),
                    termek.getKeszlet(),
                    termek.getKaphato(),
                    termek.getLeiras());
        } else {
            throw new ApiBadRequestException("Néhány érték null értéket kapott!");
        }
    }

    @Autowired
    private Szemelyi_edzoRep szemelyi_edzoRep;

    /**
     * Szemelyi edzo olvas list.
     *
     * @return the list
     */
    public List<Szemelyi_edzo> Szemelyi_edzoOlvas() {
        return szemelyi_edzoRep.Szemelyi_edzoOlvas();
    }

    /**
     * Szemelyi edzo olvas by id iterable.
     *
     * @param szemelyi_edzoID the szemelyi edzo id
     * @return the iterable
     */
    public Iterable<String> Szemelyi_edzoOlvasByID(Long szemelyi_edzoID) {
        return szemelyi_edzoRep.Szemelyi_edzoOlvasByID(szemelyi_edzoID);
    }

    /**
     * Szemelyi edzo letrehoz.
     *
     * @param szemelyiEdzo the szemelyi edzo
     */
    public void Szemelyi_edzoLetrehoz(Szemelyi_edzo szemelyiEdzo) {
        if (isNull(szemelyiEdzo.getSzemedz_vezeteknev())
                && isNull(szemelyiEdzo.getSzemedz_keresztnev())
                && isNull(szemelyiEdzo.getSzemedz_email())
                && isNull(szemelyiEdzo.getSzemedz_telefon())) {
            szemelyi_edzoRep.Szemelyi_edzoLetrehoz(
                    szemelyiEdzo.getSzemedz_vezeteknev(),
                    szemelyiEdzo.getSzemedz_keresztnev(),
                    szemelyiEdzo.getSzemedz_email(),
                    szemelyiEdzo.getSzemedz_telefon()
            );
        } else {
            throw new ApiBadRequestException("Egy vagy több érték üresen a személyi edző létrehozásnál maradt!");
        }
    }

    /**
     * Szemelyi edzo torles.
     *
     * @param szemelyi_edzoID the szemelyi edzo id
     */
    public void Szemelyi_edzoTorles(Long szemelyi_edzoID) {
        szemelyi_edzoRep.Szemelyi_edzoTorles(szemelyi_edzoID);
    }

    /**
     * Szemelyi edzo modosit.
     *
     * @param szemelyiEdzo the szemelyi edzo
     */
    public void Szemelyi_edzoModosit(Szemelyi_edzo szemelyiEdzo) {
        if (isNull(szemelyiEdzo.getSzemelyi_edzoID())
                && isNull(szemelyiEdzo.getSzemedz_vezeteknev())
                && isNull(szemelyiEdzo.getSzemedz_keresztnev())
                && isNull(szemelyiEdzo.getSzemedz_email())
                && isNull(szemelyiEdzo.getSzemedz_telefon())) {
            szemelyi_edzoRep.Szemelyi_edzoModosit(
                    szemelyiEdzo.getSzemelyi_edzoID(),
                    szemelyiEdzo.getSzemedz_vezeteknev(),
                    szemelyiEdzo.getSzemedz_keresztnev(),
                    szemelyiEdzo.getSzemedz_email(),
                    szemelyiEdzo.getSzemedz_telefon());
        } else {
            throw new ApiBadRequestException("Módosításnál minden érték legyen kitöltve!");
        }
    }

    /**
     * Is null boolean.
     *
     * @param obj the obj
     * @return the boolean
     */
    public static boolean isNull(Object obj) {
        return obj != null && !"".equals(obj);
    }
}
