package pockerhandkata;

import lombok.Data;
import pockerhandkata.exceptions.PockerNotValidExeption;

@Data
public class Card {
	private String card;

	public Card(String card) throws PockerNotValidExeption {
		if (card == null || card.isEmpty()) {
			throw new PockerNotValidExeption("The card cant be empty or null");
		}
		if (card.length() !=2) {
			throw new PockerNotValidExeption("The lenght of card is not valid");
		}
		
		this.card = card;
	}

	public String suit() throws PockerNotValidExeption {
		if (!(new String("CDHScdhs").contains(Character.toString(card.charAt(1)))))
			throw new PockerNotValidExeption("Invalid Suite");
		return Character.toString(card.charAt(1));
	}

	public String value() {
		return Character.toString(card.charAt(0));
	}

	public int getRank() {
		switch (card.charAt(0)) {
		case '2':
			return 2;
		case '3':
			return 3;
		case '4':
			return 4;
		case '5':
			return 5;
		case '6':
			return 6;
		case '7':
			return 7;
		case '8':
			return 8;
		case '9':
			return 9;
		case 'T':
			return 10;

		case 'J':
			return 11;
		case 'Q':
			return 12;
		case 'K':
			return 13;
		case 'A':
			return 14;

		default:
			return 0;
		}
	}

}
