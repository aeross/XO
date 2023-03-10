public abstract class WinCondition {
    // based on the board, check if any player has won
    public abstract boolean checkWin(char[][] board);
}


class XOWin extends WinCondition {

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
         * to keep things simple, I'm just gonna do this the "dumb" way,
         * tic tac toe is simple enough that I don't have to spend many hours coding this part
         */

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


class ConnectFourWin extends WinCondition {

    public boolean checkWin(char[][] board) {
        /**
         * Unlike tic tac toe, which has nine different win conditions, 
         * Connect Four has...um, too many to count. (Probably hundreds?)
         * 
         *  [0,0] | [0,1] | [0,2] | [0,3] | [0,4] | [0,5] | [0,6] 
         * _______|_______|_______|_______|_______|_______|_______
         *  [1,0] | [1,1] | [1,2] | [1,3] | [1,4] | [1,5] | [1,6] 
         * _______|_______|_______|_______|_______|_______|_______
         *  [2,0] | [2,1] | [2,2] | [2,3] | [2,4] | [2,5] | [2,6] 
         * _______|_______|_______|_______|_______|_______|_______
         *  [3,0] | [3,1] | [3,2] | [3,3] | [3,4] | [3,5] | [3,6] 
         * _______|_______|_______|_______|_______|_______|_______
         *  [4,0] | [4,1] | [4,2] | [4,3] | [4,4] | [4,5] | [4,6] 
         * _______|_______|_______|_______|_______|_______|_______
         *  [5,0] | [5,1] | [5,2] | [5,3] | [5,4] | [5,5] | [5,6] 
         *        |       |       |       |       |       |
         * 
         * Checking the win the same way as I did before would get real ugly.
         * Therefore, we need some kind of iteration to check the win.
         */
        
         
         // horizontal check -- i is constant, j increases by 1
        for (int i = 0; i < ConnectFourBoard.ROWS; i++) {
            for (int j = 0; j < ConnectFourBoard.COLS; j++) {
                try {
                    if (board[i][j] != ' '           && board[i][j] == board[i][j+1] && 
                        board[i][j] == board[i][j+2] && board[i][j] == board[i][j+3]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        // vertical check -- i increases by 1, j is constant
        for (int i = 0; i < ConnectFourBoard.ROWS; i++) {
            for (int j = 0; j < ConnectFourBoard.COLS; j++) {
                try {
                    if (board[i][j] != ' '           && board[i][j] == board[i+1][j] && 
                        board[i][j] == board[i+2][j] && board[i][j] == board[i+3][j]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    break;
                }
            }
        }

        // upward diagonal check -- i decreases by 1, j increases by 1
        for (int i = 0; i < ConnectFourBoard.ROWS; i++) {
            for (int j = 0; j < ConnectFourBoard.COLS; j++) {
                try {
                    if (board[i][j] != ' '             && board[i][j] == board[i-1][j+1] && 
                        board[i][j] == board[i-2][j+2] && board[i][j] == board[i-3][j+3]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }

        // downward diagonal check -- i increases by 1, j increases by 1
        for (int i = 0; i < ConnectFourBoard.ROWS; i++) {
            for (int j = 0; j < ConnectFourBoard.COLS; j++) {
                try {
                    if (board[i][j] != ' '             && board[i][j] == board[i+1][j+1] && 
                        board[i][j] == board[i+2][j+2] && board[i][j] == board[i+3][j+3]) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }
    
        return false;   
    }
}
