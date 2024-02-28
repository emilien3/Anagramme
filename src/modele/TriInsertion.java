package modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriInsertion {
	
	public static void traitement (char [] anagramme, int taille_anagramme) {
        /* boucle de traitement */
		for (int i = 0; i < taille_anagramme-1; i++) {
			char car = anagramme [i];
			int j = i;
			while ((j>0) && (car< anagramme[j-1])) {
				anagramme [j] = anagramme [j-1];
				j = -1;
			}
            anagramme[j] = car ;
         }
	}

 	public static void anagramme() {
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
		try {
			String text = br.readLine();
			System.out.println(text);
			int taille = text.length();
			int taille_anagramme = 0;
			char[] anagramme = text.toCharArray();
			while (taille > taille_anagramme) {
				traitement(anagramme,taille_anagramme);
				taille_anagramme++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 	
 	
 	public static void main(String[] args) {
 		anagramme();
 	}
 	
 	
}