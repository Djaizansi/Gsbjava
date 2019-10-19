import java.util.*;
import java.util.regex.Pattern;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class ManipVisiteur {
    static public void lister()  throws Exception {
 	int  i;
	String unMat, unStatut, unNom, unPrenom, uneAdresse, uneDateE,uneAnneeE; 
	Visiteur unVisiteur;
	ArrayList<Visiteur> lesVisiteur;
	String ligneAffiche;

	i=0;
	lesVisiteur = PasserelleBdd.lireVis("");
        System.out.println(lesVisiteur);
	System.out.println();
	ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-17s|%-34s|%-13s|%-4s|","Matricule", "Statut", "Nom", "Prenom", "Adresse", "Date Embauche", "Annee Embauche");
	System.out.println(ligneAffiche);

	ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-17s|%-34s|%-13s|%-4s|","----------", "----------", "----------" ,"-----------------", "----------------------------------", "-------------","----");
	System.out.println(ligneAffiche);

	while (i<lesVisiteur.size()) {
            unVisiteur = lesVisiteur.get(i);

            unMat = unVisiteur.get_mat();
            unStatut = unVisiteur.get_statut();
            unNom = unVisiteur.get_nom();
            unPrenom = unVisiteur.get_prenom();
            uneAdresse = unVisiteur.get_adr();
            uneDateE = unVisiteur.get_date();
            uneAnneeE = unVisiteur.get_annee();

            ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-17s|%-34s|%-13s|%-4s|",unMat, unStatut, unNom, unPrenom, uneAdresse, uneDateE, uneAnneeE);
            System.out.println(ligneAffiche);

            i=i+1;
	} //Fin while
	if (i==0) {
            System.out.println("Aucun Visiteur");
	} //Fin if
    } // Fin lister
    
    static public void ajouter() throws Exception {
	int nb;
	String unMat, unStatut, unNom, unPrenom, uneAdresse, uneDateE, uneAnneeE, unStatutD, unStatutM;
	Visiteur unVisiteur;
	ArrayList<Visiteur> lesVisiteurs;
        Boolean c;
	// Saisie des informations
                unStatutD = "D";
                unStatutM = "M";
                System.out.println("Saisir un Matricule :");
		unMat = Cons.saisirChaine();
                
                System.out.println("Saisir Statut :");
		unStatut = Cons.saisirChaine();
                while(unStatut.compareTo(unStatutD)!=0 && unStatut.compareTo(unStatutM) != 0){
                   System.out.println("Resaisir le statut :"); 
                   unStatut = Cons.saisirChaine();
                }
		System.out.println("Saisir nom :");
		unNom = Cons.saisirChaine();
		System.out.println("Saisir prenom :");
		unPrenom = Cons.saisirChaine();
                System.out.println("Saisir une adresse :");
		uneAdresse = Cons.saisirChaine();
		System.out.println("Saisir date d'embauche :");
                System.out.println("(aaaa-mm-jj)");
		uneDateE = Cons.saisirChaine();
                System.out.println("Saisir l'annee d'embauche :");
		uneAnneeE = Cons.saisirChaine();
                
                c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDateE);
                while (c == false)
                {
                    System.out.println("La date n'est pas au bon format,");
                    System.out.println("il faut respecter le format aaaa-mm-jj");
                    uneDateE = Cons.saisirChaine();
                    c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDateE);
                }
		
		unVisiteur = new Visiteur(unMat, unStatut,"", unNom, unPrenom, uneAdresse, uneDateE, uneAnneeE);
		nb = PasserelleBdd.modifVis('A',unVisiteur);
		if (nb==1)
		{
		    System.out.println("Ajout bien effectué ");
		}
		else
		{
		    System.out.println("Echec de l'ajout ! ");
		}
 } // fin ajouter
    
    static public void rechercher() throws Exception {
	String leMat;
	ArrayList<Visiteur> lesVisiteur;

	System.out.print("\nMatricule de visiteur recherché : ");
	leMat = Cons.saisirChaine();
	
	lesVisiteur = PasserelleBdd.lireVis(leMat);
	
	// S'il y a un résultat
	if (lesVisiteur.size()>0)
	{
	    System.out.println("Le visiteur recherché est : ");
	    lesVisiteur.get(0).afficher();
	}	
	// Sinon, le Visiteur n'a pas été trouvé
	else
	{
		System.out.println("Visiteur inconnu !");
	}

 } // Fin de rechercher
    
    static public void modifier() throws Exception {
	boolean trouve = false;
	String unMat, uneStatut, unNom, unPrenom, uneAdresse, uneDateE;
        int nb;
	Visiteur unVisiteur;
	ArrayList<Visiteur> lesVisiteurs;

	System.out.print("\nMatricule du visiteur à modifier : ");
	unMat = Cons.saisirChaine();

    // Rechercher et afficher le visiteur correspondant
    // pour demander confirmation
	lesVisiteurs = PasserelleBdd.lireVis(unMat);
	
	// S'il y a un résultat
	if (lesVisiteurs.size()>0)
	{
		unVisiteur = lesVisiteurs.get(0);
	    System.out.println("Le Visiteur à modifier est : ");
	    unVisiteur.afficher();
	    
		System.out.print("Nouveau Nom   :");
		unNom = Cons.saisirChaine();
		unVisiteur.set_nom(unNom);
                System.out.print("Nouveau Prenom   :");
		unPrenom = Cons.saisirChaine();
		unVisiteur.set_prenom(unPrenom);
                System.out.print("Nouvelle Adresse   :");
		uneAdresse = Cons.saisirChaine();
		unVisiteur.set_adr(uneAdresse);
                System.out.print("Nouvelle date d'embauche   :");
		uneDateE = Cons.saisirChaine();
		unVisiteur.set_date(uneDateE);
		
        // Modifier le visiteur
		nb = PasserelleBdd.modifVis('M',unVisiteur);
		if (nb==1)
		{
		    System.out.println("Modification bien effectuée ");
		}
		else
		{
		    System.out.println("Echec de la modification ! ");
		}     	          	    	    
	}	
	// Sinon, le Visiteur n'a pas été trouvé
	else
	{
		System.out.println("Visiteur inconnu !");
	}
		
} // Fin de modifier
    
    
 
 static public void supprimer() throws Exception {
	int nb;
	String unMat;
	String reponse;
	char choix;
	ArrayList<Visiteur> lesVisiteurs;
        Visiteur unVisiteur;

	System.out.print("\nMatricule de visiteur a supprimer : ");
	unMat = Cons.saisirChaine();
	
    // Rechercher et afficher le visiteurr correspondant
    // pour demander confirmation
	lesVisiteurs = PasserelleBdd.lireVis(unMat);
	
	// S'il y a un résultat
	while (lesVisiteurs.isEmpty())
	{
            System.out.println("aucun visiteur ne correspond au matricule "+unMat+".");
            System.out.print("\nMatricule de visiteur a supprimer : ");
            unMat = Cons.saisirChaine();
            lesVisiteurs = PasserelleBdd.lireVis(unMat);
        }
        
        unVisiteur = lesVisiteurs.get(0);
        System.out.println("Le visiteur à supprimer est : ");
        unVisiteur.afficher();

	    System.out.print("Voulez vous réellement supprimer ce Visiteur (o/n) ? : ");
    	reponse = Cons.saisirChaine();
    	choix=reponse.charAt(0);
        if (choix=='o')
        {
            // Supprimer l'Visiteur
			nb = PasserelleBdd.modifVis('S',unVisiteur);
			if (nb==1)
			{
			    System.out.println("Suppression bien effectuée ");
			}
			else
			{
			    System.out.println("Echec de la suppression ! ");
			}     
        }
        else
        {
          System.out.println("Suppression non effectuée ! ");
        }	    	    	    	
	// Sinon, le Visiteur n'a pas été trouvé
	
} // Fin de supprimer
    

} // Fin class