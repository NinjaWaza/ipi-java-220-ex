package com.ipiecoles.java.java220;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.HashSet;
import java.util.List;

public class Main{
    public static void main(String[] args){
//        String chaineNonInitialisee = null;
//
//
//        String chaine = "Hello world !";
//        System.out.println(chaine.hashCode());
//        chaine = null;
//        chaine = "Hello world !";
//        System.out.println(chaine.hashCode());
//        chaine = null;
//        chaine = new String("Hello world !");
//        System.out.println(chaine.hashCode());
//        if (chaine == "Hello world !"){
//            //Compare les références
//            System.out.println(chaine);
//        }
//        if (chaine.equals("Hello world !")){
//            //Compare les valeurs
            //Donc le new String vas pas posé problème car en finalité c'est Hello World !
//            System.out.println(chaine);
//        }
        //System.out.println("Hello world !");
        Entreprise uneEntreprise = new Entreprise();
        //Double test = uneEntreprise.primeAnnuelleBase();
        //System.out.println(test);
        LocalDate dateTime = new LocalDate(0L);
        //Commercial commercial1 = new Commercial("nom","prenom", "matricule",dateTime,1500d,15005d);
        //Commercial commercial2 = new Commercial("nom","prenom", "matricule",dateTime,1500d,500d);
        //System.out.println(commercial1.getPrimeAnnuelle());

        Technicien unTech = new Technicien();
        unTech.setGrade(1);
        unTech.setSalaire(1000d);

        Manager unManager = new Manager();
        Technicien techUn = new Technicien("techUn" ,  "prenomTechUn",  "matricule",  LocalDate.now(),  1500d,1);
        Technicien techDeux = new Technicien("techDeux" ,  "prenomTechDeux",  "matricule",  LocalDate.now(),  1500d,2);
        Technicien techTrois = new Technicien("techTrois" ,  "prenomTechTrois",  "matricule",  LocalDate.now(),  1500d,3);

        unManager.ajoutTechnicienEquipe(techUn);
        unManager.ajoutTechnicienEquipe(techDeux);
        unManager.ajoutTechnicienEquipe(techTrois);

        for (Technicien unTechDansLaList : unManager.equipeParGrade()){
            System.out.println(unTechDansLaList.toString());
        }

    }
}