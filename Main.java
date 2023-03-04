import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // 1: BUILD THE BOARD
        Board gameBoard = new Board();
        char XOboard[][] = gameBoard.buildBoard();
        gameBoard.printBoard(XOboard);

        // 2: PLAYER INPUT
        /* after printing the empty board, the program then prompts the players to make a move.
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


        PlayerInput gameInput = new PlayerInput();
        
        // we are going to use this array to check for valid moves 
        int validMoves[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // and this to determine whether it's player 1 or player 2's turn
        int player = 1;

        while (validMoves.length > 0) {
            // get input    
            int move = gameInput.getInput(player, validMoves);
            validMoves = gameInput.updateValidMoves(move, validMoves);

            // update and print board
            XOboard = gameBoard.updateBoard(player, move, XOboard);
            System.out.println("");  // line skip for formatting purposes
            gameBoard.printBoard(XOboard);


            // 3: CHECK WIN CONDITION
            // Whenever there are three X's or O'x in a row, horizontally, diagonally,
            // or vertically, that player wins
            WinCondition gameWin = new WinCondition();
            if (gameWin.checkWin(XOboard)) {
                System.out.println("Player " + player + " victory!");
                break;
            }
            
            // update player
            player = (player % 2) + 1;
        }


        // 4: FINAL STEP
        // if both players run out of moves, a draw is declared
        if (validMoves.length == 0 && player == 2) {
            System.out.println("Draw!");
        }
        
        // the end!
    }
}





