package application;
/**
 * Represents a poker card with a suit, rank, and string representation.
 * The class extends the Card class and implements the Comparable interface
 * to allow for comparison of cards based on their rank.
 */
public class PokerCard extends Card implements Comparable<PokerCard> {
	
    /**
     * Constructs a new PokerCard with the given suit and rank.
     *
     * @param suit the suit of the poker card (clubs, spades, diamonds, hearts)
     * @param rank the rank of the poker card (Ace, Two, ...)
     */   
	public PokerCard(Suit suit, Rank rank) {
		super(suit,rank);
	}
	
    /**
     * Returns a string representation of the poker card with the rank
     * and the Unicode symbol for the suit.
     *
     * @return a string representation of the poker card
     */
	public String toString() {
		String description = "";
		switch(getRank()) {
		case ACE:
			description = "A";
			break;
		case TWO:
			description = "2";
			break;
		case THREE:
			description = "3";
			break;
		case FOUR:
			description = "4";
			break;
		case FIVE:
			description = "5";
			break;
		case SIX:
			description = "6";
			break;
		case SEVEN:
			description = "7";
			break;
		case EIGHT:
			description = "8";
			break;
		case NINE:
			description = "9";
			break;
		case TEN:
			description = "10";
			break;
		case JACK:
			description = "J";
			break;
		case QUEEN:
			description = "Q";
			break;
		case KING:
			description = "K";
			break;
		default:
		}
		
		switch (getSuit()) {
		case SPADES:
			description += new String(Character.toChars(0x2660));
			break;
		case HEARTS:
			description += new String(Character.toChars(0x2665));
			break;
		case DIAMONDS:
			description += new String(Character.toChars(0x2666));
			break;
		case CLUBS:
			description += new String(Character.toChars(0x2663));
			break;
		}
		return description;
	}

    /**
     * Compares this poker card with the specified poker card for order.
     * Returns a negative integer, zero, or a positive integer as this card's
     * rank is less than, equal to, or greater than the specified card's rank.
     *
     * @param card the poker card to be compared
     * @return a negative integer, zero, or a positive integer as this card's
     * rank is less than, equal to, or greater than the specified card's rank
     */
	@Override
	public int compareTo(PokerCard card) {
		int rankValue = getRank().ordinal();
		if (rankValue> card.getRank().ordinal()) {
			return 1;
		}
		else if (rankValue < card.getRank().ordinal()) {
			return -1;
		}
		return 0;
	}
}
