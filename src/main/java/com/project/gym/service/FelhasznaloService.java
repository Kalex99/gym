package com.project.gym.service;

import com.project.gym.exception.FelhasznaloNemTalalhatoException;
import com.project.gym.model.Felhasznalo;
import com.project.gym.repository.FelhasznaloRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class FelhasznaloService {



    @Autowired
    private FelhasznaloRep felhasznaloRep;

    public  List<Felhasznalo> FelhasznaloOlvasas(){
        return felhasznaloRep.FelhasznaloOlvasas();
    }

    public void  FelhasznaloLetrehoz(Felhasznalo felhasznalo){
        felhasznaloRep.FelhasznaloLetrehoz(felhasznalo.getFelhasznalonev(),felhasznalo.getJelszo(),felhasznalo.getFelh_vezeteknev(),felhasznalo.getFelh_keresztnev(),felhasznalo.getFelh_email(),felhasznalo.getSzuletesi_datum(),felhasznalo.getFelh_telefon(),felhasznalo.getTartozkodasihelyID());
    }

    public void FelhasznaloTorles(Long felhasznaloID){
        felhasznaloRep.FelhasznaloTorles(felhasznaloID);
    }

    public void FelhasznaloModosit(Felhasznalo felhasznalo){
        felhasznaloRep.FelhasznaloModosit(felhasznalo.getFelhasznaloID(), felhasznalo.getFelhasznalonev(),felhasznalo.getJelszo(),felhasznalo.getFelh_vezeteknev(),felhasznalo.getFelh_keresztnev(),felhasznalo.getFelh_email(),felhasznalo.getFelh_telefon(),felhasznalo.getTartozkodasihelyID() );
    }

//    public Felhasznalo updateFelhasznalo(Felhasznalo felhasznalo){
//        return felhasznaloRepo.save(felhasznalo);
//    }






















//    public  List<Felhasznalo> getFelhasznalo(){
//        return felhasznaloRep.findAll();
//    }
//    private final FelhasznaloRep felhasznaloRepo;
//
//    @Autowired
//    public FelhasznaloService(FelhasznaloRep felhasznaloRepo) {
//        this.felhasznaloRepo = felhasznaloRepo;
//    }
//
//
//    public Felhasznalo addFelhasznalo(Felhasznalo felhasznalo){
//       felhasznalo.setFelh_telefon(UUID.randomUUID().toString());
//       return felhasznaloRepo.save(felhasznalo);
//    }
//
//    public List<Felhasznalo> findAllFelhasznalo(){
//        return felhasznaloRep.findAll();
//    }
//

//
//    public Felhasznalo findFelhasznaloById(Long id){
//        return felhasznaloRepo.findFelhasznaloByID(id).orElseThrow(()->new FelhasznaloNemTalalhatoException("User by id "+ id +" was not found"));
//    }
//

//    public void deleteFelhasznalo(Long id){
//        felhasznaloRepo.deleteFelhasznaloByID(id);
//    }
}
