/**
 * SetOfCards Class
 * Defines the general properties and behaviours of any set of Cards
 */
import java.util.ArrayList;

abstract class SetOfCards {
	protected ArrayList<Card> pile;

	/**
	 * Initializes the set of Cards with an empty pile.
	 */
	public SetOfCards() {
		pile = new ArrayList<Card>();
	}

	/**
	 * Adds the given playing Card to the set of Cards.
	 * @param card
	 */
	public void addCard(Card card) {
		pile.add(card);

	}

	/**
	 * Checks if there are still playing Cards in the pile. If there are still Cards (size > 0), then true is returned. Otherwise, false is returned.
	 * @return true || false
	 */
	public boolean isEmpty() {

		if (pile.size() > 0) {
			return false;

		} else {
			return true;

		}

	}

	abstract Card draw();
}
