package com.sdz.hasmiou.igmcalculator.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfilTest {

    /**
     * Exemple de profil créé pour le test
     */
    private Profil profil = new Profil(67, 165,35, 0);
    private float img = (float) 32.2;
    private String msg = "Trop élevé";

    @Test
    /**
     * Methode de test du calcul de l'img
     */
    public void getImg() {
        assertEquals(this.img,this.profil.getImg(), (float)0.1);
    }

    @Test
    /**
     * Methode de test du message de retour après calcul de l'img
     */
    public void getMessage() {
        assertEquals(this.msg,this.profil.getMessage());
    }
}