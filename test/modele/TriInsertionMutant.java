package modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class TriInsertionMutant {

	public String anagrammeM1(String text) {
		int taille_anagramme = text.length();
		String textSansAccent = Normalizer.normalize(text, Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		String textSansMaj = textSansAccent.toLowerCase();
		char[] anagramme = textSansMaj.toCharArray();
		for (int i = 0; i < taille_anagramme; i++) {
			char car = anagramme[i];
			int j = i;
			while ((j > 0) || (car < anagramme[j - 1])) { //Mutant ||
				anagramme[j] = anagramme[j - 1];
				j--;
			}
			anagramme[j] = car;
		}
		String res = new String(anagramme);
		return res;

	}

	public String anagrammeM2(String text) {
		int taille_anagramme = text.length();
		String textSansAccent = Normalizer.normalize(text, Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		String textSansMaj = textSansAccent.toLowerCase();
		char[] anagramme = textSansMaj.toCharArray();
		for (int i = 0; i < taille_anagramme; i++) {
			char car = anagramme[i];
			int j = i;
			while ((j > 0) && (car <= anagramme[j - 1])) { //Mutant <=
				anagramme[j] = anagramme[j - 1];
				j--;
			}
			anagramme[j] = car;
		}
		String res = new String(anagramme);
		return res;

	}

	public String anagrammeM3(String text) {
		int taille_anagramme = text.length();
		String textSansAccent = Normalizer.normalize(text, Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		String textSansMaj = textSansAccent.toLowerCase();
		char[] anagramme = textSansMaj.toCharArray();
		for (int i = 0; i < taille_anagramme; i++) {
			char car = anagramme[i];
			int j = i;
			while ((j > 0) && (car < anagramme[j - 1])) {
				anagramme[j] = anagramme[j - 1];
				j++; //Mutant ++
			}
			anagramme[j] = car;
		}
		String res = new String(anagramme);
		return res;

	}

	public String anagrammeM4(String text) {
		int taille_anagramme = text.length();
		String textSansAccent = Normalizer.normalize(text, Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		String textSansMaj = textSansAccent.toLowerCase();
		char[] anagramme = textSansMaj.toCharArray();
		for (int i = 0; i < taille_anagramme; i++) {
			char car = anagramme[i];
			int j = i;
			while ((j > 0) && (car < anagramme[j + 1])) { //Mutant +
				anagramme[j] = anagramme[j + 1]; //Mutant +
				j--;
			}
			anagramme[j] = car;
		}
		String res = new String(anagramme);
		return res;

	}

	private List<String[]> motTest(String nomFichier) {
		List<String[]> pairTest = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(" ");
				if (parts.length == 2) {
					pairTest.add(parts);
				} else {
					System.out.println("Format de ligne incorrect: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pairTest;
	}

	private void affResultat(String input, String outputAttendu, String outputFonction, String resultatCouleur) {
		System.out.println("Le test avec comme entree : " + input + " doit donner : " + outputAttendu + " et donne : "
				+ outputFonction + " : " + resultatCouleur);
	}

	private void resultat(String input, String outputAttendu, String outputFonction) {
		String RESET = "\033[0m";
		String GREEN = "\033[0;32m";
		String RED = "\033[0;31m";
		String messageReussi = GREEN + "PASS" + RESET;
		String messageRate = RED + "FAIL" + RESET;
		if (outputAttendu.equals(outputFonction)) {
			affResultat(input, outputAttendu, outputFonction, messageReussi);
		} else {
			affResultat(input, outputAttendu, outputFonction, messageRate);
		}
	}

	public void testGeneral(Function<String, String> fonction) {
		List<String[]> pairTest = motTest("test.txt");
		for (String[] strings : pairTest) {
			String input = strings[0];
			String outputAttendu = strings[1];
			try {
				String outputFonction = fonction.apply(input);
				resultat(input, outputAttendu, outputFonction);
			} catch (Exception e) {
				resultat(input, outputAttendu, null);
			}
		}
	}
}
