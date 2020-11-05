package com.ipiecoles.java.java220;

import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalDate;

import java.util.Date;
import java.util.Objects;

/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public Employe(String nom ,String prenom,String matricule,LocalDate dateEmbauche, Double salaire){
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;
    }

    public Employe(){
        this.nom = "Nom";
        this.prenom = "Prenom";
        this.matricule = "Matricule";
        this.dateEmbauche = LocalDate.now();
        this.salaire = 0d;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

//    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
//        if(dateEmbauche.isAfter(LocalDate.now())){
//            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
//        }
//        else
//            this.dateEmbauche = dateEmbauche;
//    }

    //Correction                                        //Lorsque l'on appel la fonction setDateEmbauche cela peut générer une exception
    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception{
        if(dateEmbauche != null && dateEmbauche.isAfter(LocalDate.now())){
            //Erreur
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        else
            this.dateEmbauche = dateEmbauche;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public final Integer getNombreAnneeAnciennete(){
        Integer anciennete = 0;
        //Si l'année d'embauche et la même que l'année actuel
        if(this.dateEmbauche.year() == LocalDate.now().year()){
            anciennete = 0;
        }
        if(this.dateEmbauche.year().get() < LocalDate.now().year().get()){
            anciennete = LocalDate.now().year().get()-this.dateEmbauche.getYear();
        }
        return anciennete;
    }

    //Correction
//    public final Integer getNombreAnneeAnciennete(){
//        return LocalDate.now().getYear() - this.dateEmbauche.getYear();
//    }

    public Integer getNbConges(){
        //Appelle de l'atribut NB_CONGES_BASE de la class Entreprise qui est en public static donc pas besoin d'instancié
        return Entreprise.NB_CONGES_BASE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employe employe = (Employe) o;
        return Objects.equals(nom, employe.nom) &&
                Objects.equals(prenom, employe.prenom) &&
                Objects.equals(matricule, employe.matricule) &&
                Objects.equals(dateEmbauche, employe.dateEmbauche) &&
                Objects.equals(salaire, employe.salaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }

    //Redéfinition (override en C#)
    @Override
    public String toString(){
        //return super.toString();
        return "Employe{nom='"+this.nom+"', prenom='"+this.prenom+"', matricule='"+this.matricule+"', dateEmbauche="+this.dateEmbauche+", salaire="+this.salaire+"}";
    }

//    public Boolean equals(Employe employeToCompare){
//        Boolean res = false;
//
//        if(this.nom.equals(employeToCompare.getNom())
//                & this.prenom.equals(employeToCompare.getPrenom())
//                & this.dateEmbauche.equals(employeToCompare.getDateEmbauche())
//                & this.salaire.equals(employeToCompare.getSalaire())){
//            if(this.matricule == null & employeToCompare.getMatricule() == null){
//                res = true;
//            }else{
//                if(this.matricule == null & employeToCompare.getMatricule() != null | this.matricule != null & employeToCompare.getMatricule() == null )
//                    res = false;
//            }
//        }
//        return res;
//    }

    //Puisque nous faisont un override la signature doit être la même
//    public boolean equals(Object o){
//        if(this == o ) return true;
//        if(o == null) return false;
//        if(this.getClass() != o.getClass()) return false;
//        Employe e = (Employe)o; //Cast de l'objet o sous forme d'employ
//                                                                                                                //Il faut convertir en string les deux valeurs pour pouvoir faire un .equals et ne pas utilisé le == qui lui vas faire une comparaison des référence mémoire qui seront donc différente car on aura fait des new ...
//        return (this.nom == e.getNom() && this.prenom == e.getPrenom() && this.matricule == e.getMatricule() && this.dateEmbauche.toString().equals(e.getDateEmbauche().toString()) && this.salaire.toString().equals(e.getSalaire().toString()) );
//    }

    //Redifinition de la méthode hashCode
//    public int hashCode(){
//        return Objects.hash(this.nom,this.prenom,this.matricule,this.dateEmbauche,this.salaire);
//    }

    public void augmenterSalaire(Double pourcentage){
        this.salaire += this.salaire*pourcentage;
    }

    public abstract Double getPrimeAnnuelle();
}
