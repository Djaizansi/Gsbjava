
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
public class ManipMainProjet {
    // Affichage Console
    
    static public void main (String[] arg)throws Exception {
        
       int Saisie=0;
       while(Saisie==0){ 
        char choix;
        choix = '1';
        ArrayList <Visiteur> lesVis;
        Visiteur user_logged;
        
        
        lesVis=new ArrayList<>();
       
        
        int i;
        
        String DesUsers;
        String DesMdp;
        

        Visiteur uneVis;
                /*System.out.println("Users: ");
		DesUsers = Cons.saisirChaine();
                lesVis = PasserelleBdd.ConnexionUsers(DesUsers);
                System.out.println(lesVis);
                System.out.println("Mdp: ");
                DesMdp = Cons.saisirChaine();
                lesVis = PasserelleBdd.ConnexionMdp(DesMdp);
                for(i=0;i<lesVis.size();i++){
                    uneVis=lesVis.get(i);
                    uneMat=uneVis.get_mat();
                    uneMdp=uneVis.get_mdp();
                }
        */
            
        
        System.out.println("Users: ");
        DesUsers = Cons.saisirChaine();
        System.out.println("Mdp: ");
        DesMdp = Cons.saisirChaine();
        
        while(PasserelleBdd.Connexion(DesUsers,DesMdp) == false){
             System.out.println("L'utilisateur ou le mot de passe est incorrecte");
             System.out.println("Ressaisissez les coordonnées");
             System.out.println("Users: ");
             DesUsers = Cons.saisirChaine();
             System.out.println("Mdp: ");
             DesMdp = Cons.saisirChaine();
        }
             if(PasserelleBdd.Connexion(DesUsers,DesMdp))
             {
                   System.out.println("");
                   boolean is_delegue = PasserelleBdd.isDelegue(DesUsers);
                   System.out.println("");
                   
                while (choix!='0') {
                    //system ("cls");
                    System.out.println("\nGestion des compte rendu");
                    System.out.println("");
                    
                    if(is_delegue == true) {
                         System.out.println("Visiteur :");
                         System.out.println("1. Lister visiteur");
                         System.out.println("2. Rechercher visiteur");
                         System.out.println("");
                         
                         System.out.println("Praticien :");
                         System.out.println("3. Lister Praticiens");
                         System.out.println("4. Rechercher Praticiens");
                         System.out.println("");
                         
                         System.out.println("Medicament :");
                         System.out.println("5. Lister medicament");
                         System.out.println("6. Lister medicament perimer");
                         System.out.println("7. Rechercher medicament");
                         System.out.println("");
                         
                         System.out.println("Rapport visite :");
                         System.out.println("a. Lister rapport");
                         System.out.println("b. Ajouter rapport visite");
                         System.out.println("c. Rechercher rapport");
                         System.out.println("");
                         
                         System.out.println("0. Deconnexion ou Quitter");

                         System.out.println("");
                         System.out.print("Choisir une action : ");
                         
                          String texte = Cons.saisirChaine();
                          choix = texte.charAt(0);
                          switch (choix) {

                        // Gestion visiteur
                        case '1' : // Lister
                            ManipVisiteur.lister();
                            break;

                        case '2' : // Rechercher
                            ManipVisiteur.rechercher();
                            break;

                        // Gestion praticien
                        case '3' : // Lister
                            ManipPraticien.listerPrat();
                            break;

                        case '4' : // Rechercher
                            ManipPraticien.rechercherPrat();
                            break;

                        // Gestion medicament
                        case '5' : // Lister
                            ManipMedicament.listerMed();
                            break; 
                            
                        case '6' : // Lister Med Perim
                            ManipMedicament.listerMedPerim();
                            break; 

                        case '7' : // Rechercher
                            ManipMedicament.rechercherMed();
                            break; 

                        // Gestion rapport visite

                        case 'a' : // Lister
                            ManipRapport_visite.listerRap();
                            break;

                        case 'b' : // Ajouter
                            ManipRapport_visite.ajouterRapport();
                            break;

                        case 'c' : // Rechercher
                            ManipRapport_visite.rechercherRap();
                            break;
                     
                        // Aretter le programme    
                        case '0' : // Fin du programme
                            System.out.println("Deconnexion -> 0 | Quitter programme -> 1");
                            Saisie = Cons.saisirEntier();
                            if(Saisie==1){
                                break;
                            }
                            } // Fin swith
                          
                          
                    }
                    else{
                        
                        System.out.println("Visiteur :");
                        System.out.println("1. Lister visiteur"); 
                        System.out.println("2. Ajouter visiteur");
                        System.out.println("3. Rechercher visiteur");
                        System.out.println("4. Modifier visiteur");
                        System.out.println("5. Supprimer visiteur");
                        System.out.println("");

                        System.out.println("Praticien :");
                        System.out.println("6. Lister Praticiens");
                        System.out.println("7. Rechercher Praticiens");
                        System.out.println("");

                        System.out.println("Medicament :");
                        System.out.println("8. Lister medicament");
                        System.out.println("9. Lister medicament Perimer");
                        System.out.println("z. Rechercher medicament");
                        System.out.println("");

                        System.out.println("Rapport visite :");
                        System.out.println("a. Lister rapport");
                        System.out.println("b. Ajouter rapport visite");
                        System.out.println("c. Rechercher rapport");
                        System.out.println("d. Nombre de rapport par medicament");
                        System.out.println("");


                        System.out.println("0. Deconnexion ou Quitter");

                        System.out.println("");
                        System.out.print("Choisir une action : ");
                        
                        String texte = Cons.saisirChaine();
                        choix = texte.charAt(0);
                        
                        switch (choix) {

                        // Gestion visiteur
                        case '1' : // Lister
                            ManipVisiteur.lister();
                            break;

                        case '2' : // Ajouter
                            ManipVisiteur.ajouter();
                            break;

                        case '3' : // Rechercher
                            ManipVisiteur.rechercher();
                            break;

                        case '4' : // Modifier
                            ManipVisiteur.modifier();
                            break;

                        case '5' : // Supprimer
                            ManipVisiteur.supprimer();
                            break;

                        // Gestion praticien
                        case '6' : // Lister
                            ManipPraticien.listerPrat();
                            break;

                        case '7' : // Rechercher
                            ManipPraticien.rechercherPrat();
                            break;

                        // Gestion medicament
                        case '8' : // Lister
                            ManipMedicament.listerMed();
                            break; 
                        
                        case '9' : // Lister Med Perimé
                            ManipMedicament.listerMedPerim();
                            break; 

                        case 'z' : // Rechercher
                            ManipMedicament.rechercherMed();
                            break; 

                        // Gestion rapport visite

                        case 'a' : // Lister
                            ManipRapport_visite.listerRap();
                            break;

                        case 'b' : // Ajouter
                            ManipRapport_visite.ajouterRapport();
                            break;

                        case 'c' : // Rechercher
                            ManipRapport_visite.rechercherRap();
                            break;
                            
                        case 'd' : // Rechercher
                            ManipRapport_visite.NombreRapportParMed();
                            break;

                        // Arreter le programme    
                        case '0' : // Fin du programme
                            System.out.println("Deconnexion -> 0 | Quitter programme -> 1");
                            Saisie = Cons.saisirEntier();
                            if(Saisie==1){
                                break;
                            }
                        
                            } // Fin swith 
                        }//
                } // Fin while
            } //Fin while
        }// Fin while deconnexion
      }// Fin main
}// Fin programme
