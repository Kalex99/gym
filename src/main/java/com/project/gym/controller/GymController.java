package com.project.gym.controller;

import com.project.gym.model.Felhasznalo;
import com.project.gym.model.Tartozkodasihely;
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

    @GetMapping("felhasznalo/felh_olvas")
    public ResponseEntity<List<Felhasznalo>> FelhasznaloOlvasas() {
        List<Felhasznalo> lista = gymService.FelhasznaloOlvasas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("felhasznalo/felh_letre")
    public ResponseEntity<?> FelhasznaloLetrehoz(@RequestBody Felhasznalo felhasznalo) {
        gymService.FelhasznaloLetrehoz(felhasznalo);
        return new ResponseEntity<>("Az új felhasználó létrejött!",HttpStatus.CREATED);
    }

    @DeleteMapping("felhasznalo/felh_torles/{felhasznaloID}")
    public ResponseEntity<?> FelhasznaloTorles(@PathVariable("felhasznaloID")Long felhasznaloID){
        gymService.FelhasznaloTorles(felhasznaloID);
        return new ResponseEntity<>("A felhasználó törlésre került!", HttpStatus.OK);
    }

    @PutMapping("felhasznalo/felh_modosit")
    public ResponseEntity<?> FelhasznaloModosit(@RequestBody Felhasznalo felhasznalo){
        try {
            gymService.FelhasznaloModosit(felhasznalo);
            return new ResponseEntity<>("A felhasználó módosításra került!",HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("tartozkodasihely/{tartozkodasihelyID}")
    @Transactional
    public ResponseEntity<?> TartozkodasihelyOlvasas(@PathVariable("tartozkodasihelyID")Long tartozkodasihelyID){
        try {
            String tartozkodasihely = gymService.TartozkodasihelyOlvasas(tartozkodasihelyID);
            return new ResponseEntity<>(tartozkodasihely, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("tartozkodasihely/tart_letre")
    public ResponseEntity<?> TartozkodasihelyLetrehoz(@RequestBody Tartozkodasihely tartozkodasihely){
        gymService.TartozkodasihelyLetrehoz(tartozkodasihely);
        return new ResponseEntity<>("Az új tartózkodási hely létrejött!",HttpStatus.OK);
    }

    @DeleteMapping("tartozkodasihely/tart_torles/{tartozkodasihelyID}")
    public ResponseEntity<?> TartozkodasihelyTorles(@PathVariable("tartozkodasihelyID") Long tartozkodasihelyID){
        gymService.TartozkodasihelyTorles(tartozkodasihelyID);
        return new ResponseEntity<>("A tartózkodási hely törlésre került!", HttpStatus.OK);
    }

    @PutMapping("tartozkodasihely/tart_modosit")
    public ResponseEntity<?> TartozkodasihelyModosit(@RequestBody Tartozkodasihely tartozkodasihely){
        try{
            gymService.TartozkodasihelyModosit(tartozkodasihely);
            return new ResponseEntity<>("A tartózkodási helymódosításra került!",HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
