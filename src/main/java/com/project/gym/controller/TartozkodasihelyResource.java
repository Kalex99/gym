package com.project.gym.controller;

import com.project.gym.model.Tartozkodasihely;
import com.project.gym.service.TartozkodasihelyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class TartozkodasihelyResource {

    @Autowired
    private TartozkodasihelyService tartozkodasihelyService;

    @GetMapping("tartozkodasihely/{tartozkodasihelyID}")
    @Transactional
    public ResponseEntity<?> TartozkodasihelyOlvasas(@PathVariable("tartozkodasihelyID")Long tartozkodasihelyID){
        String tartozkodasihely = tartozkodasihelyService.TartozkodasihelyOlvasas(tartozkodasihelyID);
        return new ResponseEntity<>(tartozkodasihely, HttpStatus.OK);
    }

    @PostMapping("tartozkodasihely/tart_letre")
    public ResponseEntity<?> TartozkodasihelyLetrehoz(@RequestBody Tartozkodasihely tartozkodasihely){
        tartozkodasihelyService.TartozkodasihelyLetrehoz(tartozkodasihely);
        return new ResponseEntity<>("Az új tartózkodási hely létrejött!",HttpStatus.OK);
    }

    @DeleteMapping("tartozkodasihely/tart_torles/{tartozkodasihelyID}")
    public ResponseEntity<?> TartozkodasihelyTorles(@PathVariable("tartozkodasihelyID") Long tartozkodasihelyID){
        tartozkodasihelyService.TartozkodasihelyTorles(tartozkodasihelyID);
        return new ResponseEntity<>("A tartózkodási hely törlésre került!", HttpStatus.OK);
    }

    @PutMapping("tartozkodasihely/tart_modosit")
    public ResponseEntity<?> TartozkodasihelyModosit(@RequestBody Tartozkodasihely tartozkodasihely){
        tartozkodasihelyService.TartozkodasihelyModosit(tartozkodasihely);
        return new ResponseEntity<>("A tartózkodási helymódosításra került!",HttpStatus.OK);
    }
}
