package pockerhandkata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pockerhandkata.exceptions.PockerNotValidExeption;
import pockerhandkata.utilities.PockerConstants;

public class PockerDeckTest {

	@Test
	public void blackPlayerEqualToWiteTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("2H 3D 5S AC 7D");
		Hand blackPlayerHand = new Hand("2C 3H 5S AC 7H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.TIE, pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}

	@Test
	public void whitePlayerWinWithHigherCardTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("2C 3H 4S 8C AH");
		Hand blackPlayerHand = new Hand("2H 3D 5S 9C KD");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(
				PockerConstants.WHITE_WINS_WITH + HandTyeEnum.HIGHCARD.getValue() + PockerConstants.SEMICOLON + "A",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));

	}

	@Test
	public void blackPlayerWinWithPairTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("3H 2D 5S 9C KD");
		Hand blackPlayerHand = new Hand("QC QH 4S AC 9H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.BLACK_WINS_WITH + HandTyeEnum.PAIR.getValue(),
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));

	}

	@Test
	public void whitePlayerWinWithPairTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("QC QH 4S AC 9H");
		Hand blackPlayerHand = new Hand("3H 2D 5S 9C KD");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.PAIR.getValue(),
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));

	}

	@Test
	public void blackPlayerWinWithHigherCardTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("2H 3D 5S 9C KD");
		Hand blackPlayerHand = new Hand("2C 3H 4S 8C AH");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(
				PockerConstants.BLACK_WINS_WITH + HandTyeEnum.HIGHCARD.getValue() + PockerConstants.SEMICOLON + "A",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}

	@Test
	public void blackPlayerWinWithTwoPairTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("2H 2D 5S 9C KD");
		Hand blackPlayerHand = new Hand("KC KH 4S AC 4H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.BLACK_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue(),
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));

	}

	@Test
	public void whitePlayerWinWithTwoPairTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("KC KH 4S AC 4H");
		Hand blackPlayerHand = new Hand("2H 2D 5S 9C KD");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue(),
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));

	}

	@Test
	public void blackPlayerWinWithThreeOfAKindTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("KC KH 4S AC 4H");
		Hand blackPlayerHand = new Hand("KC KH 9S AC KH");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.BLACK_WINS_WITH + HandTyeEnum.THREEOFAKIND.getValue(),
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));

	}

	@Test
	public void whitePlayerWinWithThreeOfAKindTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("KC KH 9S AC KH");
		Hand blackPlayerHand = new Hand("KC KH 4S AC 4H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.THREEOFAKIND.getValue(),
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));

	}

	@Test
	public void blackPlayerWinWithStraightTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("KC KH 9S AC KH");
		Hand blackPlayerHand = new Hand("9C TH JS QC KH");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.BLACK_WINS_WITH + HandTyeEnum.STRAIGHT.getValue(),
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));

	}

	@Test
	public void whitePlayerWinWithStraightTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("9C TH JS QC KH");
		Hand blackPlayerHand = new Hand("KC KH 9S AC KH");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.STRAIGHT.getValue(),
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}

	@Test
	public void whitePlayerWinWithBothWhiteAndBlackPairTest() throws PockerNotValidExeption {

		Hand whitePlayerHand = new Hand("KC KH 8S 9C 2H");
		Hand blackPlayerHand = new Hand("2C 7H 9S AC 2H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.PAIR.getValue() + PockerConstants.SEMICOLON + "K",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}
	
	@Test
	public void blackPlayerWinWithWhiteAndBlackBothPairTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("KC KH 2S 9C 3H");
		Hand blackPlayerHand = new Hand("KC KH 8S AC 2H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.BLACK_WINS_WITH + HandTyeEnum.PAIR.getValue() + PockerConstants.SEMICOLON + "A",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}
	
	@Test
	public void blackPlayerWinWithWhiteAndBlackBothTwoPairsTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("KC KH 2S 2C 3H");
		Hand blackPlayerHand = new Hand("KC KH 8S AC 8H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.BLACK_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue() + PockerConstants.SEMICOLON + "8",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}
	
	@Test
	public void withePlayerWinWithWhiteAndBlackBothThreeOfAKindTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("AC KH AS AC 3H");
		Hand blackPlayerHand = new Hand("KC KH KS AC 8H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.THREEOFAKIND.getValue() + PockerConstants.SEMICOLON + "A",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}
	
	@Test
	public void withePlayerWinWithWhiteAndBlackBothFourOfAKindTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("KC KH KS AC KH");
		Hand blackPlayerHand = new Hand("QC KH QS QC QH");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.FOUROFAKIND.getValue() + PockerConstants.SEMICOLON + "K",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}
	
	@Test
	public void withePlayerWinWithWhiteAndBlackBothFullHouseTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("KC KH KS AC AH");
		Hand blackPlayerHand = new Hand("QC TH QS QC TH");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.FULLHOUSE.getValue() + PockerConstants.SEMICOLON + "K",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}
	
	@Test
	public void withePlayerWinWithWhiteAndBlackBothStrightTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("TC JH QS KC AH");
		Hand blackPlayerHand = new Hand("2C 3H 4S 5C 6H");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.STRAIGHT.getValue() + PockerConstants.SEMICOLON + "A",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}
	
	@Test
	public void withePlayerWinWithWhiteAndBlackBothFlushTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("TC 2C QC KC AC");
		Hand blackPlayerHand = new Hand("2S 5S 4S QS 6S");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.FLUSH.getValue() + PockerConstants.SEMICOLON + "A",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}
	
	@Test
	public void withePlayerWinWithWhiteAndBlackBothStrightFlushTest() throws PockerNotValidExeption {
		Hand whitePlayerHand = new Hand("TC JC QC KC AC");
		Hand blackPlayerHand = new Hand("2S 3S 4S 5S 6S");
		PockerDeck pockerDeck = new PockerDeck();
		assertEquals(PockerConstants.WHITE_WINS_WITH + HandTyeEnum.STRAIGHTFLUSH.getValue() + PockerConstants.SEMICOLON + "A",
				pockerDeck.compareHands(whitePlayerHand, blackPlayerHand));
	}

}
