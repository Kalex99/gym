package com.project.gym.controller;

import com.project.gym.exception.NotFoundE.ApiNotFoundException;
import com.project.gym.model.*;
import com.project.gym.repository.Berlet_vasarlasRep;
import com.project.gym.service.GymService;
import com.project.gym.test.FelhasznaloTartozkodasihely;
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
        if(lista.isEmpty()) throw new ApiNotFoundException("A felhasználók nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/bejelentkezesRendeles/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesRendeles(@PathVariable("felhasznaloID") Long felhasznaloID){
        Iterable<String> felhasznalo = gymService.BejelentkezesRendeles(felhasznaloID);
        isEmpty(felhasznalo);
        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/bejelentkezesSzemelyiEdzo/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesSzemelyiEdzo(@PathVariable("felhasznaloID") Long felhasznaloID) {
        Iterable<String> felhasznalo = gymService.BejelentkezesSzemelyiEdzo(felhasznaloID);
        isEmpty(felhasznalo);
        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/bejelentkezesTartozkodasihely/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesTartozkodasihely(@PathVariable("felhasznaloID") Long felhasznaloID) {
        Iterable<String> felhasznalo = gymService.BejelentkezesTartozkodasihely(felhasznaloID);
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

    @PostMapping("felhasznalo/Test")
    public ResponseEntity<?> Test(@RequestBody FelhasznaloTartozkodasihely felhasznaloTartozkodasihely) {
        gymService.Test(felhasznaloTartozkodasihely);
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

    @GetMapping("tartozkodasihely/tartHelyOlvas")
    public ResponseEntity<List<Tartozkodasihely>> TartozkodasihelyOlvas() {
        List<Tartozkodasihely> lista = gymService.TartozkodasihelyOlvas();
        if(lista.isEmpty()) throw new ApiNotFoundException("A tartozkodási helyek nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("tartozkodasihely/tartozkodasihelyOlvasByID/{tartozkodasihelyID}")
    @Transactional
    public ResponseEntity<?> TartozkodasihelyOlvasByID(@PathVariable("tartozkodasihelyID") Long tartozkodasihelyID) {
        Iterable<String> tartozkodasihely = gymService.TartozkodasihelyOlvasByID(tartozkodasihelyID);
        isEmpty(tartozkodasihely);
        return new ResponseEntity<>(tartozkodasihely, HttpStatus.OK);
    }

    @PostMapping("tartozkodasihely/tartLetrehoz")
    public ResponseEntity<?> TartozkodasihelyLetrehoz(@RequestBody Tartozkodasihely tartozkodasihely) {
        gymService.TartozkodasihelyLetrehoz(tartozkodasihely);
        return new ResponseEntity<>("Az új tartózkodási hely létrejött!", HttpStatus.OK);
    }

    @DeleteMapping("tartozkodasihely/tartTorles/{tartozkodasihelyID}")
    public ResponseEntity<?> TartozkodasihelyTorles(@PathVariable("tartozkodasihelyID") Long tartozkodasihelyID) {
        gymService.TartozkodasihelyTorles(tartozkodasihelyID);
        return new ResponseEntity<>("A tartózkodási hely törlésre került!", HttpStatus.OK);
    }

    @PutMapping("tartozkodasihely/tartModosit")
    public ResponseEntity<?> TartozkodasihelyModosit(@RequestBody Tartozkodasihely tartozkodasihely) {
        gymService.TartozkodasihelyModosit(tartozkodasihely);
        return new ResponseEntity<>("A tartózkodási hely módosításra került!", HttpStatus.OK);
    }

    //**********************************************************************************
    @GetMapping("berletVasarlas/berletOlvas")
    public ResponseEntity<List<Berlet_vasarlas>> Berlet_vasarlasOlvas() {
        List<Berlet_vasarlas> lista = gymService.Berlet_vasarlasOlvas();
        if(lista.isEmpty()) throw new ApiNotFoundException("A bérletek nem találhatóak meg!");
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
        if(lista.isEmpty()) throw new ApiNotFoundException("A rendelések nem találhatóak meg!");
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

    @PostMapping("rendeles/rendelesLetrehoz")
    public ResponseEntity<?> RendelesLetrehoz(@RequestBody Rendeles rendeles) {
        gymService.RendelesLetrehoz(rendeles);
        return new ResponseEntity<>("Az új rendelés létrejött!", HttpStatus.OK);
    }

    @DeleteMapping("rendeles/rendelesTorles/{rendelesID}")
    public ResponseEntity<?> RendelesTorles(@PathVariable("rendelesID") Long rendelesID) {
        gymService.RendelesTorles(rendelesID);
        return new ResponseEntity<>("A rendelés törlésre került!", HttpStatus.OK);
    }
    //**********************************************************************************

    @GetMapping("ceg/cegOlvas")
    public ResponseEntity<List<Ceg>> CegOlvas() {
        List<Ceg> lista = gymService.CegOlvas();
        if(lista.isEmpty()) throw new ApiNotFoundException("A cégek nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("ceg/cegOlvasByID/{cegID}")
    @Transactional
    public ResponseEntity<?> CegOlvasByID(@PathVariable("cegID") Long cegID) {
        Iterable<String> ceg = gymService.CegOlvasByID(cegID);
        isEmpty(ceg);
        return new ResponseEntity<>(ceg, HttpStatus.OK);
    }

    @GetMapping("ceg/cegOlvasTartozkodasihelyByID/{cegID}")
    @Transactional
    public ResponseEntity<?> CegOlvasTartozkodasihelyByID(@PathVariable("cegID") Long cegID) {
        Iterable<String> ceg = gymService.CegOlvasTartozkodasihelyByID(cegID);
        isEmpty(ceg);
        return new ResponseEntity<>(ceg, HttpStatus.OK);
    }

    @PostMapping("ceg/cegLetrehoz")
    public ResponseEntity<?> CegLetrehoz(@RequestBody Ceg ceg) {
        gymService.CegLetrehoz(ceg);
        return new ResponseEntity<>("Az új cég létrejött!", HttpStatus.OK);
    }

    @DeleteMapping("ceg/cegTorles/{cegID}")
    public ResponseEntity<?> CegTorles(@PathVariable("cegID") Long cegID) {
        gymService.CegTorles(cegID);
        return new ResponseEntity<>("A cég törlésre került!", HttpStatus.OK);
    }

    @PutMapping("ceg/cegModosit")
    public ResponseEntity<?> CegModosit(@RequestBody Ceg ceg) {
        gymService.CegModosit(ceg);
        return new ResponseEntity<>("A cég módosításra került!", HttpStatus.OK);
    }
    //**********************************************************************************

    @GetMapping("termek/termekOlvas")
    public ResponseEntity<List<Termek>> TermekOlvas() {
        List<Termek> lista = gymService.TermekOlvas();
        if(lista.isEmpty()) throw new ApiNotFoundException("A termékek nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("termek/termekOlvasByID/{termekID}")
    @Transactional
    public ResponseEntity<?> TermekOlvasByID(@PathVariable("termekID") Long termekID) {
        Iterable<String> termek = gymService.TermekOlvasByID(termekID);
        isEmpty(termek);
        return new ResponseEntity<>(termek, HttpStatus.OK);
    }

    @GetMapping("termek/termekOlvasCegByID/{termekID}")
    @Transactional
    public ResponseEntity<?> TermekOlvasCegByID(@PathVariable("termekID") Long termekID) {
        Iterable<String> termek = gymService.TermekOlvasCegByID(termekID);
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
        if(lista.isEmpty()) throw new ApiNotFoundException("A személyi edzők nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    @GetMapping("szemelyiEdzo/szemelyi_edzoOlvasByID/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasByID(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        Iterable<String> szemelyiEdzo = gymService.Szemelyi_edzoOlvasByID(szemelyi_edzoID);
        isEmpty(szemelyiEdzo);
        return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
    }

    @GetMapping("szemelyiEdzo/szemelyi_edzoOlvasFelhasznaloByID/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasFelhasznaloByID(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        Iterable<String> szemelyiEdzo = gymService.Szemelyi_edzoOlvasFelhasznaloByID(szemelyi_edzoID);
        isEmpty(szemelyiEdzo);
        return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
    }

    @GetMapping("szemelyiEdzo/szemelyi_edzoOlvasTartozkodasihelyByID/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasTartozkodasihelyByID(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        Iterable<String> szemelyiEdzo = gymService.Szemelyi_edzoOlvasTartozkodasihelyByID(szemelyi_edzoID);
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
        for (Object obj : iterable){
            counter++;
        }
        if(counter==0) throw new ApiNotFoundException("Nem található érték az adott ID-nál!");
    }
}
