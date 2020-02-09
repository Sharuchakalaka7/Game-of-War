/**
 * GameOfWar Class
 * Manages an entire game of war.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class GameOfWar {
	private static Deck deck;
	private static DrawPile playerDraw;
	private static DrawPile compDraw;
	private static PlayedPile playerPlayed;
	private static PlayedPile compPlayed;
	private static int count;
	private static boolean speedPlay;	// The option to instantly finish game is given
	
	/**
	 * Runs and manages a whole game of war. Returns "P" if  the player wins the game. Returns "C" if the computer won the game.
	 * @return 'P' || 'C'
	 */
	public static char play() {
		/* Initialize all member variables */
		initGame();

		/* Plays rounds until one player runs out of playing Cards or number of rounds have been exceeded (5000 rounds) */
		do {

			playRound();

		} while (!(playerDraw.isEmpty() || compDraw.isEmpty()) && count < 5000);

		/* Display post-game status */
		if (playerDraw.isEmpty()) {	// player lost
			System.out.println("\nCOMPUTER wins the matchup!");
			return 'C';

		} else if (compDraw.isEmpty()) {	// computer lost
			System.out.println("\nPLAYER wins the matchup!");
			return 'P';

		} else {	// Infinite loop OR too long of a loop

			System.out.println("\nGame went on for too long...");

			if (playerDraw.getSize() > compDraw.getSize()) {	// Overall, player has more Cards
				System.out.println("PLAYER has more Cards");
				System.out.println("PLAYER wins the matchup!");
				return 'P';

			} else if (playerDraw.getSize() < compDraw.getSize()) {	// Overall, computer has more Cards
				System.out.println("COMPUTER has more Cards");
				System.out.println("COMPUTER wins the matchup!");
				return 'C';

			} else {	// Overall, both players have the same number (26) of Cards
				speedPlay = false;
				playRound();	// Plays a sudden death round to determine a winner

				if (playerDraw.getSize() > compDraw.getSize()) {	// Overall, player has more Cards
					System.out.println("PLAYER has more Cards");
					System.out.println("PLAYER wins the matchup!");
					return 'P';

				} else {	// Overall, computer has more Cards
					System.out.println("COMPUTER has more Cards");
					System.out.println("COMPUTER wins the matchup!");
					return 'C';
					
				}
			}

		}
	}

	/**
	 * Initializes all objects and variables required to successfully play a game of war.
	 */
	private static void initGame() {
		deck = new Deck();
		playerDraw = new DrawPile();
		compDraw = new DrawPile();
		playerPlayed = new PlayedPile();
		compPlayed = new PlayedPile();
		count = 0;
		speedPlay = false;

		/* Take initial Cards from the deck and randomly distribute to the two different drawPiles one at a time */
		while (!deck.isEmpty()) {

			for (int piles = 0; piles < 2; piles++) {	// Alternates in distributing the Cards

				switch (piles) {
					
					case 0:
						playerDraw.addCard(deck.draw());	// Adds one Card to player's draw pile
						break;
					
					case 1:
						compDraw.addCard(deck.draw());		// Adds one Card to computer's draw pile
						break;

				}

			}
		}
	}

	/**
	 * Plays a single round of War.
	 */
	private static void playRound() {
		final int WAR_CARDS_NUM = 4;
		boolean war = false;		// Whether or not there is a war between the players
		String data;
		Scanner input = new Scanner(System.in);

		/* Round Initialization */
		/* Increment counter by 1 for another match */
		count++;
		/* Draw a playing Card from each of the player's hands */
		Card pCard = playerDraw.draw();
		Card cCard = compDraw.draw();
		/* Flips both Cards over to make both Cards visibile */
		pCard.setFaceUp(true);
		cCard.setFaceUp(true);
		/* Adds both Cards to their respective PlayedPiles */
		playerPlayed.addCard(pCard);
		compPlayed.addCard(cCard);

		/* Plays the round */
		if (count == 5001) {
			System.out.println("SUDDEN DEATH ROUND!!!");

		} else {
			System.out.println("\nRound " + count);

		}

		do {
			
			/* Display the Cards on the played */
			System.out.println("Player (" + playerDraw.getSize() + " cards left): " + playerPlayed.toString());
			System.out.println("Computer (" + compDraw.getSize() + " cards left): " + compPlayed.toString());
			
			/* Compute for winner or war */
			if (pCard.compareTo(cCard) == 0) {	// Both Cards are the same

				war = true;
				boolean playerOut = false;	// If player is short of Cards
				boolean compOut = false;	// If computer is short of Cards
				System.out.println("Same Cards: War has been declared!");
				
				for (int i = 1; i <= WAR_CARDS_NUM; i++) {	// Draw more Cards from DrawPiles
					
					/* Draws a Card from the player's DrawPile if there are any left */
					if (!playerDraw.isEmpty()) {
						pCard = playerDraw.draw();

					} else {
						pCard.setFaceUp(true);
						playerOut = true;

					}

					/* Draws a Card from the computer's DrawPile if there are any left */
					if (!compDraw.isEmpty()) {
						cCard = compDraw.draw();

					} else {
						cCard.setFaceUp(true);
						compOut = true;

					}
					
					/* Adds both Cards to their respective PlayedPiles, if there are any left */
					if (!playerOut) {
						playerPlayed.addCard(pCard);
					}

					if (!compOut) {
						compPlayed.addCard(cCard);
					}

					if (i == WAR_CARDS_NUM) {
						/* Flips any last Cards so they are visibile */
						if (!playerOut) {
							pCard.setFaceUp(true);
						}

						if (!compOut) {
							cCard.setFaceUp(true);
						}
					}
				}

			} else if (pCard.compareTo(cCard) == -1) {	// Computer's Card is higher
				war = false;
				System.out.println("Computer has higher card. Computer wins round!");
				compDraw.transfer(compPlayed);
				compDraw.transfer(playerPlayed);

			} else {	// Player's Card is higher
				war = false;
				System.out.println("Player has higher card. Player wins round!");
				playerDraw.transfer(compPlayed);
				playerDraw.transfer(playerPlayed);

			}

			/* Speedplay options */
			if (!speedPlay) {
				System.out.print("{Press Enter to continue} {Enter Y to speed play the game} ... ");
				data = input.nextLine().toUpperCase();

				if (data.equals("Y")) {
					speedPlay = true;
				}
			}

		} while (war);

		/* Shuffle each Draw Pile every 100 round */
		if (count%100 == 0) {
			playerDraw.shuffle();
			compDraw.shuffle();

		}
	}
}
