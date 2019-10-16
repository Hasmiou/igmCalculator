package com.sdz.hasmiou.igmcalculator.models;

import java.io.Serializable;

public class Profil implements Serializable {

    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sex;
    private float img;
    private String message;

    private static final Integer minFemme = 15;
    private static final Integer maxFemme = 30;
    private static final Integer minHomme = 10;
    private static final Integer maxHomme = 25;

    /**
     * Le constructeur, qui assigne automatiquement le valeurs de chaque attribut
     * puis appele les fonction de calcule de l'img et de la génération du message associé
     *
     * @param poids
     * @param taille
     * @param age
     * @param sex
     */
    public Profil(Integer poids, Integer taille, Integer age, Integer sex) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sex = sex;
        this.calculImg();
        this.generateMessage();
    }

    /**
     * Calcule l'img et affecte la valeur à l'attribut de la classe
     */
    private void calculImg(){
        float tailleMetre = (float) taille/100;
        this.img = (float)((1.2*this.poids/(tailleMetre*tailleMetre))+(0.23*this.age)-(10.85*this.sex) - 5.4);
    }

    /**
     * Génere le message associé à l'img puis assigne la valeur à l'attribut de la classe.
     */
    private void generateMessage(){
        Integer min;
        Integer max;
        if(this.sex==0){
            min = this.minFemme;
            max = this.maxFemme;
        }else{
            min = this.minHomme;
            max = this.maxHomme;
        }

        this.message="Normal";
        if(this.img < min){
            this.message="Trop faible";
        }else{
            if(this.img>max){
                this.message="Trop élevé";
            }
        }

    }

    /**
     * Getter de l'img
     * @return
     */
    public float getImg() {
        return img;
    }

    /**
     * Getter du poids
     * @return
     */
    public Integer getPoids() {
        return poids;
    }

    /**
     * Getter de la taile
     * @return
     */
    public Integer getTaille() {
        return taille;
    }

    /**
     * Getter de l'age
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Getter du genre
     * @return
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * Getter du message
     * @return
     */
    public String getMessage() {
        return message;
    }
}
