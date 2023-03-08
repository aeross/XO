import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void runXO() {
        // 1: BUILD THE BOARD
        XOBoard gameBoard = new XOBoard();
        gameBoard.buildBoard();
        gameBoard.printBoard();

        // 2: PLAYER MOVE
        XOPlayerInput gameInput = new XOPlayerInput();
        // we are going to use this array to check for valid moves 
        int validMoves[] = gameInput.getValidMoves();
        // and this to determine whether it's player 1 or player 2's turn
        int player = 1;
        
        
        while (validMoves.length > 0) {
            // get input    
            int move = gameInput.getInput(validMoves, player);

            // update valid moves
            validMoves = gameInput.updateValidMoves(move, validMoves);

            // update and print board
            gameBoard.updateXOBoard(player, move);
            System.out.println("");  // line skip for formatting purposes
            gameBoard.printBoard();

            // 3: CHECK WIN CONDITION
            XOWin gameWin = new XOWin();
            if (gameWin.checkWin(gameBoard.getBoard())) {
                System.out.println("Player " + player + " victory!");
                break;
            }
            
            // update player
            player = (player % 2) + 1;
        }

        // 4: FINAL STEP
        // if both players run out of moves, a draw is declared
        if (validMoves.length == 0 && player == 2) {
            // player == 2 is needed in case player 1 wins on the last move
            System.out.println("Draw!");
        }
        // the end!
    }


    public static void runConnectFour() {
        // mostly similar to the code in runXO()
        // 1: BUILD THE BOARD
        ConnectFourBoard gameBoard = new ConnectFourBoard();
        gameBoard.buildBoard();
        gameBoard.printBoard();

        // 2: PLAYER MOVE
        ConnectFourPlayerInput gameInput = new ConnectFourPlayerInput();
        int validMoves[] = gameInput.getValidMoves();
        int player = 1;
        
        
        while (validMoves.length > 0) {
            int move = gameInput.getInput(validMoves, player);
            validMoves = gameInput.updateValidMoves(move, validMoves);
            gameBoard.updateConnectFourBoard(player, move);
            System.out.println("");
            gameBoard.printBoard();

            // 3: CHECK WIN CONDITION
            XOWin gameWin = new XOWin();
            if (gameWin.checkWin(gameBoard.getBoard())) {
                System.out.println("Player " + player + " victory!");
                break;
            }
            player = (player % 2) + 1;
        }

        // 4: FINAL STEP
        if (validMoves.length == 0 && player == 1) {
            System.out.println("Draw!");
        }
    }


    public static void main(String[] args) {
        runConnectFour();
    }
}





