package pockerhandkata;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pockerhandkata.exceptions.PockerNotValidExeption;

public class CardTest {

	@Test
	public void clubSuiteTest() throws PockerNotValidExeption {
		Card card = new Card("2C");
		Card card2 = new Card("TC");
		assertEquals("C", card.suit());
		assertEquals("C", card2.suit());
	}
	
	@Test
	public void notValidEmptyCardTest() throws PockerNotValidExeption {
		PockerNotValidExeption pockerNotValidExeption = assertThrows(PockerNotValidExeption.class, () -> {
			 new Card("");
		});
		String expectedMessage = "The card cant be empty or null";
		String actualMessage = pockerNotValidExeption.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void lenghtCardNotValidTest() throws PockerNotValidExeption {
		PockerNotValidExeption pockerNotValidExeption = assertThrows(PockerNotValidExeption.class, () -> {
			 new Card("4RT");
		});
		String expectedMessage = "The lenght of card is not valid";
		String actualMessage = pockerNotValidExeption.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void notValidNullCardTest() throws PockerNotValidExeption {
		PockerNotValidExeption pockerNotValidExeption = assertThrows(PockerNotValidExeption.class, () -> {
			 new Card(null);
		});
		String expectedMessage = "The card cant be empty or null";
		String actualMessage = pockerNotValidExeption.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void diamondSuiteTest() throws PockerNotValidExeption {
		Card card = new Card("KD");
		assertEquals("D", card.suit());
	}

	@Test
	public void heartSuiteTest() throws PockerNotValidExeption {
		Card card = new Card("AH");
		assertEquals("H", card.suit());
	}

	@Test
	public void spadSuiteTest() throws PockerNotValidExeption {
		Card card = new Card("AS");
		assertEquals("S", card.suit());
	}
	
	@Test
	public void unknownSuiteTest() throws PockerNotValidExeption {
		Card card = new Card("AY");
		
		PockerNotValidExeption pockerNotValidExeption = assertThrows(PockerNotValidExeption.class, () -> {
			card.suit();
		});
		String expectedMessage = "Invalid Suite";
		String actualMessage = pockerNotValidExeption.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	public void unknownSuiteWithTenTest() throws PockerNotValidExeption {
		Card card = new Card("TY");
		
		PockerNotValidExeption pockerNotValidExeption = assertThrows(PockerNotValidExeption.class, () -> {
			card.suit();
		});
		String expectedMessage = "Invalid Suite";
		String actualMessage = pockerNotValidExeption.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void twoValueTest() throws PockerNotValidExeption {
		Card card = new Card("2D");
		assertEquals("2", card.value());
	}

	@Test
	public void jackValueTest() throws PockerNotValidExeption {
		Card card = new Card("JD");
		assertEquals("J", card.value());
	}

	@Test
	public void queenValueTest() throws PockerNotValidExeption {
		Card card = new Card("QD");
		assertEquals("Q", card.value());
	}

	@Test
	public void kingValueTest() throws PockerNotValidExeption {
		Card card = new Card("KD");
		assertEquals("K", card.value());
	}

	@Test
	public void aceValueTest() throws PockerNotValidExeption {
		Card card = new Card("AD");
		assertEquals("A", card.value());
	}

	@Test
	public void twoRankTest() throws PockerNotValidExeption {
		Card card = new Card("2D");
		assertEquals(2, card.getRank());
	}

	@Test
	public void tenRankTest() throws PockerNotValidExeption {
		Card card = new Card("TD");
		assertEquals(10, card.getRank());
	}

	@Test
	public void jackRankTest() throws PockerNotValidExeption {
		Card card = new Card("JD");
		assertEquals(11, card.getRank());
	}

	@Test
	public void queenRankTest() throws PockerNotValidExeption {
		Card card = new Card("QD");
		assertEquals(12, card.getRank());
	}

	@Test
	public void kingRankTest() throws PockerNotValidExeption {
		Card card = new Card("KD");
		assertEquals(13, card.getRank());
	}

	@Test
	public void aceRankTest() throws PockerNotValidExeption {
		Card card = new Card("AD");
		assertEquals(14, card.getRank());
	}

	@Test
	public void unknownRankTest() throws PockerNotValidExeption {
		Card card = new Card("XD");
		assertEquals(0, card.getRank());
	}

}
