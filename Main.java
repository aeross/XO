import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // 1: BUILDING THE BOARD
        // call an object from BuildBoard class
        BuildBoard gameBoard = new BuildBoard();

        // build the tic tac toe board
        char board[][] = gameBoard.buildBoard();

        // as the first step, print the empty board
        gameBoard.printBoard(board);


        // 2: PLAYER INPUT
        // after printing the empty board, the program then prompts
        // the players to make a move.
        // note: the general convention is first player is always 'X', and the second player 'O'.

        // a question about this might be raised: how is the player going to input?
        // and how is the program going to interpret the input?

        /**
        to keep things simple, the player simply has to type a number between 1 to 9,
        with each number representing these locations on the board:

         1 | 2 | 3 
        ___|___|___
         4 | 5 | 6 
        ___|___|___
         7 | 8 | 9 
           |   |   

        for example, if the player inputs number 7, the board would look like this:

           |   |   
        ___|___|___
           |   |   
        ___|___|___
         X |   |   
           |   |   
        
        After getting the input, we first have to check whether it is valid. Checking for
        the first player's move is easy -- we simply just have to check whether the input is
        an integer from 1 to 9 inclusive. But the move following that, we need to also check
        that there are no repeated moves, i.e. if a player has already picked 3, 3 cannot be
        picked again by either player.
        **/


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
            board = gameBoard.updateBoard(player, move, board);
            System.out.println("");  // line skip for formatting purposes
            gameBoard.printBoard(board);


            // 3: CHECK WIN CONDITION
            // The last step to finishing the program is to check win condition.
            // Whenever there are three X's or O'x in a row, horizontally, diagonally,
            // or vertically, that player has won.
            WinCondition gameWin = new WinCondition();
            if (gameWin.checkWin(board)) {
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