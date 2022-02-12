package com.project.gym.controller;

import com.project.gym.model.Felhasznalo;
import com.project.gym.service.FelhasznaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FelhasznaloResource {

    @Autowired
    private FelhasznaloService felhasznaloService;



    @GetMapping("felhasznalo/felh_olvas")
    public ResponseEntity<List<Felhasznalo>> FelhasznaloOlvasas() {
        List<Felhasznalo> lista = felhasznaloService.FelhasznaloOlvasas();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping("felhasznalo/felh_letre")
    public ResponseEntity<?> FelhasznaloLetrehoz(@RequestBody Felhasznalo felhasznalo) {
        felhasznaloService.FelhasznaloLetrehoz(felhasznalo);
        return new ResponseEntity<>("Az új felhasználó létrejött!",HttpStatus.CREATED);
    }

    @DeleteMapping("felhasznalo/felh_torles/{felhasznaloID}")
    public ResponseEntity<?> FelhasznaloTorles(@PathVariable("felhasznaloID")Long felhasznaloID){
        felhasznaloService.FelhasznaloTorles(felhasznaloID);
        return new ResponseEntity<>("A felhasználó törlésre került!", HttpStatus.OK);
    }

    @PutMapping("felhasznalo/felh_modosit")
    public ResponseEntity<?> FelhasznaloModosit(@RequestBody Felhasznalo felhasznalo){
        felhasznaloService.FelhasznaloModosit(felhasznalo);
        return new ResponseEntity<>("A felhasználó módosításra került!",HttpStatus.OK);
    }









//    @RequestMapping(value="/employees", method=RequestMethod.GET)
//    public List<Felhasznalo> readEmployees() {
//        return felhasznaloService.getFelhasznalo();
//    }


//    private final FelhasznaloService felhasznaloService;
//
//    public FelhasznaloResource(FelhasznaloService felhasznaloService) {
//        this.felhasznaloService = felhasznaloService;
//    }


}