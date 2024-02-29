package modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriInsertion {

	public void traitement(char[] anagramme, int taille_anagramme) {
		for (int i = 0; i < taille_anagramme - 1; i++) {
			char car = anagramme[i];
			int j = i;
			while ((j > 0) && (car < anagramme[j - 1])) {
				anagramme[j] = anagramme[j - 1];
				j--;
			}
			anagramme[j] = car;
		}
	}

	public String lecture() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String text = br.readLine();
		return text;
	}

	public void anagrammeLu() {
		String text;
		try {
			text = lecture();
			anagramme(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void anagramme(String text) {
		System.out.println(text);
		int taille_anagramme = text.length();
		char[] anagramme = text.toCharArray();
		traitement(anagramme, taille_anagramme);
		System.out.println(anagramme);

	}

	public static void main(String[] args) {
		TriInsertion t = new TriInsertion();
		t.anagrammeLu();
	}

}