package com.project.gym.service;

import com.project.gym.model.Tartozkodasihely;
import com.project.gym.repository.TartozkodasihelyRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TartozkodasihelyService {


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

}