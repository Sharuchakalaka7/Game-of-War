/**
 * PlayedPile Class
 * Represents the Cards played by the players.
 */
public class PlayedPile extends SetOfCards {
	
	/**
	 * Intializes a PlayedPile for players to play Cards onto.
	 */
	public PlayedPile() {
		super();
	}

	/**
	 * Takes and returns the top playing Card.
	 * @return card
	 */
	public Card draw() {
		Card card = pile.get(0);	// Gets the first card played
		card.setFaceUp(false);	// Flips the Card so that it is facing down (faceUp == false)
		pile.remove(0);			// Removes the Card from the pile
		return card;
	}

	/**
	 * Returns a String that represents the Cards that have been played by the player.
	 * @return pileString
	 */
	@Override
	public String toString() {
		String pileString = "";

		for (int i = 0; i < pile.size(); i++) {
			
			if (pile.get(i).getFaceUp()) {
				pileString += pile.get(i).getName() + " ";

			} else {
				pileString += "[] ";

			}

		}
		return pileString;
	}
}
