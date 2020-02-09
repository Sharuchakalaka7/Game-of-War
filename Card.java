/**
 * Card Class
 * Defines the properties and values of a playing card.
 */
public class Card implements Comparable {
	private int value;	// 2-10 = 2-10, J = 11, Q = 12, K = 13, A = 14
	private char suit;	// 'C' = Clubs, 'H' = Hearts, 'D' = Diamonds, 'S' = Spades
	private String name;
	private boolean faceUp;

	/**
	 * Initializes the playing Card and its properties.
	 * @param value
	 * @param suit
	 */
	public Card(int value, char suit) {
		this.value = value;
		this.suit = suit;
		faceUp = false;

		if (value == 1) {	// Ace
			this.value += 13;
		}

		initName();
	}

	/**
	 * Initializes the name String of the playing Card.
	 */
	private void initName() {
		name = "";

		if (value <= 10) {	// not ace, jack, queen, or king
			name += value;

		} else if (value == 11) {	// Jack
			name += 'J';

		} else if (value == 12) {	// Queen
			name += 'Q';

		} else if (value == 13) {	// King
			name += 'K';

		} else {					// Ace
			name += 'A';

		}

		name += suit;
	}

	/**
	 * Returns the value of the playing Card.
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the suit type of the playing Card.
	 * @return suit
	 */
	public char getSuit() {
		return suit;
	}

	/**
	 * Returns the name of the playing Card in the form:
	 <suit><value>
	 * The suit can consist of 'C' (Clubs), 'H' (Hearts), 'D' (Diamonds), and 'S' (Spades). The values from lowest to highest are 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns true if the Card's identity side is facing up (is visible). Otherwise, false is returned.
	 * @return faceUp
	 */
	public boolean getFaceUp() {
		return faceUp;
	}

	/**
	 * Sets the value of the playing Card faceUp to whatever value is passed.
	 * @param faceUp
	 */
	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	/**
	 * Compares the values of this Card and the given Card object. If the value of this Card is less than the value of the other Card, -1 is returned. If the value of this Card is greater than the value of the other Card, 1 is returned. Otherwise, if the values of both card are the same, 0 is returned.
	 * @param c
	 * @return -1 || 0 || 1
	 */
	public int compareTo(Object c) {
		Card testC = (Card)c;

		if (value < testC.getValue()) {	// this card has a lower value
			return -1;

		} else  if (value > testC.getValue()) {
			return 1;

		} else {
			return 0;

		}
	}
}
