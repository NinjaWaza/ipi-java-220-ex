package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;

public class Technicien extends Employe implements Comparable<Technicien>{
    //Attributs
    private Integer grade;

    //Constructor
    public Technicien(){

    }

    public Technicien(String nom , String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
        super(nom ,prenom, matricule,dateEmbauche,salaire);
        this.grade = grade;
    }

    //Getter/Setter
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    //Override

    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire* (1+ this.grade *0.1));
    }

    @Override
    public Integer getNbConges() {
        return super.getNbConges()+this.getNombreAnneeAnciennete();
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() * (1+ this.grade * 0.1) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }

    //Correction
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), this.grade);
    }

    @Override
    public String toString() {
        return "Tehcnicien{" + "grade="  + this.grade + "}" +super.toString();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int compareTo(Technicien o) {
        return Integer.compare(this.getGrade(),o.getGrade());
    }
}
