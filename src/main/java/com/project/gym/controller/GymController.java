package com.project.gym.controller;

import com.project.gym.model.*;
import com.project.gym.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class GymController {

    @Autowired
    private GymService gymService;

    @GetMapping("felhasznalo/felhOlvas")
    public ResponseEntity<List<Felhasznalo>> FelhasznaloOlvasas() {
        List<Felhasznalo> lista = gymService.FelhasznaloOlvasas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("felhasznalo/bejelentkezesRendeles/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesRendeles(@PathVariable("felhasznaloID") Long felhasznaloID) {
        try {
            String felhasznalo = gymService.BejelentkezesRendeles(felhasznaloID);
            return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("felhasznalo/bejelentkezesSzemelyiEdzo/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesSzemelyiEdzo(@PathVariable("felhasznaloID") Long felhasznaloID) {
        try {
            String felhasznalo = gymService.BejelentkezesSzemelyiEdzo(felhasznaloID);
            return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("felhasznalo/bejelentkezesTartozkodasihely/{felhasznaloID}")
    @Transactional
    public ResponseEntity<?> BejelentkezesTartozkodasihely(@PathVariable("felhasznaloID") Long felhasznaloID) {
        try {
            String felhasznalo = gymService.BejelentkezesTartozkodasihely(felhasznaloID);
            return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
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
        try {
            gymService.FelhasznaloModosit(felhasznalo);
            return new ResponseEntity<>("A felhasználó módosításra került!", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    //**********************************************************************************
    @GetMapping("tartozkodasihely/tartozkodasihelyOlvas/{tartozkodasihelyID}")
    @Transactional
    public ResponseEntity<?> TartozkodasihelyOlvasas(@PathVariable("tartozkodasihelyID") Long tartozkodasihelyID) {
        try {
            String tartozkodasihely = gymService.TartozkodasihelyOlvasas(tartozkodasihelyID);
            return new ResponseEntity<>(tartozkodasihely, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
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
        try {
            gymService.TartozkodasihelyModosit(tartozkodasihely);
            return new ResponseEntity<>("A tartózkodási hely módosításra került!", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //**********************************************************************************
    @GetMapping("berletVasarlas/berletVasarlasOlvas/{berlet_vasarlasID}")
    @Transactional
    public ResponseEntity<?> Berlet_vasarlasOlvasas(@PathVariable("berlet_vasarlasID") Long berlet_vasarlasID) {
        try {
            String berletVasarlas = gymService.Berlet_vasarlasOlvasas(berlet_vasarlasID);
            return new ResponseEntity<>(berletVasarlas, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
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
        try {
            gymService.Berlet_vasarlasModosit(berletVasarlas);
            return new ResponseEntity<>("A bérlet módosításra került!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //**********************************************************************************
    @GetMapping("rendeles/rendelesOlvas/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasas(@PathVariable("rendelesID") Long rendelesID) {
        try {
            String rendeles = gymService.RendelesOlvasas(rendelesID);
            return new ResponseEntity<>(rendeles, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("rendeles/rendelesOlvasBerlet/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasasBerlet(@PathVariable("rendelesID") Long rendelesID) {
        try {
            String rendeles = gymService.RendelesOlvasasBerlet(rendelesID);
            return new ResponseEntity<>(rendeles, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("rendeles/rendelesOlvasasFelhasznalo/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasasFelhasznalo(@PathVariable("rendelesID") Long rendelesID) {
        try {
            String rendeles = gymService.RendelesOlvasasFelhasznalo(rendelesID);
            return new ResponseEntity<>(rendeles, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("rendeles/rendelesOlvasTermek/{rendelesID}")
    @Transactional
    public ResponseEntity<?> RendelesOlvasasTermek(@PathVariable("rendelesID") Long rendelesID) {
        try {
            String rendeles = gymService.RendelesOlvasasTermek(rendelesID);
            return new ResponseEntity<>(rendeles, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
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
        try {
            String ceg = gymService.CegOlvasas(cegID);
            return new ResponseEntity<>(ceg, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("ceg/cegOlvasasTartozkodasihely/{cegID}")
    @Transactional
    public ResponseEntity<?> CegOlvasasTartozkodasihely(@PathVariable("cegID") Long cegID) {
        try {
            String ceg = gymService.CegOlvasasTartozkodasihely(cegID);
            return new ResponseEntity<>(ceg, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
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
        try {
            gymService.CegModosit(ceg);
            return new ResponseEntity<>("A cég módosításra került!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //**********************************************************************************

    @GetMapping("termek/termekOlvasas/{termekID}")
    @Transactional
    public ResponseEntity<?> TermekOlvasas(@PathVariable("termekID") Long termekID) {
        try {
            String termek = gymService.TermekOlvasas(termekID);
            return new ResponseEntity<>(termek, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("termek/termekOlvasasCeg/{termekID}")
    @Transactional
    public ResponseEntity<?> TermekOlvasasCeg(@PathVariable("termekID") Long termekID) {
        try {
            String termek = gymService.TermekOlvasasCeg(termekID);
            return new ResponseEntity<>(termek, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
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
        try {
            gymService.TermekModosit(termek);
            return new ResponseEntity<>("A termék módosításra került!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //**********************************************************************************

    @GetMapping("szemelyiEdzo/szemelyiEdzoOlvasas/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasas(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        try {
            String szemelyiEdzo = gymService.Szemelyi_edzoOlvasas(szemelyi_edzoID);
            return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("szemelyiEdzo/szemelyiEdzoOlvasasFelhasznalo/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasasFelhasznalo(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        try {
            String szemelyiEdzo = gymService.Szemelyi_edzoOlvasasFelhasznalo(szemelyi_edzoID);
            return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("szemelyiEdzo/szemelyiEdzoOlvasasTartozkodasihely/{szemelyi_edzoID}")
    @Transactional
    public ResponseEntity<?> Szemelyi_edzoOlvasasTartozkodasihely(@PathVariable("szemelyi_edzoID") Long szemelyi_edzoID) {
        try {
            String szemelyiEdzo = gymService.Szemelyi_edzoOlvasasTartozkodasihely(szemelyi_edzoID);
            return new ResponseEntity<>(szemelyiEdzo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
        }
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
        try {
            gymService.Szemelyi_edzoModosit(szemelyiEdzo);
            return new ResponseEntity<>("A személyi edző módosításra került!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
