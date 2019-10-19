/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class Medicament {
    // atributs 
    private String med_depot_legal ;
    private int quantite;
    private boolean etat_med;
    private String date_peremption;
    private Famille code_f;
        
    // methodes
    public Medicament() {
        med_depot_legal = "";
        quantite=0;
        etat_med=false; //medicament bon = 0 donc false 
        date_peremption="";
        code_f = new Famille();
        
    }
    

    public Medicament(String lemed, int lestock, boolean letatmed, String ladateperemp, Famille lecodef) {
        med_depot_legal = lemed;
        quantite = lestock;
        etat_med= letatmed;
        date_peremption=ladateperemp;
        code_f = lecodef;
       
    }

    public String get_med() {
        return med_depot_legal ;
    }

    public int get_stock() {
        return quantite ;
    }

    public boolean get_etatmed() {
        return etat_med;
    }

    public String get_datep() {
        return date_peremption;
    }

    public Famille get_codef() {
        return code_f ;
    }

    public void set_med(String lemed) {
        med_depot_legal = lemed;
    }

    public void set_stock(int lestock) {
        quantite = lestock;
    }

    public void set_etatmed(boolean letatmed) {
        etat_med = letatmed;
    }

    public void set_datep(String ladateperemp) {
        date_peremption = ladateperemp;
    }

    public void set_codef(Famille lecodef) {
        this.code_f = lecodef;
    }



    public void afficher() {
        System.out.println("medicament : " + med_depot_legal);
        System.out.println("Quantite : " + quantite);
        System.out.println("Etat medicament : " + etat_med);
        System.out.println("Date de Peremption : " + date_peremption);
        System.out.println("Numero Type Medicament : " + code_f.get_lib_med());
       
    }
    
   

    public void afficherMed() {
        System.out.println("Medicament : " + med_depot_legal);
    }

    public void afficherStock() {
        System.out.println("Stock : " + quantite);
    }

    public void afficherEtatmed() {
        System.out.println("Etat medicament : " + etat_med);
    }

    public void afficherDatep() {
        System.out.println("Date de Peremption : " + date_peremption);
    }

    public void afficherCodef() {
        System.out.println("Numero Type Medicament : " + code_f.get_lib_med());
    }
    
}
