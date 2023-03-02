public class WinCondition {

    boolean checkWin(char[][] board) {
        /**

        Looking at the board as reference,

        [0,0] | [0,1] | [0,2]
        ______|_______|_______
        [1,0] | [1,1] | [1,2]
        ______|_______|_______
        [2,0] | [2,1] | [2,2]
              |       |       

        a win if possible if there are equivalent symbols on:
        - board[0][0], board[0][1], board[0][2]  // vertical
        - board[1][0], board[1][1], board[1][2]  // vertical
        - board[2][0], board[2][1], board[2][2]  // vertical
        - board[0][0], board[1][0], board[2][0]  // horizontal
        - board[0][1], board[1][1], board[2][1]  // horizontal
        - board[0][2], board[1][2], board[2][2]  // horizontal
        - board[0][0], board[1][1], board[2][2]  // diagonal
        - board[0][2], board[1][1], board[2][0]  // diagonal

        **/

        if ((board[0][0] != 0) && (board[0][0] == board[0][1]) && (board[0][1] == board[0][2])) {
            return true;
        }
        if ((board[1][0] != 0) && (board[1][0] == board[1][1]) && (board[1][1] == board[1][2])) {
            return true;
        }
        if ((board[2][0] != 0) && (board[2][0] == board[2][1]) && (board[2][1] == board[2][2])) {
            return true;
        }
        if ((board[0][0] != 0) && (board[0][0] == board[1][0]) && (board[1][0] == board[2][0])) {
            return true;
        }
        if ((board[0][1] != 0) && (board[0][1] == board[1][1]) && (board[1][1] == board[2][1])) {
            return true;
        }
        if ((board[0][2] != 0) && (board[0][2] == board[1][2]) && (board[1][2] == board[2][2])) {
            return true;
        }
        if ((board[0][0] != 0) && (board[0][0] == board[1][1]) && (board[1][1] == board[2][2])) {
            return true;
        }
        if ((board[0][2] != 0) && (board[0][2] == board[1][1]) && (board[1][1] == board[2][0])) {
            return true;
        }

        return false;        
    }

}