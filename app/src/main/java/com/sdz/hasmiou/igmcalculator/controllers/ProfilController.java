package com.sdz.hasmiou.igmcalculator.controllers;

import android.content.Context;

import com.sdz.hasmiou.igmcalculator.Services.Serializer;
import com.sdz.hasmiou.igmcalculator.models.Profil;

public final class ProfilController {

    private static ProfilController instance = null;
    private static Profil profil;
    private static String fileName ="saveProfil";

    /**
     * Constructeur vide qui herite de la classe mère super()
     */
    private ProfilController(){
        super();
    }

    /**
     * Création de l'instance du profil et chargement des données enregistrées
     * @return
     */
    public static ProfilController getInstance(Context ctx) {
        if(ProfilController.instance == null){
            instance = new ProfilController();
            loadSerializeData(ctx);
        }
        return ProfilController.instance;
    }

    /**
     *
     * @param poids
     * @param taille
     * @param age
     * @param sex
     */
    public void createProfil(Integer poids, Integer taille, Integer age, Integer sex, Context ctx){
        this.profil = new Profil(poids, taille, age, sex);
        Serializer.serialize(fileName, profil, ctx);
    }

    /**
     * Retourne l'IMG Calculé et enregisté
     * @return
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * Retourne le message associé à l'IMG calculé et enregisté
     * @return
     */
    public String getMessage(){
        return profil.getMessage();
    }

    /**
     * Retourne le poids du profil enregistré
     * @return
     */
    public Integer getPoids(){
        return profil!=null?profil.getPoids():null;
    }

    /**
     * Retourne la taille du profil enregistré
     * @return
     */
    public Integer getTaille(){
        return profil!=null?profil.getTaille():null;
    }

    /**
     * Retourne l'age du profil enregistré
     * @return
     */
    public Integer getAge(){
        return profil!=null?profil.getAge():null;
    }

    /**
     * Retourne le sexe du profil enregistré
     * @return
     */
    public Integer getSex(){
        return profil!=null?profil.getSex():null;
    }

    /**
     * Elle charge les données sérialisées
     * @param ctx
     */
    private static void loadSerializeData(Context ctx){
        profil = (Profil) Serializer.unSerialize(fileName, ctx);
    }
}
