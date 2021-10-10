package pockerhandkata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pockerhandkata.exceptions.PockerNotValidExeption;

public class HandTest {
	
	

	@Test
	public void isPairTest() throws PockerNotValidExeption {
		Hand hand = new Hand("7D AD TS 7H 8D");
		assertTrue(hand.isPair());
	}

	@Test
	public void isNotPairTest() throws PockerNotValidExeption {
		Hand hand = new Hand("4D AD TS 7H 8D");
		assertFalse(hand.isPair());
	}

	@Test
	public void isTwoPairsTest() throws PockerNotValidExeption {
		Hand hand = new Hand("7D AD 7S AH 8D");
		assertTrue(hand.isTwoPair());
	}

	@Test
	public void isNotTwoPairsTest() throws PockerNotValidExeption {
		Hand hand = new Hand("7D AD TS 7H 8D");
		assertFalse(hand.isTwoPair());
	}

	@Test
	public void isThreeOfAKindTest() throws PockerNotValidExeption {
		Hand hand = new Hand("8D AD 8S 7H 8D");
		assertTrue(hand.isThreeOfAKind());
	}

	@Test
	public void isNotThreeOfAKindTest() throws PockerNotValidExeption {
		Hand hand = new Hand("7D AD 8S 7H 8D");
		assertFalse(hand.isThreeOfAKind());
	}

	@Test
	public void isStraightTest() throws PockerNotValidExeption {
		Hand hand = new Hand("2D 3C 4D 5D 6D");
		assertTrue(hand.isStraight());
	}

	@Test
	public void isNotStraightTest() throws PockerNotValidExeption {
		Hand hand = new Hand("2D 3C 4D 5D 7D");
		assertFalse(hand.isStraight());
	}

	@Test
	public void isFlushTest() throws PockerNotValidExeption {
		Hand hand = new Hand("2D AD 4D 5D 6D");
		assertTrue(hand.isFlush());
	}

	@Test
	public void isNotFlushTest() throws PockerNotValidExeption {
		Hand hand = new Hand("2D AD 4D 5D 6C");
		assertFalse(hand.isFlush());
	}

	@Test
	public void isFullHouseTest() throws PockerNotValidExeption {
		Hand hand = new Hand("TD AD TD AD TD");
		assertTrue(hand.isFullHouse());
	}

	@Test
	public void isNotFullHouseTest() throws PockerNotValidExeption {
		Hand hand = new Hand("TD AD TD AD 9D");
		assertFalse(hand.isFullHouse());
	}

	@Test
	public void isFourOfAkindTest() throws PockerNotValidExeption {
		Hand hand = new Hand("8D AD 8S 8H 8D");
		assertTrue(hand.isFourOfKind());
	}

	@Test
	public void isNotFourOfAkindTest() throws PockerNotValidExeption {
		Hand hand = new Hand("AD AH 8S 8H 8D");
		assertFalse(hand.isFourOfKind());
	}

	@Test
	public void isStraightFlushTest() throws PockerNotValidExeption {
		Hand hand = new Hand("2D 3D 4D 5D 6D");
		assertTrue(hand.isStraitFlush());
	}

	@Test
	public void isNotStraightFlushTest() throws PockerNotValidExeption {
		Hand hand = new Hand("2D 3D 4D 5D 6S");
		assertFalse(hand.isStraitFlush());
	}

	@Test
	public void notValidSixCardsInAHandTest() throws PockerNotValidExeption {

		PockerNotValidExeption pockerNotValidExeption = assertThrows(PockerNotValidExeption.class, () -> {
			new Hand("2D 3D 4D 5D 6D 4R");
		});

		String expectedMessage = "The hand is not valid";
		String actualMessage = pockerNotValidExeption.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void notValidThreeCardsInAHandTest() throws PockerNotValidExeption {

		PockerNotValidExeption pockerNotValidExeption = assertThrows(PockerNotValidExeption.class, () -> {
			new Hand("2D 3D 4D 5D");
		});

		String expectedMessage = "The hand is not valid";
		String actualMessage = pockerNotValidExeption.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	public void isEqualsTest() throws PockerNotValidExeption {
		Hand hand = new Hand("AD AH 8S 8H 9D");
		Hand otherhand = new Hand("AC AD 8S 8H 9D");
		assertTrue(hand.isEquals(otherhand));
	}
	
	@Test
	public void isNotEqualsTest() throws PockerNotValidExeption {
		Hand hand = new Hand("7D AH 8S 8H 9D");
		Hand otherhand = new Hand("AC AD 8S 8H 9D");
		assertFalse(hand.isEquals(otherhand));
	}
	
	@Test
	public void isHighCardTest() throws PockerNotValidExeption {
		Hand hand = new Hand("7D AD KS 2H 8D");
		assertTrue(hand.isHighCard());
	}
	
	@Test
	public void isNotHighCardTest() throws PockerNotValidExeption {
		Hand hand = new Hand("7D AD KS 2H KD");
		assertFalse(hand.isHighCard());
	}


}
