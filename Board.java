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
 * therefore, in order to access each cell (I'm calling them cells, 
 * don't know if there's an actual name), we can simply call the indeces, i.e.
 * 
 * [0,0] | [0,1] | [0,2]
 * ______|_______|_______
 * [1,0] | [1,1] | [1,2]
 * ______|_______|_______
 * [2,0] | [2,1] | [2,2]
 *       |       |       
 * 
 * To keep things simple (and avoid two-dimensional confusion), I choose for 
 * the naming system of each cell to be a number in ascending order starting from 1.
 * For example, a 3x3 board has numbers from 1 to 9,
 * with each number representing these locations on the board:
 * 
 *  1 | 2 | 3 
 * ___|___|___
 *  4 | 5 | 6 
 * ___|___|___
 *  7 | 8 | 9 
 *    |   |   
 * 
 * 
 * Note: this Board class assumes a square board (equal number of rows and columns)
 **/

import java.util.Arrays;

public class Board {
    private int size;
    
    // constructor
    Board() {
        this.size = 0;
    }

    Board(int size) {
        this.size = size;
    }

    // methods
    public char[][] buildBoard() {
        // builds a board with 2d array as explained above and fills it with ' '
        char board[][] = new char[this.size][this.size];
        for (char[] col: board) {
            Arrays.fill(col, ' ');
        }
        return board;
    }

    public void printBoard(char[][] board) {
        // prints the board with the same format as explained above
        int colnum = 0, rownum;
        for (char[] col: board) {

            // prints the upper part of a column
            rownum = 0;
            for (char i: col) {
                System.out.print(" " + i + " ");

                rownum += 1;
                if (rownum < this.size) {
                    System.out.print("|");
                }
            }
            
            // prints the lower part of a column
            rownum = 1;
            colnum += 1;
            if (colnum < this.size) {
                System.out.print("\n___");
                while (rownum < this.size) {
                    rownum += 1;
                    System.out.print("|___");
                }
            } else {
                System.out.print("\n   ");
                while (rownum < this.size) {
                    rownum += 1;
                    System.out.print("|   ");
                }
            }
            System.out.print("\n");
        }
    }

    char[][] updateBoard(char newVal, int loc, char[][] board) {
        // updates the value of the board
        int length = this.size;

        int colLoc = (loc - 1) / length;
        int rowLoc = (loc - 1) % length;
        board[colLoc][rowLoc] = newVal;

        return board;
    }
}



class XOBoard extends Board {
    // XO, another name for tic tac toe

    private static final int XOSIZE = 3;

    XOBoard() {
        super(XOSIZE);
    }

    char[][] updateXOBoard(int player, int move, char[][] board) {
        // updates tic tac toe board based on player move.
        // move is an integer from 1 to 9 corresponding to the location of the board,
        // player is an integer, either 1 or 2, with player 1 corresponding to 'X' and 2 to 'O'.

        char newVal;
        if (player == 1) {
            newVal = 'X';
        } else {
            newVal = 'O';
        }

        board = super.updateBoard(newVal, move, board);
        return board;
    }
}