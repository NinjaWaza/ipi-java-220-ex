package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;



public class Commercial extends Employe{
    private Double caAnnuel = 0d;
    private Integer performance;

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel, Integer performance) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
        this.performance = performance;
    }
    public Commercial(){

    }

    public Boolean performanceEgale(Integer etat){
        return this.performance.equals(etat);
    }

    public Double getCaAnnuel() {
        return this.caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    @Override
    public Double getPrimeAnnuelle() {
//        Double res = 500d;
//        if(this.caAnnuel*5/100 > 500){
//            res = this.caAnnuel*5/100;
//        }
//        return Math.ceil(res);
        //Renvoie le maximum entre 5% du ca annuel et 500
//        if(this.getCaAnnuel() != null){
//            return Math.max(Math.ceil(this.getCaAnnuel() * 0.05),500);
//        }
//        return 500d;
        return this.getCaAnnuel() == null ? 500d : Math.max(Math.ceil(this.getCaAnnuel()*0.05), 500);
    }

    public Note equivalenceNote(){
        switch (this.performance){
            case(0):
            case (50):
                return Note.INSUFFISANT;
            case (100):
                return Note.INSUFFISANT;
            case(150):
                return Note.PASSABLE;
            case(200):
                return Note.TRES_BIEN;
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object o) {
        Commercial commercial = (Commercial) o;
        return super.equals(o) && Objects.equals(this.caAnnuel, commercial.getCaAnnuel());
    }
}