package pockerhandkata;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pockerhandkata.exceptions.PockerNotValidExeption;
import pockerhandkata.utilities.PockerConstants;

public class PockerDeck {

	public String compareHands(Hand whitePlayerHand, Hand blackPlayerHand) throws PockerNotValidExeption {
		String winner = null;
		if (whitePlayerHand.isEquals(blackPlayerHand)) {
			return PockerConstants.TIE;
		} else {
			if (whitePlayerHand.getHandTye().getRank() > blackPlayerHand.getHandTye().getRank()) {
				winner = PockerConstants.WHITE_WINS_WITH + whitePlayerHand.getHandTye().getValue();
			} else if (whitePlayerHand.getHandTye().getRank() < blackPlayerHand.getHandTye().getRank()) {
				winner = PockerConstants.BLACK_WINS_WITH + blackPlayerHand.getHandTye().getValue();
			} else {
				winner = compareHandWithSameRank(whitePlayerHand, blackPlayerHand);
			}
		}
		return winner;
	}

	private String compareHandWithSameRank(Hand whitePlayerHand, Hand blackPlayerHand) throws PockerNotValidExeption {
		String winner = null;
		List<Card> whiteHandasList = Arrays.asList(whitePlayerHand.getPockerHand());
		List<Card> blackHandasList = Arrays.asList(blackPlayerHand.getPockerHand());
		List<Card> sortedWhiteHand = whiteHandasList.stream().sorted(Comparator.comparingInt(Card::getRank).reversed())
				.collect(Collectors.toList());
		List<Card> sortedBlackHand = Arrays.asList(blackPlayerHand.getPockerHand()).stream()
				.sorted(Comparator.comparingInt(Card::getRank).reversed()).collect(Collectors.toList());
		switch (whitePlayerHand.getHandTye()) {
		case HIGHCARD:

			winner = comparePlayerWithSameHighCardAndFlushRank(winner, sortedWhiteHand, sortedBlackHand,
					HandTyeEnum.HIGHCARD.getValue());
			break;
		case PAIR:
			winner = comparePlayerWithSameRank(winner, whiteHandasList, blackHandasList, sortedWhiteHand,
					sortedBlackHand, HandTyeEnum.PAIR.getValue());
			break;
		case TWOPAIRS:
			winner = comparePlayerWithSameTwoPairsRank(sortedWhiteHand, sortedBlackHand);
			break;
		case THREEOFAKIND:
			winner = comparePlayerWithSameRank(winner, whiteHandasList, blackHandasList, sortedWhiteHand,
					sortedBlackHand, HandTyeEnum.THREEOFAKIND.getValue());
			break;
		case FOUROFAKIND:
			winner = comparePlayerWithSameRank(winner, whiteHandasList, blackHandasList, sortedWhiteHand,
					sortedBlackHand, HandTyeEnum.FOUROFAKIND.getValue());
			break;
		case FULLHOUSE:
			winner = comparePlayerWithSameRank(winner, whiteHandasList, blackHandasList, sortedWhiteHand,
					sortedBlackHand, HandTyeEnum.FULLHOUSE.getValue());
			break;
		case STRAIGHT:
			winner = comparePlayerWithSameFlushAndStrightFlushRank(sortedWhiteHand, sortedBlackHand,
					HandTyeEnum.STRAIGHT.getValue());

			break;
		case FLUSH:
			winner = comparePlayerWithSameHighCardAndFlushRank(winner, sortedWhiteHand, sortedBlackHand,
					HandTyeEnum.FLUSH.getValue());
			break;
		case STRAIGHTFLUSH:
			winner = comparePlayerWithSameFlushAndStrightFlushRank(sortedWhiteHand, sortedBlackHand,
					HandTyeEnum.STRAIGHTFLUSH.getValue());
			break;
		default:
			break;
		}
		return winner;
	}

	private String comparePlayerWithSameFlushAndStrightFlushRank(List<Card> sortedWhiteHand, List<Card> sortedBlackHand,
			String typeValue) {
		String winner;
		if (sortedWhiteHand.get(0).getRank() > sortedBlackHand.get(4).getRank()) {
			winner = PockerConstants.WHITE_WINS_WITH + typeValue + PockerConstants.SEMICOLON
					+ sortedWhiteHand.get(0).value();
		} else {
			winner = PockerConstants.BLACK_WINS_WITH + typeValue + PockerConstants.SEMICOLON
					+ sortedBlackHand.get(0).value();
		}
		return winner;
	}

	private String comparePlayerWithSameHighCardAndFlushRank(String winner, List<Card> sortedWhiteHand,
			List<Card> sortedBlackHand, String typeValue) {
		for (int i = 0; i < sortedWhiteHand.size(); i++) {
			if (sortedWhiteHand.get(i).getRank() < sortedBlackHand.get(i).getRank()) {
				winner = PockerConstants.BLACK_WINS_WITH + typeValue + PockerConstants.SEMICOLON
						+ sortedBlackHand.get(i).value();
				break;
			} else if (sortedWhiteHand.get(i).getRank() > sortedBlackHand.get(i).getRank()) {
				winner = PockerConstants.WHITE_WINS_WITH + typeValue + PockerConstants.SEMICOLON
						+ sortedWhiteHand.get(i).value();
				break;
			}
		}
		return winner;
	}

