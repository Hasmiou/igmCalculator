package com.sdz.hasmiou.igmcalculator.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProfilTest {

    private Profil profil = new Profil(67, 165,35, 0);
    private float img = (float) 32.2;
    private String msg = "Trop élevé";

    @Test
    public void getImg() {
        assertEquals(this.img,this.profil.getImg(), (float)0.1);
    }

    @Test
    public void getMessage() {
        assertEquals(this.msg,this.profil.getMessage());
    }
}