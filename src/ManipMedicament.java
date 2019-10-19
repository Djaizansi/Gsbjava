
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class ManipMedicament {
    static public void listerMed()  throws Exception {
 	int  i;
	String unMedDepot, uneDateP;
        Famille unCode;
        int uneQuantite;
        boolean unEtatMed;
	Medicament unMedicament;
	ArrayList<Medicament> lesMedicament;
	String ligneAffiche;

	i=0;
	lesMedicament = PasserelleBdd.lireMed("");
	System.out.println();
	ligneAffiche = String.format("|%-10s|%-10s|%-15s|%-34s|%-17s|", "Medicament", "Quantite", "Etat Medicament", "Date peremption", "Code Famille");
	System.out.println(ligneAffiche);

	ligneAffiche = String.format("|%-10s|%-10s|%-15s|%-34s|%-17s|","----------", "----------", "--------------" ,"----------------------------------", "-----------------");
	System.out.println(ligneAffiche);

	while (i<lesMedicament.size()) {
            unMedicament = lesMedicament.get(i);

            unMedDepot = unMedicament.get_med();
            uneQuantite = unMedicament.get_stock();
            unEtatMed = unMedicament.get_etatmed();
            uneDateP = unMedicament.get_datep();
            unCode = unMedicament.get_codef();
            
            

            ligneAffiche = String.format("|%-10s|%-10s|%-15s|%-34s|%-17s|",unMedDepot, uneQuantite, unEtatMed, uneDateP, unCode.get_lib_med());
            System.out.println(ligneAffiche);

            i=i+1;
	} //Fin while
	if (i==0) {
            System.out.println("Aucun Medicament");
	} //Fin if
    } // Fin lister
    
   
    
      static public void rechercherMed() throws Exception {
	String leMedDepot;
	ArrayList<Medicament> lesMedicament;
        Medicament unMedic ;
        
	// Saisie du matricule a rechercher
		System.out.println("Le code du medicament a rechercher:");
		leMedDepot = Cons.saisirChaine();
	
		lesMedicament = PasserelleBdd.lireMed(leMedDepot);
               
                //si il ya un resultat 
                
               if (lesMedicament.size()>0)
               {
               System.out.println("Le medicament a rechercher est :");
	       unMedic=lesMedicament.get(0);
               unMedic.afficher();
               }
               
               //sinon visiteur na pas ete trouver 
               else 
               {
                System.out.println("Medicament inconnu !! ");   
               }	
 }
      static public void listerMedPerim() throws Exception {
	int  i;
	String unMedDepot, uneDateP;
        Famille unCode;
        int uneQuantite;
        boolean unEtatMed;
	Medicament unMedicament;
	ArrayList<Medicament> lesMedicament;
	String ligneAffiche;

	i=0;
	lesMedicament = PasserelleBdd.lireMedPerim();
	System.out.println();
	ligneAffiche = String.format("|%-10s|%-10s|%-15s|%-34s|%-17s|", "Medicament", "Quantite", "Etat Medicament", "Date peremption", "Code Famille");
	System.out.println(ligneAffiche);

	ligneAffiche = String.format("|%-10s|%-10s|%-15s|%-34s|%-17s|","----------", "----------", "--------------" ,"----------------------------------", "-----------------");
	System.out.println(ligneAffiche);

	while (i<lesMedicament.size()) {
            unMedicament = lesMedicament.get(i);

            unMedDepot = unMedicament.get_med();
            uneQuantite = unMedicament.get_stock();
            unEtatMed = unMedicament.get_etatmed();
            uneDateP = unMedicament.get_datep();
            unCode = unMedicament.get_codef();
            
            

            ligneAffiche = String.format("|%-10s|%-10s|%-15s|%-34s|%-17s|",unMedDepot, uneQuantite, unEtatMed, uneDateP, unCode.get_lib_med());
            System.out.println(ligneAffiche);

            i=i+1;
	} //Fin while
	if (i==0) {
            System.out.println("Aucun Medicament Perimé");
	} //Fin if
    } // Fin lister	
 }