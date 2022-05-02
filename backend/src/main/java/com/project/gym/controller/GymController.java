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

@RestController
@RequestMapping("/")
public class GymController {

    @Autowired
    private GymService gymService;

    @GetMapping("felhasznalo/felhOlvas")
    public ResponseEntity<List<Felhasznalo>> FelhasznaloOlvas() {
        List<Felhasznalo> lista = gymService.FelhasznaloOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A felhasználók nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/bejelentkezesRendeles/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesRendeles(@PathVariable("felhasznaloID") Long felhasznaloID) {
        Iterable<String> felhasznalo = gymService.BejelentkezesRendeles(felhasznaloID);
        isEmpty(felhasznalo);
        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
    }
    @GetMapping("felhasznalo/BejelentkezesAccount2/{felhasznalonev}/{jelszo}")
    @Transactional
    public ResponseEntity<List<Felhasznalo>> BejelentkezesAccount(@PathVariable("felhasznalonev") String felhasznalonev, @PathVariable("jelszo") String jelszo) {
        List<Felhasznalo> felhasznalo = gymService.BejelentkezesAccount(felhasznalonev,jelszo);
        isEmpty(felhasznalo);
        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/felhasznaloOlvasasByID/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> FelhasznaloOlvasByID(@PathVariable("felhasznaloID") Long felhasznaloID) {
        Iterable<String> felhasznalo = gymService.FelhasznaloOlvasByID(felhasznaloID);
        isEmpty(felhasznalo);
        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
    }

    @PostMapping("felhasznalo/felhLetrehoz")
    public ResponseEntity<?> FelhasznaloLetrehoz(@RequestBody Felhasznalo felhasznalo) {
        gymService.FelhasznaloLetrehoz(felhasznalo);
        return new ResponseEntity<>("Az új felhasználó létrejött!", HttpStatus.CREATED);
    }

    @DeleteMapping("felhasznalo/felhTorles/{felhasznaloID}")
    public ResponseEntity<?> FelhasznaloTorles(@PathVariable("felhasznaloID") Long felhasznaloID) {
        gymService.FelhasznaloTorles(felhasznaloID);
        return new ResponseEntity<>("A felhasználó törlésre került!", HttpStatus.OK);
    }

    @PutMapping("felhasznalo/felhModosit")
    public ResponseEntity<?> FelhasznaloModosit(@RequestBody Felhasznalo felhasznalo) {
        gymService.FelhasznaloModosit(felhasznalo);
        return new ResponseEntity<>("A felhasználó módosításra került!", HttpStatus.OK);
    }

    //**********************************************************************************
    @GetMapping("berletVasarlas/berletOlvas")
    public ResponseEntity<List<Berlet_vasarlas>> Berlet_vasarlasOlvas() {
        List<Berlet_vasarlas> lista = gymService.Berlet_vasarlasOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A bérletek nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("berletVasarlas/berlet_vasarlasOlvasByID/{berlet_vasarlasID}")
    @Transactional
    public ResponseEntity<?> Berlet_vasarlasOlvasByID(@PathVariable("berlet_vasarlasID") Long berlet_vasarlasID) {
        Iterable<String> berletVasarlas = gymService.Berlet_vasarlasOlvasByID(berlet_vasarlasID);
        isEmpty(berletVasarlas);
        return new ResponseEntity<>(berletVasarlas, HttpStatus.OK);
    }

    @PostMapping("berletVasarlas/berletLetrehoz")
    public ResponseEntity<?> Berlet_vasarlasLetrehoz(@RequestBody Berlet_vasarlas berletVasarlas) {
        gymService.Berlet_vasarlasLetrehoz(berletVasarlas);
        return new ResponseEntity<>("Az új bérlet létrejött!", HttpStatus.OK);
    }

    @DeleteMapping("berletVasarlas/berletTorles/{berlet_vasarlasID}")
    public ResponseEntity<?> Berlet_vasarlasTorles(@PathVariable("berlet_vasarlasID") Long berlet_vasarlasID) {
        gymService.Berlet_vasarlasTorles(berlet_vasarlasID);
        return new ResponseEntity<>("A bérlet törlésre került!", HttpStatus.OK);
    }

    @PutMapping("berletVasarlas/berletModosit")
    public ResponseEntity<?> Berlet_vasarlasModosit(@RequestBody Berlet_vasarlas berletVasarlas) {
        gymService.Berlet_vasarlasModosit(berletVasarlas);
        return new ResponseEntity<>("A bérlet módosításra került!", HttpStatus.OK);
    }

    //**********************************************************************************

    @GetMapping("rendeles/rendelesOlvas")
    public ResponseEntity<List<Rendeles>> RendelesOlvas() {
        List<Rendeles> lista = gymService.RendelesOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A rendelések nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("rendeles/rendelesOlvasByID/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasByID(@PathVariable("rendelesID") Long rendelesID) {
        Iterable<String> rendeles = gymService.RendelesOlvasByID(rendelesID);
        isEmpty(rendeles);
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    @GetMapping("rendeles/rendelesOlvasBerletByID/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasBerletByID(@PathVariable("rendelesID") Long rendelesID) {
        Iterable<String> rendeles = gymService.RendelesOlvasBerletByID(rendelesID);
        isEmpty(rendeles);
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    @GetMapping("rendeles/rendelesOlvasFelhasznaloByID/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasFelhasznaloByID(@PathVariable("rendelesID") Long rendelesID) {
        Iterable<String> rendeles = gymService.RendelesOlvasFelhasznaloByID(rendelesID);
        isEmpty(rendeles);
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    @GetMapping("rendeles/rendelesOlvasTermekByID/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasTermekByID(@PathVariable("rendelesID") Long rendelesID) {
        Iterable<String> rendeles = gymService.RendelesOlvasTermekByID(rendelesID);
        isEmpty(rendeles);
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    @PostMapping("rendeles/rendelesLetrehozBerlet")
    public ResponseEntity<?> RendelesLetrehozBerlet(@RequestBody Rendeles rendeles) {
        gymService.RendelesLetrehozBerlet(rendeles);
        return new ResponseEntity<>("Az új rendelés létrejött!", HttpStatus.OK);
    }

    @PostMapping("rendeles/rendelesLetrehozTermek")
    public ResponseEntity<?> RendelesLetrehozTermek(@RequestBody Rendeles rendeles) {
        gymService.RendelesLetrehozTermek(rendeles);
        return new ResponseEntity<>("Az új rendelés létrejött!", HttpStatus.OK);
    }

    @DeleteMapping("rendeles/rendelesTorles/{rendelesID}")
    public ResponseEntity<?> RendelesTorles(@PathVariable("rendelesID") Long rendelesID) {
        gymService.RendelesTorles(rendelesID);
        return new ResponseEntity<>("A rendelés törlésre került!", HttpStatus.OK);
    }
    //**********************************************************************************

    @GetMapping("termek/termekOlvas")
    public ResponseEntity<List<Termek>> TermekOlvas() {
        List<Termek> lista = gymService.TermekOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A termékek nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("termek/termekOlvasByID/{termekID}")
    @Transactional
    public ResponseEntity<?> TermekOlvasByID(@PathVariable("termekID") Long termekID) {
        Iterable<String> termek = gymService.TermekOlvasByID(termekID);
        isEmpty(termek);
        return new ResponseEntity<>(termek, HttpStatus.OK);
    }

    @PostMapping("termek/termekLetrehoz")
    public ResponseEntity<?> TermekLetrehoz(@RequestBody Termek termek) {
        gymService.TermekLetrehoz(termek);
        return new ResponseEntity<>("Az új termék létrejött!", HttpStatus.OK);
    }

    @DeleteMapping("termek/termekTorles/{termekID}")
    public ResponseEntity<?> TermekTorles(@PathVariable("termekID") Long termekID) {
        gymService.TermekTorles(termekID);
        return new ResponseEntity<>("A termék törlésre került!", HttpStatus.OK);
    }

    @PutMapping("termek/termekModosit")
    public ResponseEntity<?> TermekModosit(@RequestBody Termek termek) {
        gymService.TermekModosit(termek);
        return new ResponseEntity<>("A termék módosításra került!", HttpStatus.OK);
    }

    //**********************************************************************************

    @GetMapping("szemelyiEdzo/szemEdzoOlvas")
    public ResponseEntity<List<Szemelyi_edzo>> Szemelyi_edzoOlvas() {
        List<Szemelyi_edzo> lista = gymService.Szemelyi_edzoOlvas();
        if (lista.isEmpty()) throw new ApiNotFoundException("A személyi edzők nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("szemelyiEdzo/szemelyi_edzoOlvasByID/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasByID(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        Iterable<String> szemelyiEdzo = gymService.Szemelyi_edzoOlvasByID(szemelyi_edzoID);
        isEmpty(szemelyiEdzo);
        return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
    }

    @PostMapping("szemelyiEdzo/szemelyiEdzoLetrehoz")
    public ResponseEntity<?> Szemelyi_edzoLetrehoz(@RequestBody Szemelyi_edzo szemelyiEdzo) {
        gymService.Szemelyi_edzoLetrehoz(szemelyiEdzo);
        return new ResponseEntity<>("Az új személyi edző létrejött!", HttpStatus.OK);
    }

    @DeleteMapping("szemelyiEdzo/szemelyiEdzoTorles/{szemelyi_edzoID}")
    public ResponseEntity<?> Szemelyi_edzoTorles(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        gymService.Szemelyi_edzoTorles(szemelyi_edzoID);
        return new ResponseEntity<>("A személyi edző törlésre került!", HttpStatus.OK);
    }

    @PutMapping("szemelyiEdzo/szemelyiEdzoModosit")
    public ResponseEntity<?> Szemelyi_edzoModosit(@RequestBody Szemelyi_edzo szemelyiEdzo) {
        gymService.Szemelyi_edzoModosit(szemelyiEdzo);
        return new ResponseEntity<>("A személyi edző módosításra került!", HttpStatus.OK);
    }

    public static void isEmpty(Iterable<?> iterable) {
        int counter = 0;
        for (Object obj : iterable) {
            counter++;
        }
        if (counter == 0) throw new ApiNotFoundException("Nem található érték az adott ID-nál!");
    }
}
