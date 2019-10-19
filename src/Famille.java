/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class Famille {
    // atributs 
    private int code_f;
    private String nom_f;
    

 // methodes
    public Famille() {
        code_f = 0;
        nom_f= "";
        
    }
    
    
    public Famille(int num_typ, String lib_med) {
        code_f= num_typ;
        nom_f = lib_med;
        
    }
    
     public int get_typ_med() {
        return code_f;
    }

    public String get_lib_med() {
        return nom_f;
    }
    
    
    public void set_typ(int num_typ) {
        code_f = num_typ;
    }

    public void set_lib(String lib_med) {
        nom_f = lib_med;
    }
    
     public void afficher() {
     System.out.println("Numero type medicament : " + code_f);
     System.out.println("libelle du medicament : " + nom_f);
    
    
}
     
      public void afficherTyp() {
        System.out.println("Numero type medicament : " +code_f);
    }

    public void afficherNom() {
        System.out.println("Libelle du medicament : " + nom_f);
    }
}
