package com.sdz.hasmiou.igmcalculator.controllers;

import com.sdz.hasmiou.igmcalculator.models.Profil;

public final class ProfilController {

    private static ProfilController instance = null;
    private Profil profil;

    private ProfilController(){
        super();
    }

    /**
     *
     * @return
     */
    public static ProfilController getInstance() {
        return ProfilController.instance == null? instance = new ProfilController():ProfilController.instance;
    }

    /**
     *
     * @param poids
     * @param taille
     * @param age
     * @param sex
     */
    public void createProfil(Integer poids, Integer taille, Integer age, Integer sex){
        this.profil = new Profil(poids, taille, age, sex);
    }

    public float getImg(){
        return profil.getImg();
    }

    public String getMessage(){
        return profil.getMessage();
    }

}
