package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriInsertionTest {
	
		TriInsertion T = new TriInsertion();
	

	    @Test
	    public void testAnagrammeAvecLettresMinuscules() {
	        assertEquals("acdeil", T.triInsertion("decila".toCharArray()));
	    }

	    @Test
	    public void testAnagrammeAvecLettresMajuscules() {
	        assertEquals("acdeil", T.triInsertion("DECILA".toCharArray()));
	    }

	    @Test
	    public void testAnagrammeAvecLettresMinusculesEtMajuscules() {
	        assertEquals("acdeil", T.triInsertion("DeCiLa".toCharArray()));
	    }

	    @Test
	    public void testAnagrammeAvecChaineVide() {
	        assertEquals("", T.triInsertion("".toCharArray()));
	    }

	    @Test
	    public void testAnagrammeAvecCaracteresNonAlphabetiques() {
	        assertEquals("!$%&", T.triInsertion("!$%&".toCharArray()));
	    }

	    @Test
	    public void testAnagrammeAvecUneSeuleLettre() {
	        assertEquals("a",T.triInsertion("a".toCharArray()));
	    }

	    @Test
	    public void testAnagrammeAvecToutesLettresIdentiques() {
	        assertEquals("aaaa", T.triInsertion("aaaa".toCharArray()));
	    }

	    @Test
	    public void testAnagrammeAvecLettresDejaOrdonnees() {
	        assertEquals("abcd", T.triInsertion("abcd".toCharArray()));
	    }

}
