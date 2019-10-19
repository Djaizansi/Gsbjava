/**
 * @(#)UsaBdd.java
 *
 *
 * @author 
 * @version 1.00 2012/2/21
 */

// librairie pour utiliser les classes pour la base de données
import java.sql.*;
import java.util.*;


public class PasserelleBdd {	
	// Méthode lireVis
	// Lecture de données dans la table Visiteur
	// Paramètres :
	//   Matricule de l'utilisateur recherché ("" pour la liste complète)
	// Valeur retournée : liste des visiteurs
	 
    /**
     *
     * @param matricule
     * @return
     * @throws SQLException
     */
    	 
	public static ArrayList<Visiteur> lireVis(String matricule) throws SQLException
	{
		ArrayList<Visiteur> lesV;
		Visiteur unV;	
		String requete;	
		ResultSet rs  = null;
                
                
		boolean alire;
		
		lesV = new ArrayList<>();
                
		// Définition de la requête
		requete = "SELECT vis_matricule, statut, nom, prenom, adresse, date_embauche, annee_embauche FROM visiteur";
		
		// Si un matricule de Visiteur est précisé, faire une recherche sur ce numéro
		if (matricule != "")
		{
                    requete = requete + " WHERE vis_matricule= '"+matricule+"'";
		}
		requete = requete + " order by vis_matricule;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
			unV = new Visiteur(rs.getString(1),rs.getString(2),"",rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			lesV.add(unV);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesV;
	}
        
        
        public static ArrayList<Praticien> lirePrat(int pra_code) throws SQLException
	{
		ArrayList<Praticien> lesPra;
		Praticien unPra;	
		String requete;	
		ResultSet rs  = null;
	
		boolean alire;
		
		lesPra = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT pra_code, nom, prenom, adresse, fonction   FROM praticien";
		
		// Si un pra code de praticien est précisé, faire une recherche sur ce numéro
		if (pra_code != 0)
		{
                    requete = requete + " WHERE pra_code=" + pra_code;				
		}
		requete = requete + " order by pra_code;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
                      
                    
			unPra = new Praticien(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			lesPra.add(unPra);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesPra;
	}
	
	//****		
	
	// Méthode modifVis
	// Modification de données dans la table Visiteur
	// Paramètres :
	// - Type de la modification : char typeModif
	// 		'A' : ajouter
	//		'M' : modifier
	//		'S' : supprimer	
	// - Visiteur à modifier : Visiteur V
	// Valeur retournée : 1 si modification effectuée, 0 sinon

	public static int modifVis(char typeModif, Visiteur V) throws SQLException
	{
		
		String requete = null;
		int res;
		
		String unMatricule, unStatut, unNom, unPrenom, uneAdresse, uneDateEmbauche, uneAnneeE;
                
		
		unMatricule=V.get_mat();
                unStatut=V.get_statut();
		unNom=V.get_nom();
                unPrenom=V.get_prenom();
                uneAdresse=V.get_adr();
                uneDateEmbauche=V.get_date();
                uneAnneeE=V.get_annee();
       
		
		switch (typeModif)
		{
		  case 'A' : // Ajouter
			requete = "INSERT INTO visiteur(vis_matricule, statut, nom, prenom, adresse, date_embauche)"
                                + "VALUES('"+unMatricule+"', '"+unStatut+"', '"+unNom+"', '"+unPrenom+"', '"+uneAdresse+"', '"+uneDateEmbauche+"', '"+uneAnneeE+"');";
			break;
			
		  case 'M' : // Modifier
			requete = "UPDATE visiteur SET nom ='" +unNom+ "', prenom='" +unPrenom+ "', adresse ='" +uneAdresse+ "', date_embauche='" +uneDateEmbauche+ "'";
			requete = requete + "WHERE vis_matricule = '"+unMatricule+"';";	
			break;
			
		  case 'S' : // Supprimer
			requete = "DELETE FROM visiteur WHERE VIS_MATRICULE = '"+unMatricule+"';";	
			break;
			
		  default : // Erreur
			break;
		}
		
		System.out.println("Requete : "+requete+" ");
		V.afficher();
	
		
		Bdd laBdd = new Bdd();		
		res = laBdd.modif(requete);		
		return res;
	}
        
        
        public static ArrayList<Medicament> lireMed(String med_depot_legal) throws SQLException
	{
		ArrayList<Medicament> lesMed;
		Medicament unMed;	
		String requete;	
		ResultSet rs  = null;
                
		boolean alire;
		
		lesMed = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT med_depot_legal, quantite, etat_med, date_peremption, medicament.code_f, nom_f FROM medicament, famille where  medicament.code_f = famille.code_f";
		
		// Si un pra code de praticien est précisé, faire une recherche sur ce numéro
		if ( med_depot_legal!= "")
		{
		requete = requete + " AND med_depot_legal= '"+med_depot_legal+"';";			
		}
		//requete = requete + " order by med_depot_legal;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
                        //code_f=new Famille(rs.getInt(1), rs.getString(2));
                        int code_f = rs.getInt(5);
                        String nom_f =rs.getString(6);
			unMed = new Medicament(rs.getString(1),rs.getInt(2),rs.getBoolean(3),rs.getString(4), new Famille(0,nom_f));
			lesMed.add(unMed);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesMed;
	}
        
        
        public static int modifRap(char typeModif, Rapport_visite R) throws SQLException
	{
		
		String requete = null;
		String unMat,uneDate,unBilan,unMotif,unMed;
                boolean unEtatMed;
                int unNum, unPracode, uneOffre, res;
                Rapport_visite unRapport_visite;
                Visiteur unVisiteur;
                Praticien unPraticien;
                Medicament unMedicament;
		
                unNum = R.get_num();
		uneDate = R.get_date();
		unBilan=R.get_bilan();
                unMotif=R.get_motif();
                unEtatMed=R.get_etat();
                uneOffre=R.get_offre();
                unVisiteur=R.get_mat();
                unPraticien=R.get_Pracode();
                unMedicament=R.get_med();
                
                unMat = unVisiteur.get_mat();
                unPracode = unPraticien.get_Pracode();
                unMed = unMedicament.get_med();
                
		switch (typeModif)
		{
		  case 'A' : // Ajouter
			requete = "INSERT INTO rapport_visite(num,date_rapport,bilan,motif,etat_med,off_qte,vis_matricule,pra_code,med_depot_legal)"
                                + "VALUES("+unNum+",'"+uneDate+"','"+unBilan+"','"+unMotif+"',"+unEtatMed+","+uneOffre+",'"+unVisiteur.get_mat()+"',"+unPraticien.get_Pracode()+", '"+unMedicament.get_med()+"');";
			break;
			
		}
		
		System.out.println("Requete : "+requete+" ");
		R.afficher();
	
		
		Bdd laBdd = new Bdd();		
		res = laBdd.modif(requete);		
		return res;
	}
        
        
        public static ArrayList<Rapport_visite> lireRapport(String uneDate_Rapport) throws SQLException
	{
		ArrayList<Rapport_visite> lesRap;
		Rapport_visite unRap;	
		String requete;	
		ResultSet rs  = null;
                
                
                Praticien unPracode;
                unPracode=new Praticien();
                Visiteur matricule;
                matricule=new Visiteur();
                Medicament unMedicament;
                unMedicament = new Medicament();
	
		boolean alire;
		
		lesRap = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT num, date_rapport, bilan, motif, etat_med, off_qte, vis_matricule, pra_code, med_depot_legal FROM rapport_visite"; 
		
		// Si un pra code de praticien est précisé, faire une recherche sur ce numéro
				
		requete = requete + " where  date_rapport like '%"+ uneDate_Rapport+"%'";				
		
		requete = requete + " order by date_rapport;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
                    
                        
                        
			unRap = new Rapport_visite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getInt(6),new Visiteur(rs.getString(7),"","","","","","",""), new Praticien(rs.getInt(8),"","","",""), new Medicament(rs.getString(9),0,false,"",new Famille(0,"")));
			lesRap.add(unRap);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesRap;
	}
        
        
        public static ArrayList<Rapport_visite> chercheRap(int unNum) throws SQLException
	{
		ArrayList<Rapport_visite> lesRap;
		Rapport_visite unRap;	
		String requete;	
		ResultSet rs  = null;
                
                Praticien unPracode;
                unPracode=new Praticien();
                Visiteur matricule;
                matricule=new Visiteur();
                Medicament unMedicament;
                unMedicament = new Medicament();
	
		boolean alire;
		
		lesRap = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT num FROM rapport_visite WHERE num =" +unNum+";";
		
		// Si un pra code de praticien est précisé, faire une recherche sur ce numéro
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		if (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
                        //int code_f = rs.getInt(5);
                        //String nom_f =rs.getString(6);
			//unMed = new Medicament(rs.getString(1),rs.getInt(2),rs.getBoolean(3),rs.getString(4), new Famille(0,nom_f));
                        String unmat = rs.getString(7);
                        int unpra = rs.getInt(8);
                        String unmed = rs.getString(9);
                        
			unRap = new Rapport_visite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getInt(6),new Visiteur(unmat,"","","","","","",""),new Praticien(unpra, "","","",""),new Medicament(unmed,0,false,"",new Famille(0,"")));
			lesRap.add(unRap);
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesRap;
	}
        
        
        public static ArrayList<Rapport_visite> lireRap(int unNumrap) throws SQLException
	{
		ArrayList<Rapport_visite> lesRap;
		Rapport_visite unRap;	
		String requete;	
		ResultSet rs  = null;
                
                Praticien unPracode;
                unPracode=new Praticien();
                Visiteur matricule;
                matricule=new Visiteur();
                Medicament unMedicament;
                unMedicament = new Medicament();
	
		boolean alire;
		
		lesRap = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT num, date_rapport, bilan, motif, etat_med, off_qte, vis_matricule, pra_code, med_depot_legal FROM rapport_visite";
		
		// Si un matricule de Visiteur est précisé, faire une recherche sur ce numéro
		if (unNumrap != 0)
		{
                    requete = requete + " WHERE  num=" + unNumrap;				
		}
		
                System.out.println(requete);
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
                    
                    unPracode=new Praticien(rs.getInt(8),"","","","");
                    
                    matricule=new Visiteur(rs.getString(7),"","","","","","","");
                    
                    
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
			String unmat = rs.getString(7);
                        int unpra = rs.getInt(8);
                        String unmed = rs.getString(9);
                        
			unRap = new Rapport_visite(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getBoolean(5),rs.getInt(6),new Visiteur(unmat,"","","","","","",""),new Praticien(unpra, "","","",""),new Medicament(unmed,0,false,"",new Famille(0,"")));
			lesRap.add(unRap);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesRap;
	}
        
        
        
        public static Visiteur getVisiteur(String matricule) throws SQLException
	{
		Visiteur uneV;	
                uneV = new Visiteur("","","","","","","","");
		String requete;	
		ResultSet rs  = null;
                
                
		boolean alire;
		
                
		// Définition de la requête
		requete = "SELECT vis_matricule FROM visiteur";
		
		// Si un matricule de Visiteur est précisé, faire une recherche sur ce numéro
		if (matricule != "")
		{
                    requete = requete + " WHERE vis_matricule= '"+matricule+"'";
		}
		requete = requete + " order by vis_matricule;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
                        System.out.println("");
			uneV = new Visiteur(rs.getString(1),"","","","","","","");
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
                return uneV;
	
	}
        
        
               static public boolean Connexion(String nom,String mdp) throws SQLException
	{
		
		boolean ligne;	
		String requete;	
		ResultSet rs  = null;
     
		boolean alire;
	
                ligne = false;
                
		// Définition de la requête
		requete = "select vis_matricule,mdp from `visiteur` where vis_matricule = '"+nom+"' and mdp = '"+mdp+"';";
		
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();
		rs = laBdd.lire(requete);
                
                int count=0;
                while(rs.next()){
                    count=count+1;
                }
                
                if(count==1){
                    System.out.println("User trouvé, Connexion réussi !");
                    ligne = true;
                }
                else if(count>1){
                    System.out.println("User dupliqué, Connexion refusé ! !");
                    ligne = false;
                }
                else{
                    System.out.println("User non trouvé");
                    ligne = false;
                }
                return ligne;
                
        }  
        
        
                static public boolean isDelegue(String nom) throws SQLException
	{
		
		boolean ligne;	
		String requete;	
		ResultSet rs  = null;
     
		boolean alire;
	
                ligne = false;
                
		// Définition de la requête
		requete = "select vis_matricule from `visiteur` where vis_matricule = '"+nom+"' and statut ='M'";
		
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();
		rs = laBdd.lire(requete);
                
                int count=0;
                while(rs.next()){
                    count=count+1;
                }
                
                if(count==1){
                    System.out.println("Statut : Medicale -> Bienvenu à vous Visiteur : '"+nom+"'");
                    ligne = true; //Medicale
                }
                else if(count>1){
                    ligne = false;//
                }
                else{
                    System.out.println("Statut : Délégué -> Bienvenu à vous Visiteur : '"+nom+"'");
                    ligne = false;//Delegue
                }
                return ligne;
                
        }    
        
        public static ArrayList<Medicament> lireMedPerim() throws SQLException
	{
		ArrayList<Medicament> lesMed;
		Medicament unMed;	
		String requete;
		ResultSet rs  = null;
                
		boolean alire;
		
		lesMed = new ArrayList<>();

		// Définition de la requête
		requete = "SELECT med_depot_legal, quantite, etat_med, date_peremption, medicament.code_f, nom_f FROM medicament, famille where  medicament.code_f = famille.code_f and date_peremption < CURRENT_DATE()";
	
		// Si un pra code de praticien est précisé, faire une recherche sur ce numéro
      
		//requete = requete + " order by med_depot_legal;";
                
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
                        //code_f=new Famille(rs.getInt(1), rs.getString(2));
                        int code_f = rs.getInt(5);
                        String nom_f =rs.getString(6);
			unMed = new Medicament(rs.getString(1),rs.getInt(2),rs.getBoolean(3),rs.getString(4), new Famille(0,nom_f));
			lesMed.add(unMed);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesMed;
	}
        
        public static ArrayList<Rapport_visite> lireNombreRapport() throws SQLException
	{
		ArrayList<Rapport_visite> lesRap;
		Rapport_visite unRap;	
		String requete;	
		ResultSet rs  = null;
                
                Praticien unPracode;
                unPracode=new Praticien();
                Visiteur matricule;
                matricule=new Visiteur();
                Medicament unMedicament;
                unMedicament = new Medicament();
	
		boolean alire;
		
		lesRap = new ArrayList<>();

		// Définition de la requête
		requete = "select count(rapport_visite.num) AS 'Nombre Rapport', medicament.med_depot_legal From medicament, rapport_visite Where medicament.med_depot_legal = rapport_visite.med_depot_legal GROUP BY medicament.med_depot_legal;";
		
		// Si un matricule de Visiteur est précisé, faire une recherche sur ce numéro
		
                System.out.println(requete);
		// Lire les données dans la base de données
		Bdd laBdd = new Bdd();		
		rs = laBdd.lire(requete);
				
		// Avancer au premier enregistrement
		alire = rs.next();
		
		// Tant qu'il reste au moins un enregistrement à lire
		while (alire==true)
		{
                    
                    unPracode=new Praticien(0,"","","","");
                    matricule=new Visiteur("","","","","","","","");
                    
                    
			// Faire une trace des resultats de la requete SQL				
			//System.out.println("Numero : "+rs.getString(1));
			//System.out.println("Nom : "+rs.getString(2));
			//System.out.println("");
			String unmat = "";
                        int unpra = 0;
                        String unmed = rs.getString(2);
                        
			unRap = new Rapport_visite(rs.getInt(1),"","","",false,0,new Visiteur("","","","","","","",""),new Praticien(0, "","","",""),new Medicament(unmed,0,false,"",new Famille(0,"")));
			lesRap.add(unRap);
			// Aller à l'enregistrement suivant
			alire = rs.next();
		}
		// Fermeture du jeu d'enregistrements
		rs.close();
	
		return lesRap;
	}
                
                
        
         
}

	
	
	
	
	
