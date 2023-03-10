/**
 * Board implementation w/o GUI, which relies on typed user input to set/update the board values.
 * As an example, a tic tac toe board is 3x3 which looks like this:
 * 
 *    |   |   
 * ___|___|___
 *    |   |   
 * ___|___|___
 *    |   |   
 *    |   |   
 * 
 * We can make this by using a two-dimensional array:
 * 
 * arr = {{. , . , .}, 
 *        {. , . , .}, 
 *        {. , . , .}}
 * 
 * therefore, in order to access each square, we can simply call the indeces, i.e.
 * 
 * [0,0] | [0,1] | [0,2]
 * ______|_______|_______
 * [1,0] | [1,1] | [1,2]
 * ______|_______|_______
 * [2,0] | [2,1] | [2,2]
 *       |       |       
 * 
 */

import java.util.Arrays;

public class Board {
    private int row;
    private int col;
    private char[][] board;
    
    // constructor
    Board() {
        this.row = 0;
        this.col = 0;
    }

    Board(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // methods
    public void buildBoard() {
        // builds an empty board (filled with ' ') with 2d array as explained above
        char newBoard[][] = new char[this.row][this.col];
        for (char[] col: newBoard) {
            Arrays.fill(col, ' ');
        }
        this.board = newBoard;
    }

    public char[][] getBoard() {
        return this.board;
    }

    public void printBoard() {
        // prints the board with the same format as explained above
        int rownum = 0, colnum;

        /**
         * The tic tac toe board, as an example
         * Line 1:   1 | 2 | 3     
         * Line 2:  ___|___|___
         * Line 3:   4 | 5 | 6 
         * Line 4:  ___|___|___
         * Line 5:   7 | 8 | 9 
         * Line 6:     |   |   
         */
        for (char[] row: this.board) {

            // prints the upper part of a row (lines 1, 3, 5)
            colnum = 0;
            for (char value: row) {
                System.out.print(" " + value + " ");

                colnum += 1;
                if (colnum < this.col) {
                    System.out.print("|");
                }
            }
            
            // prints the lower part of a row
            colnum = 1;
            rownum += 1;
            if (rownum < this.row) {
                // all lower part rows except the last row (lines 2, 4)
                System.out.print("\n___");
                while (colnum < this.col) {
                    colnum += 1;
                    System.out.print("|___");
                }
            } else {
                // the last lower part column (line 6)
                System.out.print("\n   ");
                while (colnum < this.col) {
                    colnum += 1;
                    System.out.print("|   ");
                }
            }
            System.out.print("\n");
        }
    }

    public void updateBoard(char newVal, int loc) {
        /**
         * loc is an integer from 1 to n corresponding to the location of the board, i.e.
         *  1 | 2 | 3 
         * ___|___|___
         *  4 | 5 | 6 
         * ___|___|___
         *  7 | 8 | 9 
         *    |   |   
         * for a 3x3 board.
         */
        int colLoc = (loc - 1) / this.col;
        int rowLoc = (loc - 1) % this.col;
        this.board[colLoc][rowLoc] = newVal;
    }

    public void updateBoard(char newVal, int rowLoc, int colLoc) {
        this.board[colLoc][rowLoc] = newVal;
    }
}


/* NOTE: The XO name in this code is syonymous with tic tac toe */
class XOBoard extends Board {
    public static final int XOSIZE = 3;

    XOBoard() {
        super(XOSIZE, XOSIZE);
    }

    public void updateXOBoard(int player, int move) {
        // updates tic tac toe board based on player move.
        // move is an integer from 1 to 9 corresponding to the location of the board,
        // player is an integer, either 1 or 2, with player 1 corresponding to 'X' and 2 to 'O'.

        char newVal;
        if (player == 1) {
            newVal = 'X';
        } else {
            newVal = 'O';
        }

        super.updateBoard(newVal, move);
    }
}

class ConnectFourBoard extends Board {

    public static final int ROWS = 6, COLS = 7;

    ConnectFourBoard() {
        super(ROWS, COLS);
    }

    public void updateConnectFourBoard(int player, int move, int[] moveCounter) {
        // updates connect four board based on player move.
        // move is an integer from 1 to 7 corresponding to the location of the board,
        // player is an integer, either 1 or 2, with player 1 corresponding to 'X' and 2 to 'O'.

        char newVal;
        if (player == 1) {
            newVal = 'X';
        } else {
            newVal = 'O';
        }

        // need to make the move "drop down" all the way to the bottom-most unoccupied location
        int rowLoc = move - 1;
        int colLoc = ROWS - moveCounter[rowLoc];

        super.updateBoard(newVal, rowLoc, colLoc);
    }
}