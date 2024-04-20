package modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

public class TriInsertion {

	public void traitement(char[] anagramme, int taille_anagramme) {
		for (int i = 0; i < taille_anagramme; i++) {
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
		try {
			lecture();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String retireAccent(String text) {
		String res = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return res;
	}

	public String anagramme(String text) {
		int taille_anagramme = text.length();
		String textSansAccent = retireAccent(text);
		String textSansMaj = textSansAccent.toLowerCase();
		char[] anagramme = textSansMaj.toCharArray();
		traitement(anagramme, taille_anagramme);
		String res = new String(anagramme);
		return res;

	}

	public static void main(String[] args) {
		TriInsertion t = new TriInsertion();
		t.anagrammeLu();
		//System.out.println(Integer.MAX_VALUE);
	}

}