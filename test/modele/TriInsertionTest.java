package modele;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

class TriInsertionTest {
	private TriInsertion t = new TriInsertion();

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

	private void resultat(String input,String outputAttendu,String outputFonction) {
		String RESET = "\033[0m"; 
		String GREEN = "\033[0;32m";
		String RED = "\033[0;31m";
		String messageReussi = GREEN+"PASS"+RESET;
		String messageRate = RED+"FAIL"+RESET;
		if (outputAttendu.equals(outputFonction)) {
			affResultat(input, outputAttendu, outputFonction, messageReussi);
		} else {
			affResultat(input, outputAttendu, outputFonction, messageRate);
		}
	}
	
	private void testGeneral(Function<String,String> fonction) {
		List<String[]> pairTest = motTest("test.txt");
		for (String[] strings : pairTest) {
			String input = strings[0];
			String outputAttendu = strings[1];
			String outputFonction = fonction.apply(input);
			resultat(input, outputAttendu, outputFonction);
		}
	}
	
	@Test
	void testFonctionNormal() {
		//TriInsertion t = new TriInsertion();
		testGeneral(t::anagramme);
	}


}
