/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class Visiteur {
    
    // attributs 
    private String vis_matricule;
    private String statut;
    private String mdp;
    private String nom;
    private String prenom;
    private String adresse;
    private String date_embauche;
    private String annee_embauche;
    
        
    // methodes
    public Visiteur() {
        vis_matricule = "";
        statut = "";
        mdp = "";
        nom = "";
        prenom = "";
        adresse = "";
        date_embauche = "";
        annee_embauche = "";
    }
    
    /**
     *
     * @param mat
     * @param name
     * @param preno
     * @param adr
     * @param date
     * @param stat
     * @param motdp
     */
    public Visiteur(String mat, String stat, String motdp, String name, String preno, String adr, String date, String annee) {
        vis_matricule = mat;
        statut = stat;
        mdp = motdp;
        nom = name;
        prenom = preno;
        adresse = adr;
        date_embauche = date;
        annee_embauche = annee;
    }

    public String get_mat() {
        return vis_matricule;
    }

    public String get_nom() {
        return nom;
    }

    public String get_prenom() {
        return prenom;
    }

    public String get_adr() {
        return adresse;
    }

    public String get_date() {
        return date_embauche;
    }

    public String get_statut() {
        return statut;
    }
    
    public String get_mdp() {
        return mdp;
    }
    
    public String get_annee() {
        return annee_embauche;
    }

    public void set_mat(String mat) {
        vis_matricule = mat;
    }

    public void set_nom(String name) {
        nom = name;
    }

    public void set_prenom(String preno) {
        prenom = preno;
    }

    public void set_adr(String adr) {
        adresse = adr;
    }

    public void set_date(String date) {
        date_embauche = date;
    }

    public void set_statut(String stat) {
        statut = stat;
    }
    
    public void set_mdp(String motdp) {
        mdp = motdp;
    }
    


    public void afficher() {
        
        String ligneAffiche;
        
        System.out.println("");
        ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-17s|%-34s|%-6s|","Matricule","Statut", "Nom", "Prenom", "Adresse", "Date","Annee");
	System.out.println(ligneAffiche);
        
        ligneAffiche = String.format("|%-10s|%-10s|%-10s|%-17s|%-34s|%-6s|",vis_matricule, statut, nom, prenom, adresse, date_embauche,annee_embauche);
        System.out.println(ligneAffiche);
        System.out.println("");
    }

    public void afficherMat() {
        System.out.println("matricule : " + vis_matricule);
    }

    public void afficherNom() {
        System.out.println("nom : " + nom);
    }

    public void afficherPrenom() {
        System.out.println("prenom : " + prenom);
    }

    public void afficherAdresse() {
        System.out.println("adresse : " + adresse);
    }

    public void afficherDate() {
        System.out.println("Date embauche : " + date_embauche);
    }

    public void afficherStatut() {
        System.out.println("Statut : " + statut);
    }
         
} // Fin class