import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class ManipPraticien {
    
    static public void listerPrat()  throws Exception {
 	int  i;
	String unNom, unPrenom, uneAdresse, uneFonction;
        int unPra_code; 
	Praticien unPraticien;
	ArrayList <Praticien> lesPraticiens;
	String ligneAffiche;

	i=0;
	lesPraticiens = PasserelleBdd.lirePrat(0);
	System.out.println();
	ligneAffiche = String.format("|%-15s|%-10s|%-10s|%-34s|%-17s|", "code praticien", "Nom", "Prenom", "Adresse", "Fonction");
	System.out.println(ligneAffiche);

	ligneAffiche = String.format("|%-15s|%-10s|%-10s|%-34s|%-17s|","---------------", "----------", "----------" ,"----------------------------------", "-----------------");
	System.out.println(ligneAffiche);

	while (i<lesPraticiens.size()) {
            unPraticien = lesPraticiens.get(i);

            unPra_code = unPraticien.get_Pracode();
            unNom = unPraticien.get_nom();
            unPrenom = unPraticien.get_prenom();
            uneAdresse = unPraticien.get_adresse();
            uneFonction = unPraticien.get_fonction();
            
            

            ligneAffiche = String.format("|%-15s|%-10s|%-10s|%-34s|%-17s|",unPra_code, unNom, unPrenom, uneAdresse, uneFonction);
            System.out.println(ligneAffiche);
        
            i=i+1;
	} //Fin while
	if (i==0) {
            System.out.println("Aucun Praticien");
	} //Fin if
    } // Fin lister
    
    
    static public void rechercherPrat() throws Exception {
	int lePra_code;
	ArrayList<Praticien> lesPraticien;
        
        System.out.println();
	System.out.print("code de praticien recherché : ");
	lePra_code = Cons.saisirEntier();
	
	lesPraticien = PasserelleBdd.lirePrat(lePra_code);
	
        System.out.println();
        System.out.println();
	// S'il y a un résultat
	if (lesPraticien.size()>0)
	{
	    System.out.println("Le praticien recherché est : ");
	    lesPraticien.get(0).afficher();
	}	
	// Sinon, le Visiteur n'a pas été trouvé
	else
	{
		System.out.println("Praticien inconnu !");
	}
    } // Fin de rechercher
    
    
}