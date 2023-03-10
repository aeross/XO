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
 * then, either player cannot pick 7 again as it has already been picked.
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

class XOPlayerInput {

    private static final int[] VALIDMOVES = {1, 2, 3, 4, 5, 6, 7, 8, 9};  // all valid moves

    public int[] getValidMoves() {
        return VALIDMOVES;
    }

    // declares a move as valid if the move is in validMoves
    public boolean validateMoves(int move, int[] validMoves) {
        if (ArrayManipulation.isin(move, validMoves)) {
            return true;
        } else {
            return false;
        }
    }

    // removes picked move from validMoves
    public int[] updateValidMoves(int move, int[] validMoves) {
        return ArrayManipulation.remove(move, validMoves);
    }
    
    // gets input from player, checks its validity, and returns the move if valid
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
                    System.out.println("Error: invalid move");
                }
            } catch (Exception e) {
                System.out.println("Error: invalid move");
            }
        }
        return move;
    }
}


class ConnectFourPlayerInput {

    // in connect 4, you can pick the same number multiple times until the column fills up,
    // or in a standard 6x7 connect 4, until the number has been picked 6 times by either player,
    // so we'll use these to keep track of it
    private static final int[] MOVECOUNTER = new int[ConnectFourBoard.COLS];

    public int[] getMoveCounter() {
        return MOVECOUNTER;
    }

    public boolean validateMoves(int move, int[] moveCounter) {
        // if the move is between 1-7 and has picked less than 6 times, then it is a valid move
        try {
            if ((moveCounter[move - 1] < ConnectFourBoard.ROWS)) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    public int[] updateValidMoves(int move, int[] moveCounter) {
        moveCounter[move - 1] += 1;
        return moveCounter;
    }
    
    public int getInput(int[] moveCounter, int player) {
        int move = 0;
        boolean valid = false;

        while (!valid) {
            // get input
            Scanner input = new Scanner(System.in);
            System.out.println("Player " + player + ", please make a move (1-7)");
            try {
                move = input.nextInt();
                // validate input
                if (validateMoves(move, moveCounter)) {
                    valid = true;
                } else if (move == 0) {
                    System.exit(0);
                } else {
                    System.out.println("Error: invalid move");
                }
            } catch (Exception e) {
                System.out.println("Error: invalid move");
            }
        }
        return move;
    }
}