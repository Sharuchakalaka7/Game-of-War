/**
 * Main Class
 * Plays the Game of War. The rules of this game can be found in WAR_RULES.txt.
 *
 * Classes include: Card, Deck, DrawPile, PlayedPile, SetOfCards, and GameOfWar.
 */
import java.util.Scanner;

public class Main {

	/**
	 * Actual client code for the War Card Game
	 */
	public static void main(String[] args) {
		String data;
		int pWins = 0, cWins = 0;
		Scanner input = new Scanner(System.in);

		/* Play a minimum of one game */
		System.out.print("Want to play a game of war? (Y/N): ");
		data = input.nextLine().toUpperCase();
		switch (data) {
			
			case "Y":
				break;
			
			case "N":
				System.out.println("Too bad, you're gonna play it at least once!");	// L0L 
				break;
			
			default:
				System.out.println("Umm, ok then... I'll take that as a yes.");		// Just in case...
				break;

		}
		/* Play the one game */
		switch (GameOfWar.play()) {
			
			case 'P':	// Increment player win
				pWins++;
				break;
			
			case 'C':	// Increment computer win
				cWins++;
				break;
				
		}

		/* Give option to play more games if desired */
		do {

			do {

				System.out.print("\nWant to play another game of war OR view stats? (Y/N/S): ");
				data = input.nextLine().toUpperCase();

			} while (!(data.equals("Y") || data.equals("N") || data.equals("S")));

			if (data.equals("Y")) {

				/* Play the one game */
				switch (GameOfWar.play()) {
					
					case 'P':	// Increment player win
						pWins++;
						break;
					
					case 'C':	// Increment computer win
						cWins++;
						break;
						
				}

			} else if (data.equals("S")) {
				System.out.println("\nPlayer Wins: " + pWins);
				System.out.println("Computer Wins: " + cWins);

			}

		} while (!data.equals("N"));
		input.close();
	}

/*----------------------------------------------------------------*/

	// /**
	//  * Test 3
	//  * Testing semantics and shuffling logic, as well as the gameplay specifics.
	//  */
	// public static void main(String[] args) {
	// 	double average = 0;
	// 	int pWins = 0, cWins = 0;

	// 	/* Speed play 5000 games */
	// 	for (int i = 0; i < 100; i++) {

	// 		switch (GameOfWar.play()) {
				
	// 			case 'P':
	// 				pWins++;
	// 				break;
				
	// 			case 'C':
	// 				cWins++;
	// 				break;

	// 		}
	// 		average += GameOfWar.count;

	// 	}

	// 	/* Calculate the average rounds. Also display all stats */
	// 	average /= 100.0;
	// 	System.out.println("Average: " + average);
	// 	System.out.println("Player Wins: " + pWins);
	// 	System.out.println("Computer Wins: " + cWins);
	// }


	// /**
	//  * Test 2
	//  * Testing all classes once
	//  */
	// public static void main(String[] args) {
	// 	GameOfWar.play();
	// }

/*----------------------------------------------------------------*/

	// /**
	//  * Test 1
	//  * Initial testing for Card and Deck classes.
	//  */
	// public static void main(String[] args) {
	// 	Deck deck = new Deck();
	// 	Card randCard;
	// 	Card sampleCard = new Card(11, 'H');	// Jack of Hearts
		
	// 	/* Deck methods - NONE */
	// 	/* Card methods - getValue(), getSuit(), getName() */
	// 	System.out.println("Value: " + sampleCard.getValue());
	// 	System.out.println("Suit: " + sampleCard.getSuit());
	// 	System.out.println("Name: " + sampleCard.getName());

	// 	/* Deck methods - Deck(), initDeck(), toString() */
	// 	/* Card methods - Card(), initName() */
	// 	System.out.println("\nThe original deck: " + deck.toString() + "\n");
		
	// 	/* Deck methods - deal(), empty() */
	// 	/* Card methods - getInDeck(), setInDeck() */
	// 	do {

	// 		randCard = deck.deal();
	// 		if (randCard != null) {
	// 			System.out.println("Card dealt is: " + randCard.getName());
	// 		}

	// 	} while (randCard != null);	// Checks if the method empty() works or not via the method deal().
	// 	System.out.println("\nCurrent deck: " + deck.toString());	// Should print "{ }"

	// 	/* Deck methods - resetDeck() */
	// 	/* Card methods - NONE */
	// 	deck.resetDeck();
	// 	System.out.println("\nDeck restored...");
	// 	System.out.println("Current deck: " + deck.toString());

	// 	/* Deck methods - NONE */
	// 	/* Card methods - equals(), compareTo() */
	// 	randCard = deck.deal();
	// 	System.out.println("\nCards being tested: " + sampleCard.getName() + "(default) and " + randCard.getName());

	// 	if (sampleCard.equals(randCard)) {
	// 		System.out.println("They are the same cards! (LOL)");

	// 	} else {
	// 		System.out.println("They are not the same cards.");

	// 		if (sampleCard.compareTo(randCard) == -1) {
	// 			System.out.println(sampleCard.getName() + " is less than " + randCard.getName());

	// 		} else if (sampleCard.compareTo(randCard) == 1) {
	// 			System.out.println(sampleCard.getName() + " is greater than " + randCard.getName());

	// 		} else {
	// 			System.out.println("ERROR.......");

	// 		}
	// 	}
	// }
/*----------------------------------------------------------------*/

}