	private String comparePlayerWithSameTwoPairsRank(List<Card> sortedWhiteHand, List<Card> sortedBlackHand) {
		String winner;
		Set<Integer> setWhiteTwoPair = new HashSet<Integer>();
		Set<Integer> setBlackTwoPair = new HashSet<Integer>();
		List<Card> TwoPairWhiteSortedList = sortedWhiteHand.stream().filter(c -> !setWhiteTwoPair.add(c.getRank()))
				.collect(Collectors.toList());
		List<Card> TwoPairBlackSortedList = sortedBlackHand.stream().filter(c -> !setBlackTwoPair.add(c.getRank()))
				.collect(Collectors.toList());
		if (TwoPairWhiteSortedList.get(0).getRank() > TwoPairBlackSortedList.get(0).getRank()) {
			winner = PockerConstants.WHITE_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue() + PockerConstants.SEMICOLON
					+ TwoPairWhiteSortedList.get(0).value();
		} else if (TwoPairWhiteSortedList.get(0).getRank() < TwoPairBlackSortedList.get(0).getRank()) {
			winner = PockerConstants.BLACK_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue() + PockerConstants.SEMICOLON
					+ TwoPairBlackSortedList.get(0).value();
		} else {
			if (TwoPairWhiteSortedList.get(1).getRank() > TwoPairBlackSortedList.get(1).getRank()) {
				winner = PockerConstants.WHITE_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue() + PockerConstants.SEMICOLON
						+ TwoPairWhiteSortedList.get(1).value();
			} else if (TwoPairWhiteSortedList.get(1).getRank() < TwoPairBlackSortedList.get(1).getRank()) {
				winner = PockerConstants.BLACK_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue() + PockerConstants.SEMICOLON
						+ TwoPairBlackSortedList.get(1).value();
			} else {
				Card remainingWhiteCard = sortedWhiteHand.stream()
						.filter(c -> c.getRank() != TwoPairWhiteSortedList.get(0).getRank()
								&& c.getRank() != TwoPairWhiteSortedList.get(1).getRank())
						.findFirst().get();
				Card remainingBlackard = sortedBlackHand.stream()
						.filter(c -> c.getRank() != TwoPairBlackSortedList.get(0).getRank()
								&& c.getRank() != TwoPairBlackSortedList.get(1).getRank())
						.findFirst().get();
				if (remainingWhiteCard.getRank() > remainingBlackard.getRank()) {
					winner = PockerConstants.WHITE_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue()
							+ PockerConstants.SEMICOLON + remainingWhiteCard.value();
				} else {
					winner = PockerConstants.BLACK_WINS_WITH + HandTyeEnum.TWOPAIRS.getValue()
							+ PockerConstants.SEMICOLON + remainingBlackard.value();
				}
			}
		}
		return winner;
	}

	private String comparePlayerWithSameRank(String winner, List<Card> whiteHandasList, List<Card> blackHandasList,
			List<Card> sortedWhiteHand, List<Card> sortedBlackHand, String typeValue) {
		Set<Integer> setWhite = new HashSet<Integer>();
		Set<Integer> setBlack = new HashSet<Integer>();
		Card pairCardWhite = whiteHandasList.stream().filter(c -> !setWhite.add(c.getRank())).findFirst().get();
		Card pairCardBlack = blackHandasList.stream().filter(c -> !setBlack.add(c.getRank())).findFirst().get();
		if (pairCardWhite.getRank() > pairCardBlack.getRank()) {
			winner = PockerConstants.WHITE_WINS_WITH + typeValue + PockerConstants.SEMICOLON + pairCardWhite.value();
		} else if (pairCardWhite.getRank() < pairCardBlack.getRank()) {
			winner = PockerConstants.BLACK_WINS_WITH + typeValue + PockerConstants.SEMICOLON + pairCardBlack.value();
		} else {
			Card maxWhiteCard = sortedWhiteHand.stream().filter(c -> c.getRank() != pairCardWhite.getRank())
					.max(Comparator.comparing(Card::getRank)).get();
			Card maxBlackCard = sortedBlackHand.stream().filter(c -> c.getRank() != pairCardBlack.getRank())
					.max(Comparator.comparing(Card::getRank)).get();
			if (maxWhiteCard.getRank() > maxBlackCard.getRank()) {
				winner = PockerConstants.WHITE_WINS_WITH + typeValue + PockerConstants.SEMICOLON + maxWhiteCard.value();
			} else if (maxWhiteCard.getRank() < maxBlackCard.getRank()) {
				winner = PockerConstants.BLACK_WINS_WITH + typeValue + PockerConstants.SEMICOLON + maxBlackCard.value();
			}
		}
		return winner;
	}

}
