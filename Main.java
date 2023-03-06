import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        // 1: BUILD THE BOARD
        XOBoard gameBoard = new XOBoard();
        char board[][] = gameBoard.buildBoard();
        gameBoard.printBoard(board);

        // 2: PLAYER MOVE
        XOPlayerInput gameInput = new XOPlayerInput();
        // we are going to use this array to check for valid moves 
        int validMoves[] = gameInput.getValidMoves();
        // and this to determine whether it's player 1 or player 2's turn
        int player = gameInput.getPlayer();
        
        
        while (validMoves.length > 0) {
            // get input    
            int move = gameInput.getInput(validMoves, player);

            // update valid moves
            validMoves = gameInput.updateValidMoves(move, validMoves);

            // update and print board
            board = gameBoard.updateXOBoard(player, move, board);
            System.out.println("");  // line skip for formatting purposes
            gameBoard.printBoard(board);

            // 3: CHECK WIN CONDITION
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





