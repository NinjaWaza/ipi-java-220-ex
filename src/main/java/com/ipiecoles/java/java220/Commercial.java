package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Commercial extends Employe{
    private Double caAnnuel;

    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double caAnnuel) {
        super(nom, prenom, matricule, dateEmbauche, salaire);
        this.caAnnuel = caAnnuel;
    }

    public Double getCaAnnuel() {
        return this.caAnnuel;
    }

    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    @Override
    public Double getPrimeAnnuelle() {
        Double res = 500d;
        if(this.caAnnuel*5/100 > 500){
            res = this.caAnnuel*5/100;
        }
        return Math.ceil(res);
    }

    @Override
    public boolean equals(Object o) {
        Commercial commercial = (Commercial) o;
        return super.equals(o) && Objects.equals(this.caAnnuel, commercial.getCaAnnuel());
    }
}