/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class Praticien {
    
    // atributs 
    private int pra_code;
    private String nom;
    private String prenom;
    private String adresse;
    private String fonction;
    
    // methodes
    public Praticien() {
        pra_code = 0;
        nom = "";
        prenom = "";
        adresse = "";
        fonction = "";
            
    } 
    
    public Praticien(int lePracode, String lenom, String leprenom, String ladresse, String lafonction) {
        pra_code = lePracode;
        nom = lenom;
        prenom = leprenom;
        adresse = ladresse;
        fonction = lafonction;
    }
    
    
    public int get_Pracode() {
        return pra_code;
    }

    public String get_nom() {
        return nom;
    }

    public String get_prenom() {
        return prenom;
    }

    public String get_adresse() {
        return adresse;
    }

    public String get_fonction() {
        return fonction;
    }

  public void set_Pracode(int lePracode) {
        pra_code=lePracode;
    }

    public void set_nom(String lenom) {
        nom = lenom;
    }

    public void set_prenom(String leprenom) {
        prenom = leprenom;
    }

    public void set_adresse(String ladresse) {
        adresse = ladresse;
    }

    public void set_fonction(String lafonction) {
        fonction = lafonction;
    }

  


    public void afficher() {
        String ligneAffiche;
        
        System.out.println();
        
        ligneAffiche = String.format("|%-15s|%-10s|%-10s|%-34s|%-17s|", "code praticien", "Nom", "Prenom", "Adresse", "Fonction");
	System.out.println(ligneAffiche);
        
        ligneAffiche = String.format("|%-15s|%-10s|%-10s|%-34s|%-17s|",pra_code, nom, prenom, adresse, fonction);
        System.out.println(ligneAffiche);
        System.out.println();
    }

    public void afficherPra_code() {
        System.out.println("matricule : " + pra_code);
    }

    public void afficherNom() {
        System.out.println("nom : " + nom);
    }

    public void afficherPrenom() {
        System.out.println("prenom : " +prenom);
    }

    public void afficherAdresse() {
        System.out.println("adresse : " + adresse);
    }

    public void afficherFonction() {
        System.out.println("fonction : " + fonction);
    }
    
    
} // Fin class
