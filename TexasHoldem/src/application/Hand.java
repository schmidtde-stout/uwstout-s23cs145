package application;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a hand of poker cards with methods to add cards, count cards,
 * and evaluate hand scores.
 */
public class Hand implements Comparable<Hand>{
	private ArrayList<PokerCard> cards;
 
   /**
    * Constructs an empty hand.
    */
	public Hand() {
		cards = new ArrayList<PokerCard>();
	}

   /**
    * Returns the number of cards in the hand.
    *
    * @return the number of cards in the hand
    */
   public int getCardCount() {
      return cards.size();
   }
   
   public ArrayList<PokerCard> getCards() {
	   return cards;
   }

   /**
    * Adds a poker card to the hand.
    *
    * @param card the poker card to be added to the hand
    */   
	public void addCard(PokerCard card) {
		cards.add(card);
	}

	private int countCardsWithRank(Rank rank) {
		// iterate through the hand and count
		// the number of cards that match passed face
		int count = 0;
		for (PokerCard card : cards) {
			if (card.getRank() == rank) {
				count++;
			}
		}
		return count;
	}

	private boolean hasCardsWithRankCountGreaterThan(int count) {
		for (PokerCard card : cards) {
			if (countCardsWithRank(card.getRank()) > count) {
				return true;
			}
		}
		return false;
	}

	public boolean hasPair() {
		return hasCardsWithRankCountGreaterThan(1);
	}

	public boolean hasThreeOfaKind() {
		return hasCardsWithRankCountGreaterThan(2);
	}

	public boolean hasFourOfaKind() {
		return hasCardsWithRankCountGreaterThan(3);
	}

	public boolean hasStraight() {
		if (cards.size() == 5) {
			ArrayList<PokerCard> cards = new ArrayList<PokerCard>(this.cards);
			Collections.sort(cards);
			int last = cards.get(0).getRank().ordinal();
			for (int i = 1; i < 5; i++) {
				if (cards.get(i).getRank().ordinal() == (last + 1)) {
					last++;
				} else {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	public boolean hasFlush() {
		boolean hasIt = false;
		if (cards.size() == 5) {
			Suit suit = cards.get(0).getSuit();
			int count = 1;
			for (int i = 1; i < 5; i++) {
				if (suit == cards.get(i).getSuit()) {
					count++;
				}
			}
			hasIt = count == 5;
		}
		return hasIt;
	}

  /**
   * Returns a string representation of the hand, including cards and score.
   *
   * @return a string representation of the hand
   */
	public String toString() {
		String description = "Hand:";
		if (cards.size() > 0) {
			for (PokerCard card : cards) {
				description += " " + card.toString();
			}
		} 
		else {
			description += " Empty";
		}
		return description + ", Score: " + getScoreString();
	}

  /**
   * Returns a string representation of the hand's score.
   *
   * @return a string representation of the hand's score
   */
	public String getScoreString() {
		String score = "Nothing";
		if (hasStraight() && hasFlush()) {
			score = "Straight Flush";
		} else if (this.hasFourOfaKind()) {
			score = "Four of a Kind";
		} else if (this.hasFlush()) {
			score = "Flush";
		} else if (this.hasStraight()) {
			score = "Straight";
		} else if (this.hasThreeOfaKind()) {
			score = "Three of a Kind";
		} else if (this.hasPair()) {
			score = "Pair";
		}
		return score;
	}
	
	public int getScoreValue() {
		int score = 0;
		if (hasStraight() && hasFlush()) {
			score = 6;
		} else if (this.hasFourOfaKind()) {
			score = 5;
		} else if (this.hasFlush()) {
			score = 4;
		} else if (this.hasStraight()) {
			score = 3;
		} else if (this.hasThreeOfaKind()) {
			score = 2;
		} else if (this.hasPair()) {
			score = 1;
		}
		return score;
	}

	@Override
	public int compareTo(Hand o) {
		return (getScoreValue() - o.getScoreValue());
	}

}
