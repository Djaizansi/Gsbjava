/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sio2
 */
public class Rapport_visite {
      // attributs 
    private int num;
    private String date_rapport;
    private String bilan;
    private String motif;
    private boolean etat_med;
    private int off_qte;
    private Visiteur vis_matricule;
    private Praticien pra_code;
    private Medicament med_depot_legal;
    
    
    
      // methodes
    public Rapport_visite() {
        num = 0;
        date_rapport = "";
        bilan = "";
        motif = "";
        etat_med = false;
        off_qte = 0;
        vis_matricule = new Visiteur(); 
        pra_code = new Praticien();
        med_depot_legal = new Medicament();     
    } 
    
    
     public Rapport_visite(int unNum, String uneDate, String unBilan, String unMotif, boolean unEtatMed, int uneOffre, Visiteur unMat, Praticien unPracode, Medicament unMed) {
        num = unNum;
        date_rapport = uneDate;
        bilan= unBilan;
        motif = unMotif;
        etat_med = unEtatMed;
        off_qte = uneOffre;
        vis_matricule = unMat;
        pra_code = unPracode;
        med_depot_legal = unMed;
        
        
        
        
}

    public int get_num() {
        return num;
    }

    public void set_num(int unNum) {
        this.num = unNum;
    }

    public String get_date() {
        return date_rapport;
    }

    public void set_date(String unDate) {
        this.date_rapport = unDate;
    }

    public String get_bilan() {
        return bilan;
    }

    public void set_bilan(String unBilan) {
        this.bilan = unBilan;
    }

    public String get_motif() {
        return motif;
    }

    public void set_motif(String unMotif) {
        this.motif = unMotif;
    }
    
    public boolean get_etat() {
        return etat_med;
    }

    public void set_etat(boolean unEtat) {
        this.etat_med = unEtat;
    }
    
    public int get_offre() {
        return off_qte;
    }

    public void set_offre(int uneOffre) {
        this.off_qte = uneOffre;
    }
    
    public Visiteur get_mat() {
        return vis_matricule;
    }

    public void set_mat(Visiteur unMat) {
        this.vis_matricule = unMat;
    }
    
    public Praticien get_Pracode() {
        return pra_code;
    }

    public void set_Pracode(Praticien unPracode) {
        this.pra_code = unPracode;
    }

    public Medicament get_med(){
        return med_depot_legal;
    }
    public void set_med(Medicament unMed){
        this.med_depot_legal = unMed;
    }
    
    public void afficher() {
        String ligneAffiche;
        
        System.out.println();
        
        ligneAffiche = String.format("|%-15s|%-10s|%-10s|%-34s|%-17s|%-14s|%-14s|%-14s|%-14s|", "num rapport", "Date rapport", "Bilan", "Motif", "Etat medicament", "Offre quantite", "visiteur", "praticien", "Medicament" );
	System.out.println(ligneAffiche);
        
        ligneAffiche = String.format("|%-15s|%-10s|%-10s|%-34s|%-17s|%-14s|%-14s|%-14s|%-14s|", num, date_rapport, bilan, motif, etat_med, off_qte, vis_matricule.get_mat(), pra_code.get_Pracode(), med_depot_legal.get_med());
        System.out.println(ligneAffiche);
        System.out.println();
    }
}
