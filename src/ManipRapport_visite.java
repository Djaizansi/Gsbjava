
import java.util.ArrayList;
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
public class ManipRapport_visite {
    
     static public void ajouterRapport() throws Exception {
        String uneDateRapport,unBilan,unMotif,unMat,unMedDepot;
        int unNum, uneOffQte, unPracode;
        boolean unEtatMed;
        //Visiteur unMat;
        //Praticien unPracode;
        //Medicament unMedDepot;
        
        Rapport_visite unRapport_visite;
        //Visiteur unVisiteur;
        //Praticien unPraticien;
        //Medicament unMedicament;
        ArrayList <Visiteur> lesVis;
        ArrayList <Praticien> lesPra;
        ArrayList <Medicament> LesMed;//*77
        
        lesVis=new ArrayList<>();
        lesPra=new ArrayList<>();
        LesMed=new ArrayList<>();
        
        
        uneDateRapport="";
        
	// Saisie des informations
		 
                System.out.println("Saisir le numero du rapport :");
		unNum= Cons.saisirEntier();
                
                 
               boolean c = false;
                    System.out.println("Saisir la date de la visite :");
                    System.out.println("(aaaa-mm-jj)");
                    uneDateRapport = Cons.saisirChaine();
                    
                    c = Pattern.matches("[2][0][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDateRapport);
               
               while (c == false)
                {
                    System.out.println("La date n'est pas au bon format,");
                    System.out.println("il faut respecter le format aaaa-mm-jj");
                    uneDateRapport = Cons.saisirChaine();
                    c = Pattern.matches("[1-9][0-9][0-9][0-9][-][0-1][0-9][-][0-3][0-9]",uneDateRapport);
                }
               
               System.out.println("Saisir le bilan :");
		unBilan = Cons.saisirChaine();
                
                
               System.out.println("Saisir le motif :");
		unMotif = Cons.saisirChaine();
                
               
               System.out.println("Saisir l'etat du medicament (si 0 = rien de special| 1 = problème): ");
		int unEtat = Cons.saisirEntier();
                if(unEtat==0){
                       unEtatMed = false; //pas d'effet    
                }
                else{
                        unEtatMed= true;
                }
                
                
                System.out.println("Saisir la quantite à offrir :");
		uneOffQte= Cons.saisirEntier();
                
                
                System.out.println("Saisir le matricule du visiteur :");
                unMat = Cons.saisirChaine();
                lesVis = PasserelleBdd.lireVis(unMat);
               while (lesVis.size()<=0)
               {
                System.out.println("Le matricule du visiteurt n'a pas été trouvé,");
                System.out.println("Veuillez le saisir à nouveau :");
		String unemat = Cons.saisirChaine();
                lesVis = PasserelleBdd.lireVis(unemat);
               }
               
               System.out.println("Saisir le code praticien :");
		unPracode = Cons.saisirEntier();
                lesPra = PasserelleBdd.lirePrat(unPracode);
               while (lesPra.size()<=0)
               {
                System.out.println("Le code du praticien n'a pas été trouvé,");
                System.out.println("Veuillez le saisir à nouveau :");
		unPracode = Cons.saisirEntier();
                lesPra = PasserelleBdd.lirePrat(unPracode);
               }
               
               System.out.println("Saisir le code Medicament :");
		unMedDepot = Cons.saisirChaine();
                LesMed = PasserelleBdd.lireMed(unMedDepot);
                
               while (LesMed.size()<=0)
               {
                System.out.println("Le code du Medicament n'a pas été trouvé,");
                System.out.println("Veuillez le saisir à nouveau :");
		unMedDepot = Cons.saisirChaine();
                LesMed = PasserelleBdd.lireMed(unMedDepot);
               }
        
               
		unRapport_visite = new Rapport_visite(unNum, uneDateRapport, unBilan, unMotif, unEtatMed, uneOffQte, new Visiteur(unMat,"","","","","","",""), new Praticien(unPracode,"","","",""), new Medicament(unMedDepot,0,false,"",new Famille(0,"")));
		int nb = PasserelleBdd.modifRap('A',unRapport_visite);
		if (nb==1)
		{
		    System.out.println("Ajout du rapport bien effectué ");
		}
		else
		{
		    System.out.println("Echec de l'ajout du rapport ! ");
		}
 } // fin ajouter
     
     
static public void listerRap()  throws Exception {
 	int  i, unRapNum, unRapOffre;
	String  unRapDate, unRapBilan, unRapMotif  ;
        Praticien unPraCode;
        Boolean unRapEtat;
        Visiteur unVisMatricule;
        Medicament unMedi;
	ArrayList <Rapport_visite> lesRapportVisites;
	String ligneAffiche;
        Rapport_visite unRapport;

	i=0;
	lesRapportVisites= PasserelleBdd.lireRap(0);
	System.out.println();
	ligneAffiche = String.format("|%-15s|%-10s|%-20s|%-40s|%-15s|%-17s|%-15s|%-15s|%-15s|", "numero rapport", "date rappt", "Bilan rapport", "Motif rapport", "Etat medicament","Offre rapport ", "Vis matricule", "pra code", "Num medicament");
	System.out.println(ligneAffiche);

	ligneAffiche = String.format("|%-15s|%-10s|%-20s|%-40s|%-15s|%-17s|%-15s|%-15s|%-15s|","---------------", "----------", "--------------------" ,"----------------------------------------","---------------","-----------------", "--------------", "---------------", "---------------");
	System.out.println(ligneAffiche);

	while (i<lesRapportVisites.size()) {
            unRapport = lesRapportVisites.get(i);

            unRapNum = unRapport.get_num();
            unRapDate = unRapport.get_date();
            unRapBilan = unRapport.get_bilan();
            unRapMotif = unRapport.get_motif();
            unRapEtat = unRapport.get_etat();
            unRapOffre = unRapport.get_offre();
            unVisMatricule = unRapport.get_mat();
            unPraCode = unRapport.get_Pracode();
            unMedi = unRapport.get_med();
            
            
            

            ligneAffiche = String.format("|%-15s|%-10s|%-20s|%-40s|%-15s|%-17s|%-15s|%-15s|%-15s|",unRapNum, unRapDate, unRapBilan, unRapMotif, unRapEtat, unRapOffre, unVisMatricule.get_mat(), unPraCode.get_Pracode(), unMedi.get_med());
            System.out.println(ligneAffiche);
        
            i=i+1;
	} //Fin while
	if (i==0) {
            System.out.println("Aucun Rapport !");
	} //Fin if
    } // Fin lister
    
         
      static public void rechercherRap() throws Exception {
	String unRap_date;
	ArrayList<Rapport_visite> lesRap;
        Rapport_visite unRap ;
        
	// Saisie du matricule a rechercher
		System.out.println("date du rapport a rechercher:");
		unRap_date = Cons.saisirChaine();
	
		lesRap = PasserelleBdd.lireRapport(unRap_date);
                
                //si il ya un resultat 
                if (lesRap.size()>0)
               {
                    System.out.println("Le/s rapport/s recherché/s est/sont :");
                    int i = 0;
                    while (i<lesRap.size())
                    {
                        unRap=lesRap.get(i);
                        unRap.afficher();
                        i++;
                    }
               }
               //sinon visiteur na pas ete trouver 
               else 
               {
                System.out.println("Aucun rapport pour cette date ");   
               }	
 }
      
      static public void NombreRapportParMed() throws Exception {
        int  i;
        Medicament unMedi;
	ArrayList <Rapport_visite> lesRapportVisites;
	String ligneAffiche;
        Rapport_visite unRapport;

	i=0;
	lesRapportVisites= PasserelleBdd.lireNombreRapport();
	System.out.println();
	ligneAffiche = String.format("|%-15s|%-15s|","Nombre rapport","Nom medicament");
	System.out.println(ligneAffiche);

	ligneAffiche = String.format("|%-15s|%-15s|","---------------", "---------------");
	System.out.println(ligneAffiche);

	while (i<lesRapportVisites.size()) {
            unRapport = lesRapportVisites.get(i);
            unMedi = unRapport.get_med();
            ligneAffiche = String.format("|%-15s|%-15s|",unRapport.get_num(),unMedi.get_med());
            System.out.println(ligneAffiche);
        
            i=i+1;
	} //Fin while
	if (i==0) {
            System.out.println("Aucun Rapport !");
	} //Fin if
    } // Fin listerNombreRapport
}
     
