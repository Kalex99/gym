package com.project.gym.service;

import com.project.gym.model.Felhasznalo;
import com.project.gym.model.Tartozkodasihely;
import com.project.gym.repository.FelhasznaloRep;
import com.project.gym.repository.TartozkodasihelyRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymService {

    @Autowired
    private FelhasznaloRep felhasznaloRep;

    public List<Felhasznalo> FelhasznaloOlvasas(){
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
    @Autowired
    private TartozkodasihelyRep tartozkodasihelyRep;

    public String TartozkodasihelyOlvasas(Long tartozkodasihelyID) {
        return tartozkodasihelyRep.TartozkodasihelyOlvasas(tartozkodasihelyID);
    }

    public void TartozkodasihelyLetrehoz(Tartozkodasihely tartozkodasihely){
        tartozkodasihelyRep.TartozkodasihelyLetrehoz(tartozkodasihely.getIranyitoszam(),tartozkodasihely.getVaros(),tartozkodasihely.getKozterulet_neve(),tartozkodasihely.getKozterulet_jellege(), tartozkodasihely.getHaz_szam());
    }
    public void TartozkodasihelyTorles(Long tartozkodasihelyID){
        tartozkodasihelyRep.TartozkodasihelyTorles(tartozkodasihelyID);
    }

    public void TartozkodasihelyModosit(Tartozkodasihely tartozkodasihely){
        tartozkodasihelyRep.TartozkodasihelyModosit(tartozkodasihely.getTartozkodasihelyID(), tartozkodasihely.getIranyitoszam(),tartozkodasihely.getVaros(),tartozkodasihely.getKozterulet_neve(),tartozkodasihely.getKozterulet_jellege(), tartozkodasihely.getHaz_szam());
    }


    //    @Autowired
//    public FelhasznaloService(FelhasznaloRep felhasznaloRepo) {
//        this.felhasznaloRepo = felhasznaloRepo;
//    }
//
//    public Felhasznalo findFelhasznaloById(Long id){
//        return felhasznaloRepo.findFelhasznaloByID(id).orElseThrow(()->new FelhasznaloNemTalalhatoException("User by id "+ id +" was not found"));
//    }
//
//    public Felhasznalo findFelhasznaloById(Long id){
//        return felhasznaloRepo.findFelhasznaloByID(id).orElseThrow(()->new FelhasznaloNemTalalhatoException("User by id "+ id +" was not found"));
//    }
}
