package arrays_and_strings.class_problems;

import java.util.Locale;
import java.util.Random;

/**
 * Day 1 Live-Coding Session - Problem 1: Rock-Paper-Scissors Game
 *
 * Plays N rounds between the player and a randomly-moving computer, records
 * every round, and prints a summary table plus wins/losses/draws and the
 * player's win percentage.
 *
 * The player's moves come from a predefined list (as the brief allows for a
 * live demo) and the Random uses a fixed seed, so the demo prints the same
 * table every run. Drop the seed for genuinely random rounds.
 */
public class RockPaperScissorsGame {

    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};

    /** Standard rules: Rock beats Scissors, Paper beats Rock, Scissors beats Paper. */
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        boolean playerWins =
                   (playerMove.equals("Rock")     && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper")    && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random random = new Random(42); // fixed seed = reproducible demo

        int rounds = playerMoves.length;
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {
            computerMoves[i] = MOVES[random.nextInt(MOVES.length)];
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.printf(Locale.US, "%-6s | %-12s | %-14s | %s%n",
                "Round", "Player Move", "Computer Move", "Result");
        for (int i = 0; i < rounds; i++) {
            System.out.printf(Locale.US, "%-6d | %-12s | %-14s | %s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        double winPercentage = (wins * 100.0) / rounds;
        System.out.printf(Locale.US, "Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}
