package pockerhandkata;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;
import pockerhandkata.exceptions.PockerNotValidExeption;

@Data
public class Hand {

	Card[] pockerHand = new Card[5];

	public Hand(String hand) throws PockerNotValidExeption {
		if (hand == null || hand.isEmpty()) {
			throw new PockerNotValidExeption("The hand cant be empty or null");
		}
		String[] cardArray = hand.split(" ");
		if (cardArray.length != 5) {
			throw new PockerNotValidExeption("The hand is not valid");
		}
		for (int i = 0; i < 5; i++) {
			pockerHand[i] = new Card(cardArray[i]);
		}

	}

	public HandTyeEnum getHandTye() throws PockerNotValidExeption {
		if (isStraitFlush())
			return HandTyeEnum.STRAIGHTFLUSH;
		if (isStraight())
			return HandTyeEnum.STRAIGHT;
		if (isFlush())
			return HandTyeEnum.FLUSH;
		if (isFourOfKind())
			return HandTyeEnum.FOUROFAKIND;
		if (isFullHouse())
			return HandTyeEnum.FULLHOUSE;
		if (isPair())
			return HandTyeEnum.PAIR;
		if (isTwoPair())
			return HandTyeEnum.TWOPAIRS;
		if (isThreeOfAKind())
			return HandTyeEnum.THREEOFAKIND;
		if (isHighCard())
			return HandTyeEnum.HIGHCARD;
		return null;
	}

	public boolean isHighCard() throws PockerNotValidExeption {
		return !(isPair() || isTwoPair() || isThreeOfAKind() || isStraight() || isFlush() || isFlush() || isFullHouse()
				|| isFourOfKind() || isStraitFlush());
	}

	public boolean isPair() {
		List<Integer> sortedRank = Arrays.asList(pockerHand).stream().map(c -> c.getRank()).sorted()
				.collect(Collectors.toList());
		Map<Integer, Long> rankMap = sortedRank.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return rankMap.values().contains(2L) && rankMap.entrySet().size() == 4;
	}

	public boolean isTwoPair() {
		List<Integer> sortedRank = Arrays.asList(pockerHand).stream().map(c -> c.getRank()).sorted()
				.collect(Collectors.toList());
		Map<Integer, Long> rankMap = sortedRank.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return rankMap.values().contains(2L) && rankMap.entrySet().size() == 3;
	}

	public boolean isThreeOfAKind() {
		List<Integer> sortedRank = Arrays.asList(pockerHand).stream().map(c -> c.getRank()).sorted()
				.collect(Collectors.toList());
		Map<Integer, Long> rankMap = sortedRank.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return rankMap.values().contains(3L);
	}

	public boolean isStraight() {
		List<Integer> sortedRank = Arrays.asList(pockerHand).stream().map(c -> c.getRank()).sorted()
				.collect(Collectors.toList());
		for (int i = 1; i < sortedRank.size(); i++) {
			if (sortedRank.get(i) != sortedRank.get(i - 1) + 1) {
				return false;
			}
		}

		return true;
	}

	public boolean isFlush() {
		return Arrays.asList(pockerHand).stream().map(c -> {
			try {
				return c.suit();
			} catch (PockerNotValidExeption e) {
				e.printStackTrace();
			}
			return null;
		}).collect(Collectors.toSet()).size() == 1;
	}

	public boolean isFullHouse() {
		List<Integer> sortedRank = Arrays.asList(pockerHand).stream().map(c -> c.getRank()).sorted()
				.collect(Collectors.toList());
		Map<Integer, Long> rankMap = sortedRank.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return rankMap.values().contains(3L) && rankMap.values().contains(2L);
	}

	public boolean isFourOfKind() {
		List<Integer> sortedRank = Arrays.asList(pockerHand).stream().map(c -> c.getRank()).sorted()
				.collect(Collectors.toList());
		Map<Integer, Long> rankMap = sortedRank.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
		return rankMap.values().contains(4L);
	}

	public boolean isStraitFlush() throws PockerNotValidExeption {
		return isStraight() && isFlush();
	}

	public boolean isEquals(Hand otherHand) {
		List<Integer> sortedRank = Arrays.asList(pockerHand).stream().map(c -> c.getRank()).sorted()
				.collect(Collectors.toList());
		List<Integer> sortedRankOtherhand = Arrays.asList(otherHand.getPockerHand()).stream().map(c -> c.getRank())
				.sorted().collect(Collectors.toList());
		return new HashSet<>(sortedRank).equals(new HashSet<>(sortedRankOtherhand));
	}

}
