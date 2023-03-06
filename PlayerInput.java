/**
 * after printing the empty board, the program then prompts the players to make a move.
 * note: the general convention is first player is always 'X', and the second player 'O'.
 * 
 * to keep things simple, the player simply has to type a number between 1 to 9,
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
 */

import java.util.Scanner;

abstract class PlayerInput {

    protected ArrayManipulation myArray = new ArrayManipulation();

    // declares a move as valid if the move is in validMoves
    public boolean validateMoves(int move, int[] validMoves) {
        if (myArray.isin(move, validMoves)) {
            return true;
        } else {
            return false;
        }
    }

    // updates validMoves after the player makes a move based on the current game situation
    abstract int[] updateValidMoves(int move, int[] validMoves);

    // gets input (move) from player, checks for validity, and returns the value of the move
    abstract int getInput(int[] validMoves, int player);
}


class XOPlayerInput extends PlayerInput {

    private static final int PLAYER = 1;  // player 1 always goes first
    private static final int[] VALIDMOVES = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // all valid moves

    public int getPlayer() { 
        return PLAYER;
    }
    public int[] getValidMoves() { 
        return VALIDMOVES;
    }


    // in tic tac toe, you can't have players picking the same move more than once
    // (i.e., if a player has already picked 5, 5 cannot be picked again by either player)
    public int[] updateValidMoves(int move, int[] validMoves) {
        return myArray.remove(move, validMoves);
    }
    
    
    public int getInput(int[] validMoves, int player) {
        // returns the move the player makes
        int move = 0;
        boolean valid = false;

        while (!valid) {
            // get input
            Scanner input = new Scanner(System.in);
            System.out.println("Player " + player + ", please make a move (1-9)");
            try {
                move = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: move is invalid");
                continue;
            }

            // validate input
            if (validateMoves(move, validMoves)) {
                valid = true;
            } else {
                System.out.println("Error: move is invalid");
            }
        }
        return move;
    }
}