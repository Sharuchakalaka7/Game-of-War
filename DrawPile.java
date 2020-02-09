/**
 * DrawPile Class
 * Represents the playing Cards in the hand of a player.
 */
public class DrawPile extends SetOfCards {
	
	/**
	 * Initializes a DrawPile for players to draw Cards from.
	 */
	public DrawPile() {
		super();
	}

	/**
	 * Returns the number of Cards that are still in the player's draw pile.
	 * @return pile.size()
	 */
	public int getSize() {
		return pile.size();
	}

	/**
	 * Takes and returns the top playing Card.
	 * @return card
	 */
	public Card draw() {
		Card card = pile.get(0);	// Gets the first card in the ArrayList (the top Card)
		pile.remove(0);			// Removes the Card from the pile
		return card;
	}

	/**
	 * Transfers all of the playing Cards from an array list of given playing Cards to this pile.
	 * @param cardSet
	 */
	public void transfer(SetOfCards cardSet) {
		PlayedPile cards = (PlayedPile) cardSet;
		
		while (!cards.isEmpty()) {
			super.addCard(cards.draw());
			
		}
	}
	/**
	 * Shuffles the pile of playing Cards.
	 */
	public void shuffle() {
		Card tempC;	// Temporary variable
		int rand;	// Index of a random playing Card from the pile

		for (int i = 0; i < pile.size(); i++) {
			rand = (int) (pile.size() * Math.random());
			
			tempC = pile.get(i);
			pile.set(i, pile.get(rand));
			pile.set(rand, tempC);
			
		}
	}
}
