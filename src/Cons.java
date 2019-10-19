// classe Cons : saisies au clavier

import java.io.*;

public class Cons {

	public	static int saisirEntier() throws IOException{
	
		InputStreamReader lecteur = new InputStreamReader(System.in);
		BufferedReader entree = new BufferedReader(lecteur);
	
		String texte;
		Integer x;
                x=new Integer(0);
		boolean saisie_ok = false;
                while (saisie_ok == false) 
                {
                    try {
                        texte = entree.readLine();
                        x=new Integer(texte);
                        saisie_ok = true;
                        }
                    catch (Exception e) {
                        System.out.println("Vous n'avez pas saisi un entier ");
                    }
		}	
		return(x.intValue());		
	} 

	public	static float saisirReel() throws IOException{
	
		InputStreamReader lecteur = new InputStreamReader(System.in);
		BufferedReader entree = new BufferedReader(lecteur);
	
		String texte;
		Float x;
                x=new Float(0);
		boolean saisie_ok = false;
                while (saisie_ok == false) 
                {
                    try {
                        texte = entree.readLine();
                        x=new Float(texte);
                        saisie_ok = true;
                        }
                    catch (Exception e) {
                        System.out.println("Vous n'avez pas saisi un entier ou un réèl ");
                    }
		}	
		return(x.floatValue());	
	}

	public	static String saisirChaine() throws IOException{
	
		InputStreamReader lecteur = new InputStreamReader(System.in);
		BufferedReader entree = new BufferedReader(lecteur);
	
		String texte;
		Float x;
		
		texte = entree.readLine();
		
		return(texte);	
	} 
}