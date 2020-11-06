package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.*;
import java.util.stream.Collectors;

public class Manager extends Employe {
    //Attributs
    private HashSet<Technicien> equipe = new HashSet<>();

    //Constructeur
    public Manager(){
        this.equipe = new HashSet<Technicien>();
    }
    public Manager(String nom , String prenom, String matricule, LocalDate dateEmbauche, Double salaire){
        super(nom , prenom, matricule, dateEmbauche,  salaire);
        //this.equipe = new HashSet<>();
        this.equipe = new HashSet<Technicien>();
    }

    //Méthodes
    public void ajoutTechnicienEquipe(Technicien unTechnicien){
        this.equipe.add(unTechnicien);
    }

    public void ajoutTechnicienEquipe(String nom,String prenom,String matricule, LocalDate dateEmbauche, Double salaire, Integer grade){
        Technicien leNouveauTechnicien = new Technicien(nom,prenom,matricule,dateEmbauche,salaire,grade);
        this.equipe.add(leNouveauTechnicien);
    }

    private void augmenterSalaireEquipe(Double pourcentage){
//        //Foreach technicien dans l'équipe
//        for(Technicien unTech : this.equipe){
//            unTech.augmenterSalaire(pourcentage);
//        }
        //Correction
        for (Technicien technicien : equipe) {
            technicien.augmenterSalaire(pourcentage);
        }
    }

    public List<Technicien> equipeParGrade(){
        List<Technicien> laList = new ArrayList<>();
        for (Technicien unTech : this.equipe){
            laList.add(unTech);
        }
        laList.stream().sorted(Comparator.comparing(Technicien::getNom));
        return laList;
    }


    @Override
    public void augmenterSalaire(Double pourcentage) {
        super.augmenterSalaire(pourcentage);
        this.augmenterSalaireEquipe(pourcentage);
    }

    //Getter/Setter
    public HashSet<Technicien> getEquipe() {
        return this.equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    //Override
    @Override
    public void setSalaire(Double salaire) {
        //10% du salaire passé en paramètre
        Double salaireFinal = salaire * Entreprise.INDICE_MANAGER;
        Double temp = 0d;
//        if(!this.equipe.isEmpty()){
//            //Foreach technicien dans l'équipe
//            for (Technicien unTech : this.equipe){
//                temp += salaire*0.1;
//            }
//        }
        temp = (salaire*0.1) *this.equipe.size();
        salaireFinal += temp;

        super.setSalaire(salaireFinal);

        //super.setSalaire(salaire * Entreprise.INDICE_MANAGER + (salaire * (double)equipe.size() / 10));
    }

    @Override
    public Double getPrimeAnnuelle() {
//        Double primeDeBase = Entreprise.primeAnnuelleBase();
//        Double primeManager = this.equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
//        Double resultat = primeDeBase + primeManager;
//        return Entreprise.primeAnnuelleBase() + this.equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
        return (Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN);
    }
}
