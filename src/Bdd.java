/**
 * @(#)Bdd.java
 *
 *
 * @author 
 * @version 1.00 2015/03/09
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


class Bdd
{
	Connection connection;
	String nom; // Nom de la base

	public Bdd()
	{
		 connection = null;
		 nom="gsbjava";
			
	}

	// Connexion � la base de donnees
	private Connection ouvrir () 
	{
    	try
        {
			// Chargement des drivers SQL
			Class.forName ("org.gjt.mm.mysql.Driver").newInstance();
		}
		catch (ClassNotFoundException a)
		{
			System.out.println ("Driver non trouve");
		}
		catch (Exception b)
		{      
			System.out.println ("Probleme de chargement de driver");			
		}

		try
        {		
			// Etablissement de la connexion avec la base
			connection = DriverManager.getConnection ("jdbc:mysql://localhost/"+nom, "root", "");
		}
		catch (SQLException c)
		{	
			System.out.println ("Connexion refusee ou base inconnue");
		}
		catch (Exception d)
		{
			System.out.println ("Probleme de connexion");		
		}
		return connection;
	}


	// Fermer la connexion � la base
	private void fermer()
	{
		try
		{
			// Fermeture de la connexion
			connection.close();
		}
		catch (Exception d)
		{
			System.out.println ("Problème à la fermeture de la connexion");	
		}
	}
	
	// Obtenir le ResultSet correspondant
	// � la requete pass�e en param�tre
	public ResultSet lire(String requete) throws SQLException
	{
		Connection cnx;		
		ResultSet rs  = null;
	
		// Ouverture d'une connexion � la base
		cnx = ouvrir();
		
		// Si la connexion � r�ussi
		if (cnx!=null)
		{			
			// Cr�ation d'un objet de classe Statement permettant
			// de transmettre une requ�te � la base
			Statement stmt = cnx.createStatement();
								
			// Ex�cution de la requete et r�cup�ration 
			// du r�sultat dans un jeu d'enregistrements
			rs = stmt.executeQuery(requete);
		
			// fermeture de la connexion
			// laBdd.fermer();
		}
		return rs;
	}
	

	// M�thode modif
	// Param�tre : requ�te de modification (Insert, Update ou Delete)
	// Valeur retourn�e : 1 si modification effectu�e, 0 sinon
	
	public int modif(String requete) throws SQLException
	{
		Connection cnx;
		int res;
		
		res = 0;		

		// Ouverture d'une connexion � la base
		cnx = ouvrir();

		// Si la connexion a r�ussi
		if (cnx!=null)
		{
			// Cr�ation d'un objet de classe Statement permettant
			// de transmettre une requ�te � la base
			Statement stmt = cnx.createStatement();	
		
			// Trace de la requete
			// System.out.println("Requete : "+requete);
			
			// Ex�cution de la requete 
			try {
				res = stmt.executeUpdate(requete);
			    }
			catch (Exception e) {
				// Probl�mes tels que :
				// - valeur de cl� primaire d�ja existante
			    // System.out.println("Probl�me d'ex�cution !");
			    //affichage de la pile d'exceptions :
			    // e.printStackTrace();
				}
		
			// fermeture de la connexion
			fermer();
		}		
		return res;	
	}	

	
}