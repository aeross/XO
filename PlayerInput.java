/**
 * after printing the empty board, the program then prompts the players to make a move.
 * note: the general convention is first player is always 'X', and the second player 'O'.
 * 
 * To make a move in tic tac toe, each player simply has to type a number between 1 to 9,
 * with each number representing these locations on the board:
 * 
 *  1 | 2 | 3 
 * ___|___|___
 *  4 | 5 | 6 
 * ___|___|___
 *  7 | 8 | 9 
 *    |   |   
 * 
 * for example, if the first player inputs number 7, the board would look like this:
 * 
 *    |   |   
 * ___|___|___
 *    |   |   
 * ___|___|___
 *  X |   |   
 *    |   |   
 * 
 * Similarly, in connect four, each player has to type a number between 1 to 7,
 * with each number representing these columns on the board:
 * 
 *  1   2   3   4   5   6   7
 *    |   |   |   |   |   |
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   |
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   | 
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   |
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   |
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   |
 *    |   |   |   |   |   |
 * 
 * for example, if the first player inputs number 7, the board would look like this:
 * 
 *    |   |   |   |   |   |
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   |
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   | 
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   |
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   |
 * ___|___|___|___|___|___|___
 *    |   |   |   |   |   | X
 *    |   |   |   |   |   |
 * 
 * In both games, players have a choice to exit the game by inputting 0.
 */

import java.util.Scanner;
import java.util.Arrays;

public abstract class PlayerInput {

    protected ArrayManipulation myArray = new ArrayManipulation();

    // method to check if a move is valid
    public abstract boolean validateMoves(int move, int[] validMoves);

    // updates validMoves after the player makes a move based on the current game situation
    public abstract int[] updateValidMoves(int move, int[] validMoves);

    // gets input (move) from player, checks for validity, and returns the value of the move
    public abstract int getInput(int[] validMoves, int player);
}


class XOPlayerInput extends PlayerInput {

    private static final int[] VALIDMOVES = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // all valid moves

    public int[] getValidMoves() {
        return VALIDMOVES;
    }

    // declares a move as valid if the move is in validMoves
    public boolean validateMoves(int move, int[] validMoves) {
        if (myArray.isin(move, validMoves)) {
            return true;
        } else {
            return false;
        }
    }

    // in tic tac toe, you can't have players picking the same move more than once
    // (i.e., if a player has already picked 5, 5 cannot be picked again by either player)
    public int[] updateValidMoves(int move, int[] validMoves) {
        return myArray.remove(move, validMoves);
    }
    
    public int getInput(int[] validMoves, int player) {
        int move = 0;
        boolean valid = false;

        while (!valid) {
            // get input
            Scanner input = new Scanner(System.in);
            System.out.println("Player " + player + ", please make a move (1-9)");
            try {
                move = input.nextInt();
                // validate input
                if (validateMoves(move, validMoves)) {
                    valid = true;
                } else if (move == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Error: move is invalid");
                }
            } catch (Exception e) {
                System.out.println("Error: move is invalid");
            }
        }
        return move;
    }
}


class ConnectFourPlayerInput extends PlayerInput {

    private static final int[] VALIDMOVES = {1, 2, 3, 4, 5, 6, 7};
    // in connect 4, you can pick the same number multiple times until the column fills up,
    // or in a standard 6x7 connect 4, until the number has been picked 6 times by either player,
    // so we'll use these to keep track of it
    private static final int COLSIZE = 6;
    private static int[] moveCounter = {0, 0, 0, 0, 0, 0, 0};

    // getters
    public int[] getValidMoves() { 
        return VALIDMOVES;
    }
    public int[] getMoveCounter() {
        return moveCounter;
        /**
         * note to self: if I declare int[] moveCounter as NOT static, the value in this method
         * will remain [0, 0, 0, 0, 0, 0] forever even though I've updated them below, it's kinda
         * fascinating and confusing how variables in java works :-)
         */
    }

    public boolean validateMoves(int move, int[] validMoves) {
        // if the move is between 1-7 and has picked less than 6 times, then it is a valid move
        try {
            if ((moveCounter[move - 1] < COLSIZE)) {
                moveCounter[move - 1] += 1;
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public int[] updateValidMoves(int move, int[] validMoves) {
        // once the move has been picked 6 times, remove that from validMoves
        if (moveCounter[move - 1] == COLSIZE) {
            return myArray.remove(move, validMoves);
        }
        return validMoves;
    }
    
    public int getInput(int[] validMoves, int player) {
        int move = 0;
        boolean valid = false;

        while (!valid) {
            // get input
            Scanner input = new Scanner(System.in);
            System.out.println("Player " + player + ", please make a move (1-7)");
            try {
                move = input.nextInt();
                // validate input
                if (validateMoves(move, validMoves)) {
                    valid = true;
                } else if (move == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Error: move is invalid");
                }
            } catch (Exception e) {
                System.out.println("Error: move is invalid");
            }
        }
        return move;
    }
}