package modele;

public class MainTest {
	
	public static void main(String[] args) {
		TriInsertion t = new TriInsertion();
		TriInsertionMutant tm = new TriInsertionMutant();

		System.out.println("TEST FONCTIONNELLE :");
		tm.testGeneral(t::anagramme);
		
		System.out.println("\n\n\nTEST MUTANT1 :");
		tm.testGeneral(tm::anagrammeM1);
		
		System.out.println("\n\n\nTEST MUTANT2 :");
		tm.testGeneral(tm::anagrammeM2);
		
		System.out.println("\n\n\nTEST MUTANT3 :");
		tm.testGeneral(tm::anagrammeM3);
		
		System.out.println("\n\n\nTEST MUTANT4 :");
		tm.testGeneral(tm::anagrammeM4);
		}
}
