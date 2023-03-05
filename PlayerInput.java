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

public class PlayerInput {

    private static ArrayManipulation myArray = new ArrayManipulation();

    // a move is valid if:
    // the input is an integer between 1 to 9 inclusive, and
    // no repeated moves, i.e. if 3 is already picked it can't be picked again
    private static boolean validateMoves(int move, int validMoves[]) {
        if (myArray.isin(move, validMoves)) {
            return true;
        } else {
            return false;
        }
    }

    // once a player makes a valid move, update the validMoves array
    public int[] updateValidMoves(int move, int validMoves[]) {
        return myArray.remove(move, validMoves);
    }
    

    public int getInput(int player, int validMoves[]) {
        // gets input from player and checks for validity
        // int player can only take value of either 1 or 2
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