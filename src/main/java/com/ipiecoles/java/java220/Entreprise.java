package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Entreprise {

    //le final permet de dire que la variable est une constante

    public static final Double SALAIRE_BASE = 1480.27;
    public static final Integer NB_CONGES_BASE = 25;
    public static final Double INDICE_MANAGER = 1.3;
    public static final Double PRIME_MANAGER_PAR_TECHNICIEN = 250.0;
    public static final Double PRIME_ANCIENNETE = 100d;

    public static Double primeAnnuelleBase(){
        //le d après le 2 permet de spécifié que c'est un double
        return LocalDate.now().getYear() / 2d;//*0.5 ou / 2.0
    }

//    //Nécessaire de mettre static comme ça pas nécéssaire d'instancié une entreprise pour pouvoir appelé getNbConges()
//    public static Integer getNbConges(){
//        return NB_CONGES_BASE;
//    }
}
