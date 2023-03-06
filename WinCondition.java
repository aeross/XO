public abstract class WinCondition {
    // based on the board, check if any player has won
    public abstract boolean checkWin(char[][] board);
}
/**
 * The reason why I'm declaring a superclass is because not only for XO,
 * this class can be extended for other suitable board games as well such as Connect Four,
 * i.e., class ConnectFourWinCondition extends WinCondition { ... }.
 * Same reason applies for the classes in Board.java and PlayerInput.java.
 */

class XOWinCondition extends WinCondition {

    public boolean checkWin(char[][] board) {
        /**
         * 
         * Looking at the board as reference,
         * 
         * [0,0] | [0,1] | [0,2]
         * ______|_______|_______
         * [1,0] | [1,1] | [1,2]
         * ______|_______|_______
         * [2,0] | [2,1] | [2,2]
         *       |       |       
         * 
         * a win if possible if there are equivalent symbols on:
         * - board[0][0], board[0][1], board[0][2]  // vertical
         * - board[1][0], board[1][1], board[1][2]  // vertical
         * - board[2][0], board[2][1], board[2][2]  // vertical
         * - board[0][0], board[1][0], board[2][0]  // horizontal
         * - board[0][1], board[1][1], board[2][1]  // horizontal
         * - board[0][2], board[1][2], board[2][2]  // horizontal
         * - board[0][0], board[1][1], board[2][2]  // diagonal
         * - board[0][2], board[1][1], board[2][0]  // diagonal
         * 
         * to keep things simple, I'm just gonna do this the "dumb" way
         * honestly if this is connect 4 or gomoku, doing it this way would get the code real ugly
         * but tic tac toe is simple enough that I don't have to spend many hours coding this part
         **/

        if ((board[0][0] != ' ') && (board[0][0] == board[0][1]) && (board[0][1] == board[0][2])) {
            return true;
        }
        if ((board[1][0] != ' ') && (board[1][0] == board[1][1]) && (board[1][1] == board[1][2])) {
            return true;
        }
        if ((board[2][0] != ' ') && (board[2][0] == board[2][1]) && (board[2][1] == board[2][2])) {
            return true;
        }
        if ((board[0][0] != ' ') && (board[0][0] == board[1][0]) && (board[1][0] == board[2][0])) {
            return true;
        }
        if ((board[0][1] != ' ') && (board[0][1] == board[1][1]) && (board[1][1] == board[2][1])) {
            return true;
        }
        if ((board[0][2] != ' ') && (board[0][2] == board[1][2]) && (board[1][2] == board[2][2])) {
            return true;
        }
        if ((board[0][0] != ' ') && (board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) {
            return true;
        }
        if ((board[0][2] != ' ') && (board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) {
            return true;
        }

        return false;        
    }
}