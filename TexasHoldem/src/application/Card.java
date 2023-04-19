package application;

/**
 * Models a typical playing card
 * @author Dennis Schmidt
 */
public class Card {
	private Suit suit;
	private Rank rank;
	
	/**
	 * @param suit the playing card suit (clubs, spades, diamonds, hearts)
	 * @param rank the playing card numerical value (Ace, Two, ...)
	 */
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	
	/**
	 * @return returns the card suit enumerated value
	 */
	public Suit getSuit() {
		return suit;
	}
	
	/**
	 * @return returns the card numerical value
	 */
	public Rank getRank() {
		return rank;
	}
	
	
	/**
	 * @return formated text description of the card
	 */
	public String toString() {
		return rank.name() + " of " + suit.name();
	}

}
