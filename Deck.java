/**
 * Deck Class
 * Creates a deck of playing Cards that can be manipulated to play a game.
 */
public class Deck extends SetOfCards {
	
	/**
	 * Initializes the deck and presets 52 Cards into it. All cards from Ace to King from each of the suits (Clubs, Hearts, Diamonds, Spades) are included. NO Jokers are included.
	 */
	public Deck() {
		super();
		initDeck();
	}

	/**
	 * Helps initialize the actual deck.
	 */
	private void initDeck() {
		char suit = ' ';
		int value;

		for (int s = 0; s < 4; s++) {	// Goes through each suit possibility
			
			switch (s) {

				case 0:
					suit = 'C';		// Set to Clubs
					break;
				
				case 1:
					suit = 'H';		// Set to Hearts
					break;
				
				case 2:
					suit = 'D';		// Set to Diamonds
					break;
				
				case 3:
					suit = 'S';		// Set to Spades
					break;

			}

			for (int v = 0; v < 13; v++) {	// Goes through each value possiblity
				value = v + 1;
				super.addCard(new Card(value, suit));

			}
		}
	}

	/**
	 * Randomly picks a card from the deck and returns the Card. If there are no Cards in the deck, null is returned.
	 * @return pile.get(randIndex) - randomly selected Card from the deck.
	 */
	public Card draw() {
		int randIndex = (int) (pile.size() * Math.random());
		Card card;

		if (!super.isEmpty()) {
			card = pile.get(randIndex);
			pile.remove(randIndex);
			return card;

		} else {
			return null;

		}
	}
}
