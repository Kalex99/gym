package com.project.gym.controller;

import com.project.gym.model.Felhasznalo;
import com.project.gym.service.FelhasznaloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class FelhasznaloResource {

    @Autowired
    private FelhasznaloService felhasznaloService;

    @GetMapping("lista")
    public ResponseEntity<List<Felhasznalo>> FelhasznaloOlvasas() {
        List<Felhasznalo> lista = felhasznaloService.FelhasznaloOlvasas();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @PostMapping("felh_letre")
    public ResponseEntity<?> FelhasznaloLetrehoz(@RequestBody Felhasznalo felhasznalo) {
        felhasznaloService.FelhasznaloLetrehoz(felhasznalo);
        return new ResponseEntity<>("Jó vótá'!",HttpStatus.CREATED);
    }

    @DeleteMapping("felh_torles/{felhasznaloID}")
    public ResponseEntity<?> FelhasznaloTorles(@PathVariable("felhasznaloID")Long felhasznaloID){
        felhasznaloService.FelhasznaloTorles(felhasznaloID);
        return new ResponseEntity<>("Jó vótá'!", HttpStatus.OK);
    }

    @PutMapping("felh_modosit")
    public ResponseEntity<?> FelhasznaloModosit(@RequestBody Felhasznalo felhasznalo){
        felhasznaloService.FelhasznaloModosit(felhasznalo);
        return new ResponseEntity<>("Jó vótá'!",HttpStatus.OK);
    }






//    @PutMapping("/update")
//    public ResponseEntity<Felhasznalo> updateFelhasznalo(@RequestBody Felhasznalo felhasznalo){
//        Felhasznalo updateFelhasznalo= felhasznaloService.updateFelhasznalo(felhasznalo);
//        return new ResponseEntity<>(updateFelhasznalo, HttpStatus.OK);
//    }





//    @PostMapping("/add")
//    public ResponseEntity<Felhasznalo> addFelhasznalo(@RequestBody Felhasznalo felhasznalo){
//        Felhasznalo newfelhasznalo= felhasznaloService.addFelhasznalo(felhasznalo);
//        return new ResponseEntity<>(newfelhasznalo, HttpStatus.CREATED);
//   }
/*    @DeleteMapping("/felh/{felhasznaloID}")
    public void FelhasznaloTorles(@PathVariable("felhasznaloID") Long felhasznaloID){
        felhasznaloService.FelhasznaloTorles(felhasznaloID);
    }*/
//    @RequestMapping(value="/employees", method=RequestMethod.GET)
//    public List<Felhasznalo> readEmployees() {
//        return felhasznaloService.getFelhasznalo();
//    }


//    private final FelhasznaloService felhasznaloService;
//
//    public FelhasznaloResource(FelhasznaloService felhasznaloService) {
//        this.felhasznaloService = felhasznaloService;
//    }

//
//    @GetMapping("/all")
//    public ResponseEntity<List<Felhasznalo>> getAllFelhasznalo(){
//        List<Felhasznalo> felhasznalok = felhasznaloService.findAllFelhasznalo();
//        return new ResponseEntity<>(felhasznalok, HttpStatus.OK);
//    }
//
//    @GetMapping("/find/{id}")
//    public ResponseEntity<Felhasznalo> getFelhasznaloByID(@PathVariable("id") Long id){
//        Felhasznalo felhasznalo = felhasznaloService.findFelhasznaloById(id);
//        return new ResponseEntity<>(felhasznalo, HttpStatus.OK);
//    }
//    @PostMapping("/add")
//    public ResponseEntity<Felhasznalo> addFelhasznalo(@RequestBody Felhasznalo felhasznalo){
//        Felhasznalo newfelhasznalo= felhasznaloService.addFelhasznalo(felhasznalo);
//        return new ResponseEntity<>(newfelhasznalo, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<Felhasznalo> updateFelhasznalo(@RequestBody Felhasznalo felhasznalo){
//        Felhasznalo updateFelhasznalo= felhasznaloService.updateFelhasznalo(felhasznalo);
//        return new ResponseEntity<>(updateFelhasznalo, HttpStatus.OK);
//    }
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteFelhasznalo(@PathVariable("id") Long id){
//        felhasznaloService.deleteFelhasznalo(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}