package pockerhandkata;

public enum HandTyeEnum {

	STRAIGHTFLUSH("Straight flush", 9), STRAIGHT("Straight", 5), FLUSH("flush", 6), FOUROFAKIND("Four of a kind", 8),
	FULLHOUSE("Full House", 7), THREEOFAKIND("Three of a Kind", 4), TWOPAIRS("Two Pairs", 3), PAIR("Pair", 2),
	HIGHCARD("High Card", 1)

	;

	public int getRank() {
		return rank;
	}

	HandTyeEnum(String value, int rank) {
		this.value = value;
		this.rank = rank;
	}

	private String value;
	private int rank;

	public String getValue() {
		return value;
	}

}
