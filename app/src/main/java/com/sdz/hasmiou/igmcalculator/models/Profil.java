package com.sdz.hasmiou.igmcalculator.models;

public class Profil {
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


    public Profil(Integer poids, Integer taille, Integer age, Integer sex) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sex = sex;
        this.calculImg();
        this.generateMessage();
    }

    /**
     *
     */
    private void calculImg(){
        float tailleMetre = (float) taille/100;
        this.img = (float)((1.2*this.poids/(tailleMetre*tailleMetre))+(0.23*this.age)-(10.85*this.sex) - 5.4);
    }

    /**
     *
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

    public float getImg() {
        return img;
    }

    public Integer getPoids() {
        return poids;
    }

    public Integer getTaille() {
        return taille;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getSex() {
        return sex;
    }

    public String getMessage() {
        return message;
    }
}
