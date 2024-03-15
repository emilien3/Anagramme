package modele;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Normalizer;

public class TriInsertion {

	public char[] triInsertion(char[] anagramme) {
		for (int i = 1; i < anagramme.length; i++) {
			char car = anagramme[i];
			int j = i-1;
			while ((j >= 0) && (car < anagramme[j])) {
				anagramme[j+1] = anagramme[j];
				j--;
			}
			anagramme[j+1] = car;
		}
		return anagramme;
	}

	public String lecture() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String text = br.readLine();
		return text;
	}
	
	public String retireAccent(String text) {
		String res = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		return res;
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
		char[] anagramme = text.toCharArray();
		triInsertion(anagramme);
		System.out.println(anagramme);

	}

	public static void main(String[] args) {
		TriInsertion t = new TriInsertion();
		t.anagrammeLu();
		
		boolean test ='a' > 'A';
		
		System.out.println(test);
	
	}

}