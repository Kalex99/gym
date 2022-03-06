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
    public ResponseEntity<List<Felhasznalo>> FelhasznaloOlvasas() {
        List<Felhasznalo> lista = gymService.FelhasznaloOlvasas();
        if(lista.isEmpty()) throw new ApiNotFoundException("A felhasználók nem találhatóak meg!");
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/bejelentkezesRendeles/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesRendeles(@PathVariable("felhasznaloID") Long felhasznaloID) {
        String felhasznalo = gymService.BejelentkezesRendeles(felhasznaloID);
        if (felhasznalo==null) throw new ApiNotFoundException("A felhasználó nem található!");
        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/bejelentkezesSzemelyiEdzo/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesSzemelyiEdzo(@PathVariable("felhasznaloID") Long felhasznaloID) {
        String felhasznalo = gymService.BejelentkezesSzemelyiEdzo(felhasznaloID);
        if (felhasznalo==null) throw new ApiNotFoundException("A felhasználó nem található!");
        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/bejelentkezesTartozkodasihely/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesTartozkodasihely(@PathVariable("felhasznaloID") Long felhasznaloID) {
        String felhasznalo = gymService.BejelentkezesTartozkodasihely(felhasznaloID);
        if (felhasznalo==null) throw new ApiNotFoundException("A felhasználó nem található!");
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
    @GetMapping("tartozkodasihely/tartozkodasihelyOlvas/{tartozkodasihelyID}")
    @Transactional
    public ResponseEntity<?> TartozkodasihelyOlvasas(@PathVariable("tartozkodasihelyID") Long tartozkodasihelyID) {
        String tartozkodasihely = gymService.TartozkodasihelyOlvasas(tartozkodasihelyID);
        if (tartozkodasihely==null) throw new ApiNotFoundException("A tartozkodasihely nem található!");
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
    @GetMapping("berletVasarlas/berletVasarlasOlvas/{berlet_vasarlasID}")
    @Transactional
    public ResponseEntity<?> Berlet_vasarlasOlvasas(@PathVariable("berlet_vasarlasID") Long berlet_vasarlasID) {
        String berletVasarlas = gymService.Berlet_vasarlasOlvasas(berlet_vasarlasID);
        if (berletVasarlas==null) throw new ApiNotFoundException("A bérlet nem található!");
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
    @GetMapping("rendeles/rendelesOlvas/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasas(@PathVariable("rendelesID") Long rendelesID) {
        String rendeles = gymService.RendelesOlvasas(rendelesID);
        if (rendeles==null) throw new ApiNotFoundException("A megadott rendelés nem található!");
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    @GetMapping("rendeles/rendelesOlvasBerlet/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasasBerlet(@PathVariable("rendelesID") Long rendelesID) {
        String rendeles = gymService.RendelesOlvasasBerlet(rendelesID);
        if (rendeles==null) throw new ApiNotFoundException("A rendeléshez adott bérlet vagy maga a rendelés nem található!");
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    @GetMapping("rendeles/rendelesOlvasasFelhasznalo/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasasFelhasznalo(@PathVariable("rendelesID") Long rendelesID) {
        String rendeles = gymService.RendelesOlvasasFelhasznalo(rendelesID);
        if (rendeles==null) throw new ApiNotFoundException("A rendeléshez tartozó felhasználó vagy rendelés nem található!");
        return new ResponseEntity<>(rendeles, HttpStatus.OK);
    }

    @GetMapping("rendeles/rendelesOlvasTermek/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasasTermek(@PathVariable("rendelesID") Long rendelesID) {
        String rendeles = gymService.RendelesOlvasasTermek(rendelesID);
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

    @GetMapping("ceg/cegOlvasas/{cegID}")
    @Transactional
    public ResponseEntity<?> CegOlvasas(@PathVariable("cegID") Long cegID) {
        String ceg = gymService.CegOlvasas(cegID);
        if (ceg==null) throw new ApiNotFoundException("A cég nem található!");
        return new ResponseEntity<>(ceg, HttpStatus.OK);
    }

    @GetMapping("ceg/cegOlvasasTartozkodasihely/{cegID}")
    @Transactional
    public ResponseEntity<?> CegOlvasasTartozkodasihely(@PathVariable("cegID") Long cegID) {
        String ceg = gymService.CegOlvasasTartozkodasihely(cegID);
        if (ceg==null) throw new ApiNotFoundException("A cég vagy a hozzá kapcsolódó tartozkodási hely nem található!");
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

    @GetMapping("termek/termekOlvasas/{termekID}")
    @Transactional
    public ResponseEntity<?> TermekOlvasas(@PathVariable("termekID") Long termekID) {
        String termek = gymService.TermekOlvasas(termekID);
        if (termek==null) throw new ApiNotFoundException("A termék nem található!");
        return new ResponseEntity<>(termek, HttpStatus.OK);
    }

    @GetMapping("termek/termekOlvasasCeg/{termekID}")
    @Transactional
    public ResponseEntity<?> TermekOlvasasCeg(@PathVariable("termekID") Long termekID) {
        String termek = gymService.TermekOlvasasCeg(termekID);
        if (termek==null) throw new ApiNotFoundException("A termék vagy a cég nem található!");
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

    @GetMapping("szemelyiEdzo/szemelyiEdzoOlvasas/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasas(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        String szemelyiEdzo = gymService.Szemelyi_edzoOlvasas(szemelyi_edzoID);
        if (szemelyiEdzo==null) throw new ApiNotFoundException("A személyi edző nem található!");
        return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
    }

    @GetMapping("szemelyiEdzo/szemelyiEdzoOlvasasFelhasznalo/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasasFelhasznalo(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        String szemelyiEdzo = gymService.Szemelyi_edzoOlvasasFelhasznalo(szemelyi_edzoID);
        if (szemelyiEdzo==null) throw new ApiNotFoundException("A személyi edző vagy a hozzá tartozó felhasználó(k) nem található(ak)!");
        return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
    }

    @GetMapping("szemelyiEdzo/szemelyiEdzoOlvasasTartozkodasihely/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasasTartozkodasihely(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        String szemelyiEdzo = gymService.Szemelyi_edzoOlvasasTartozkodasihely(szemelyi_edzoID);
        if (szemelyiEdzo==null) throw new ApiNotFoundException("A személyi edző vagy a tartozkodási helye nem található!");
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
}
