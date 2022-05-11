package com.project.gym.controller;

import com.project.gym.exception.NotFoundE.ApiNotFoundException;
import com.project.gym.model.*;
import com.project.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A Gym projekt Controller rétege.
 */
@RestController
@RequestMapping("/")
public class GymController {

    @Autowired
    private GymService gymService;

    /**
     * Felhasznalo olvas response entity.
     *
     * @return the response entity
     */
    @GetMapping("felhasznalo/felhOlvas")
    public ResponseEntity<List<Felhasznalo>> FelhasznaloOlvas() {
        List<Felhasznalo> lista = gymService.FelhasznaloOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A felhasználók nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    /**
     * Felhasznalo olvas by id response entity.
     *
     * @param felhasznaloID the felhasznalo id
     * @return the response entity
     */
    @GetMapping("felhasznalo/felhasznaloOlvasasByID/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> FelhasznaloOlvasByID(@PathVariable("felhasznaloID") Long felhasznaloID) {
        Iterable<String> felhasznalo = gymService.FelhasznaloOlvasByID(felhasznaloID);
        isEmpty(felhasznalo);
        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
    }

    /**
     * Felhasznalo letrehoz response entity.
     *
     * @param felhasznalo the felhasznalo
     * @return the response entity
     */
    @PostMapping("felhasznalo/felhLetrehoz")
    public ResponseEntity<?> FelhasznaloLetrehoz(@RequestBody Felhasznalo felhasznalo) {
        gymService.FelhasznaloLetrehoz(felhasznalo);
        return new ResponseEntity<>("Az új felhasználó létrejött!", HttpStatus.CREATED);
    }

    /**
     * Felhasznalo torles response entity.
     *
     * @param felhasznaloID the felhasznalo id
     * @return the response entity
     */
    @DeleteMapping("felhasznalo/felhTorles/{felhasznaloID}")
    public ResponseEntity<?> FelhasznaloTorles(@PathVariable("felhasznaloID") Long felhasznaloID) {
        gymService.FelhasznaloTorles(felhasznaloID);
        return new ResponseEntity<>("A felhasználó törlésre került!", HttpStatus.OK);
    }

    /**
     * Felhasznalo modosit response entity.
     *
     * @param felhasznalo the felhasznalo
     * @return the response entity
     */
    @PutMapping("felhasznalo/felhModosit")
    public ResponseEntity<?> FelhasznaloModosit(@RequestBody Felhasznalo felhasznalo) {
        gymService.FelhasznaloModosit(felhasznalo);
        return new ResponseEntity<>("A felhasználó módosításra került!", HttpStatus.OK);
    }

    /**
     * Berlet vasarlas olvas response entity.
     *
     * @return the response entity
     */
//**********************************************************************************
    @GetMapping("berletVasarlas/berletOlvas")
    public ResponseEntity<List<Berlet_vasarlas>> Berlet_vasarlasOlvas() {
        List<Berlet_vasarlas> lista = gymService.Berlet_vasarlasOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A bérletek nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    /**
     * Berlet vasarlas olvas by id response entity.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     * @return the response entity
     */
    @GetMapping("berletVasarlas/berlet_vasarlasOlvasByID/{berlet_vasarlasID}")
    @Transactional
    public ResponseEntity<?> Berlet_vasarlasOlvasByID(@PathVariable("berlet_vasarlasID") Long berlet_vasarlasID) {
        Iterable<String> berletVasarlas = gymService.Berlet_vasarlasOlvasByID(berlet_vasarlasID);
        isEmpty(berletVasarlas);
        return new ResponseEntity<>(berletVasarlas, HttpStatus.OK);
    }

    /**
     * Berlet vasarlas letrehoz response entity.
     *
     * @param berletVasarlas the berlet vasarlas
     * @return the response entity
     */
    @PostMapping("berletVasarlas/berletLetrehoz")
    public ResponseEntity<?> Berlet_vasarlasLetrehoz(@RequestBody Berlet_vasarlas berletVasarlas) {
        gymService.Berlet_vasarlasLetrehoz(berletVasarlas);
        return new ResponseEntity<>("Az új bérlet létrejött!", HttpStatus.OK);
    }

    /**
     * Berlet vasarlas torles response entity.
     *
     * @param berlet_vasarlasID the berlet vasarlas id
     * @return the response entity
     */
    @DeleteMapping("berletVasarlas/berletTorles/{berlet_vasarlasID}")
    public ResponseEntity<?> Berlet_vasarlasTorles(@PathVariable("berlet_vasarlasID") Long berlet_vasarlasID) {
        gymService.Berlet_vasarlasTorles(berlet_vasarlasID);
        return new ResponseEntity<>("A bérlet törlésre került!", HttpStatus.OK);
    }

    /**
     * Berlet vasarlas modosit response entity.
     *
     * @param berletVasarlas the berlet vasarlas
     * @return the response entity
     */
    @PutMapping("berletVasarlas/berletModosit")
    public ResponseEntity<?> Berlet_vasarlasModosit(@RequestBody Berlet_vasarlas berletVasarlas) {
        gymService.Berlet_vasarlasModosit(berletVasarlas);
        return new ResponseEntity<>("A bérlet módosításra került!", HttpStatus.OK);
    }

    //**********************************************************************************

    /**
     * Rendeles olvas response entity.
     *
     * @return the response entity
     */
    @GetMapping("rendeles/rendelesOlvas")
    public ResponseEntity<List<Rendeles>> RendelesOlvas() {
        List<Rendeles> lista = gymService.RendelesOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A rendelések nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    /**
     * Rendeles olvas by id response entity.
     *
     * @param rendelesID the rendeles id
     * @return the response entity
     */
    @GetMapping("rendeles/rendelesOlvasByID/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasByID(@PathVariable("rendelesID") Long rendelesID) {
        Iterable<String> rendeles = gymService.RendelesOlvasByID(rendelesID);
        isEmpty(rendeles);
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    /**
     * Rendeles olvas berlet by id response entity.
     *
     * @param rendelesID the rendeles id
     * @return the response entity
     */
    @GetMapping("rendeles/rendelesOlvasBerletByID/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasBerletByID(@PathVariable("rendelesID") Long rendelesID) {
        Iterable<String> rendeles = gymService.RendelesOlvasBerletByID(rendelesID);
        isEmpty(rendeles);
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    /**
     * Rendeles olvas felhasznalo by id response entity.
     *
     * @param rendelesID the rendeles id
     * @return the response entity
     */
    @GetMapping("rendeles/rendelesOlvasFelhasznaloByID/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasFelhasznaloByID(@PathVariable("rendelesID") Long rendelesID) {
        Iterable<String> rendeles = gymService.RendelesOlvasFelhasznaloByID(rendelesID);
        isEmpty(rendeles);
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    /**
     * Rendeles olvas termek by id response entity.
     *
     * @param rendelesID the rendeles id
     * @return the response entity
     */
    @GetMapping("rendeles/rendelesOlvasTermekByID/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasTermekByID(@PathVariable("rendelesID") Long rendelesID) {
        Iterable<String> rendeles = gymService.RendelesOlvasTermekByID(rendelesID);
        isEmpty(rendeles);
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    /**
     * Rendeles letrehoz berlet response entity.
     *
     * @param rendeles the rendeles
     * @return the response entity
     */
    @PostMapping("rendeles/rendelesLetrehozBerlet")
    public ResponseEntity<?> RendelesLetrehozBerlet(@RequestBody Rendeles rendeles) {
        gymService.RendelesLetrehozBerlet(rendeles);
        return new ResponseEntity<>("Az új rendelés létrejött!", HttpStatus.OK);
    }

    /**
     * Rendeles letrehoz termek response entity.
     *
     * @param rendeles the rendeles
     * @return the response entity
     */
    @PostMapping("rendeles/rendelesLetrehozTermek")
    public ResponseEntity<?> RendelesLetrehozTermek(@RequestBody Rendeles rendeles) {
        gymService.RendelesLetrehozTermek(rendeles);
        return new ResponseEntity<>("Az új rendelés létrejött!", HttpStatus.OK);
    }

    /**
     * Rendeles torles response entity.
     *
     * @param rendelesID the rendeles id
     * @return the response entity
     */
    @DeleteMapping("rendeles/rendelesTorles/{rendelesID}")
    public ResponseEntity<?> RendelesTorles(@PathVariable("rendelesID") Long rendelesID) {
        gymService.RendelesTorles(rendelesID);
        return new ResponseEntity<>("A rendelés törlésre került!", HttpStatus.OK);
    }
    //**********************************************************************************

    /**
     * Termek olvas response entity.
     *
     * @return the response entity
     */
    @GetMapping("termek/termekOlvas")
    public ResponseEntity<List<Termek>> TermekOlvas() {
        List<Termek> lista = gymService.TermekOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A termékek nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    /**
     * Termek olvas by id response entity.
     *
     * @param termekID the termek id
     * @return the response entity
     */
    @GetMapping("termek/termekOlvasByID/{termekID}")
    @Transactional
    public ResponseEntity<?> TermekOlvasByID(@PathVariable("termekID") Long termekID) {
        Iterable<String> termek = gymService.TermekOlvasByID(termekID);
        isEmpty(termek);
        return new ResponseEntity<>(termek, HttpStatus.OK);
    }

    /**
     * Termek letrehoz response entity.
     *
     * @param termek the termek
     * @return the response entity
     */
    @PostMapping("termek/termekLetrehoz")
    public ResponseEntity<?> TermekLetrehoz(@RequestBody Termek termek) {
        gymService.TermekLetrehoz(termek);
        return new ResponseEntity<>("Az új termék létrejött!", HttpStatus.OK);
    }

    /**
     * Termek torles response entity.
     *
     * @param termekID the termek id
     * @return the response entity
     */
    @DeleteMapping("termek/termekTorles/{termekID}")
    public ResponseEntity<?> TermekTorles(@PathVariable("termekID") Long termekID) {
        gymService.TermekTorles(termekID);
        return new ResponseEntity<>("A termék törlésre került!", HttpStatus.OK);
    }

    /**
     * Termek modosit response entity.
     *
     * @param termek the termek
     * @return the response entity
     */
    @PutMapping("termek/termekModosit")
    public ResponseEntity<?> TermekModosit(@RequestBody Termek termek) {
        gymService.TermekModosit(termek);
        return new ResponseEntity<>("A termék módosításra került!", HttpStatus.OK);
    }

    //**********************************************************************************

    /**
     * Szemelyi edzo olvas response entity.
     *
     * @return the response entity
     */
    @GetMapping("szemelyiEdzo/szemEdzoOlvas")
    public ResponseEntity<List<Szemelyi_edzo>> Szemelyi_edzoOlvas() {
        List<Szemelyi_edzo> lista = gymService.Szemelyi_edzoOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A személyi edzők nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    /**
     * Szemelyi edzo olvas by id response entity.
     *
     * @param szemelyi_edzoID the szemelyi edzo id
     * @return the response entity
     */
    @GetMapping("szemelyiEdzo/szemelyi_edzoOlvasByID/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasByID(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        Iterable<String> szemelyiEdzo = gymService.Szemelyi_edzoOlvasByID(szemelyi_edzoID);
        isEmpty(szemelyiEdzo);
        return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
    }

    /**
     * Szemelyi edzo letrehoz response entity.
     *
     * @param szemelyiEdzo the szemelyi edzo
     * @return the response entity
     */
    @PostMapping("szemelyiEdzo/szemelyiEdzoLetrehoz")
    public ResponseEntity<?> Szemelyi_edzoLetrehoz(@RequestBody Szemelyi_edzo szemelyiEdzo) {
        gymService.Szemelyi_edzoLetrehoz(szemelyiEdzo);
        return new ResponseEntity<>("Az új személyi edző létrejött!", HttpStatus.OK);
    }

    /**
     * Szemelyi edzo torles response entity.
     *
     * @param szemelyi_edzoID the szemelyi edzo id
     * @return the response entity
     */
    @DeleteMapping("szemelyiEdzo/szemelyiEdzoTorles/{szemelyi_edzoID}")
    public ResponseEntity<?> Szemelyi_edzoTorles(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        gymService.Szemelyi_edzoTorles(szemelyi_edzoID);
        return new ResponseEntity<>("A személyi edző törlésre került!", HttpStatus.OK);
    }

    /**
     * Szemelyi edzo modosit response entity.
     *
     * @param szemelyiEdzo the szemelyi edzo
     * @return the response entity
     */
    @PutMapping("szemelyiEdzo/szemelyiEdzoModosit")
    public ResponseEntity<?> Szemelyi_edzoModosit(@RequestBody Szemelyi_edzo szemelyiEdzo) {
        gymService.Szemelyi_edzoModosit(szemelyiEdzo);
        return new ResponseEntity<>("A személyi edző módosításra került!", HttpStatus.OK);
    }

    /**
     * Is empty.
     *
     * @param iterable the iterable
     */
    public static void isEmpty(Iterable<?> iterable) {
        int counter = 0;
        for (Object obj : iterable) {
            counter++;
        }
        if (counter == 0) throw new ApiNotFoundException("Nem található érték az adott ID-nál!");
    }
}
