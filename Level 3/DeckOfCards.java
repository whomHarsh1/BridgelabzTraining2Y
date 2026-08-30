import java.util.Scanner;

public class DeckOfCards {

    // Suits and ranks
    static String[] suits = {
            "Hearts",
            "Diamonds",
            "Clubs",
            "Spades"
    };

    static String[] ranks = {
            "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"
    };


    // Method to initialize the deck
    static String[] initializeDeck() {

        // Calculate number of cards
        int numOfCards = suits.length * ranks.length;

        String[] deck = new String[numOfCards];

        int index = 0;

        // Create all cards
        for (int i = 0; i < suits.length; i++) {

            for (int j = 0; j < ranks.length; j++) {

                deck[index] = ranks[j] + " of " + suits[i];

                index++;
            }
        }

        return deck;
    }


    // Method to shuffle the deck
    static String[] shuffleDeck(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            // Generate random card number
            int randomCardNumber =
                    i + (int) (Math.random() * (n - i));

            // Swap current card with random card
            String temp = deck[i];

            deck[i] = deck[randomCardNumber];

            deck[randomCardNumber] = temp;
        }

        return deck;
    }


    // Method to distribute cards
    static String[][] distributeCards(
            String[] deck, int numberOfCards, int numberOfPlayers) {

        // Check if cards can be equally distributed
        if (numberOfCards % numberOfPlayers != 0) {

            System.out.println(
                    "Cards cannot be equally distributed among "
                            + numberOfPlayers + " players."
            );

            return null;
        }

        // Number of cards per player
        int cardsPerPlayer =
                numberOfCards / numberOfPlayers;

        // Create 2D array
        String[][] players =
                new String[numberOfPlayers][cardsPerPlayer];

        int index = 0;

        // Distribute cards
        for (int i = 0; i < numberOfPlayers; i++) {

            for (int j = 0; j < cardsPerPlayer; j++) {

                players[i][j] = deck[index];

                index++;
            }
        }

        return players;
    }


    // Method to print players and their cards
    static void printPlayers(String[][] players) {

        if (players == null) {
            return;
        }

        System.out.println("\n========== PLAYER CARDS ==========");

        for (int i = 0; i < players.length; i++) {

            System.out.println("\nPlayer " + (i + 1) + ":");

            for (int j = 0; j < players[i].length; j++) {

                System.out.println("  " + players[i][j]);
            }
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: Calculate total cards
        int numOfCards = suits.length * ranks.length;

        System.out.println(
                "Total cards in deck: " + numOfCards
        );

        // Step 2: Initialize deck
        String[] deck = initializeDeck();

        // Step 3: Shuffle deck
        deck = shuffleDeck(deck);

        // Step 4: Take number of cards
        System.out.print(
                "Enter number of cards to distribute: "
        );
        int numberOfCards = sc.nextInt();

        // Validate number of cards
        if (numberOfCards <= 0 || numberOfCards > numOfCards) {

            System.out.println(
                    "Invalid number of cards."
            );

            sc.close();
            return;
        }

        // Step 5: Take number of players
        System.out.print(
                "Enter number of players: "
        );
        int numberOfPlayers = sc.nextInt();

        // Validate players
        if (numberOfPlayers <= 0) {

            System.out.println(
                    "Number of players must be greater than 0."
            );

            sc.close();
            return;
        }

        // Step 6: Distribute cards
        String[] cardsToDistribute = new String[numberOfCards];

        for (int i = 0; i < numberOfCards; i++) {
            cardsToDistribute[i] = deck[i];
        }

        String[][] players = distributeCards(
                cardsToDistribute,
                numberOfCards,
                numberOfPlayers
        );

        // Step 7: Print cards
        printPlayers(players);

        sc.close();
    }
}