import java.util.Scanner;

public class RockPaperScissors {

    // Method to generate computer choice
    static String getComputerChoice() {

        int choice = (int) (Math.random() * 3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }


    // Method to find the winner
    static String findWinner(String player, String computer) {

        // Draw condition
        if (player.equals(computer)) {
            return "Draw";
        }

        // Player wins
        if ((player.equals("Rock") &&
                computer.equals("Scissors")) ||

            (player.equals("Paper") &&
                computer.equals("Rock")) ||

            (player.equals("Scissors") &&
                computer.equals("Paper"))) {

            return "Player";
        }

        // Otherwise computer wins
        return "Computer";
    }


    // Method to calculate wins and percentages
    static String[][] calculateStats(
            int playerWins,
            int computerWins,
            int draws,
            int totalGames) {

        String[][] stats = new String[3][3];

        // Player statistics
        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] =
                String.valueOf(
                        (playerWins * 100.0) / totalGames
                );

        // Computer statistics
        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] =
                String.valueOf(
                        (computerWins * 100.0) / totalGames
                );

        // Draw statistics
        stats[2][0] = "Draw";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] =
                String.valueOf(
                        (draws * 100.0) / totalGames
                );

        return stats;
    }


    // Method to display game results
    static void displayResults(
            String[][] games,
            String[][] stats) {

        System.out.println("\n========== GAME RESULTS ==========");

        System.out.printf(
                "%-10s %-12s %-12s %-12s%n",
                "Game",
                "Player",
                "Computer",
                "Winner"
        );

        System.out.println(
                "----------------------------------------------"
        );

        for (int i = 0; i < games.length; i++) {

            System.out.printf(
                    "%-10s %-12s %-12s %-12s%n",
                    games[i][0],
                    games[i][1],
                    games[i][2],
                    games[i][3]
            );
        }


        System.out.println("\n========== GAME STATISTICS ==========");

        System.out.printf(
                "%-12s %-10s %-15s%n",
                "Player",
                "Wins",
                "Percentage"
        );

        System.out.println(
                "--------------------------------------"
        );

        for (int i = 0; i < stats.length; i++) {

            System.out.printf(
                    "%-12s %-10s %-15s%%%n",
                    stats[i][0],
                    stats[i][1],
                    stats[i][2]
            );
        }

        System.out.println(
                "--------------------------------------"
        );
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of games
        System.out.print("Enter number of games: ");
        int numberOfGames = sc.nextInt();

        // 2D array to store game results
        // Columns:
        // 0 = Game number
        // 1 = Player choice
        // 2 = Computer choice
        // 3 = Winner
        String[][] games =
                new String[numberOfGames][4];

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;


        // Play multiple games
        for (int i = 0; i < numberOfGames; i++) {

            System.out.println("\nGame " + (i + 1));

            System.out.print(
                    "Enter your choice (Rock/Paper/Scissors): "
            );

            String playerChoice = sc.next();

            // Convert first letter to uppercase
            playerChoice =
                    playerChoice.substring(0, 1).toUpperCase()
                    + playerChoice.substring(1).toLowerCase();


            // Validate player choice
            if (!playerChoice.equals("Rock") &&
                !playerChoice.equals("Paper") &&
                !playerChoice.equals("Scissors")) {

                System.out.println(
                        "Invalid choice. Please enter Rock, Paper or Scissors."
                );

                i--;
                continue;
            }


            // Generate computer choice
            String computerChoice =
                    getComputerChoice();


            // Find winner
            String winner =
                    findWinner(
                            playerChoice,
                            computerChoice
                    );


            // Store game result
            games[i][0] = String.valueOf(i + 1);
            games[i][1] = playerChoice;
            games[i][2] = computerChoice;
            games[i][3] = winner;


            // Update statistics
            if (winner.equals("Player")) {
                playerWins++;
            }

            else if (winner.equals("Computer")) {
                computerWins++;
            }

            else {
                draws++;
            }
        }


        // Calculate statistics
        String[][] stats =
                calculateStats(
                        playerWins,
                        computerWins,
                        draws,
                        numberOfGames
                );


        // Display results
        displayResults(games, stats);

        sc.close();
    }
}