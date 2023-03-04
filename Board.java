/**
 * A tic tac toe board is 3x3 which looks like this:
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
 * A finished (tied) game would look something like this:
 * 
 *  X | O | X 
 * ___|___|___
 *  O | X | O 
 * ___|___|___
 *  O | X | X 
 *    |   |   
 * 
 **/

 public class Board {
    private int size = 3;

    char[][] buildBoard() {
        // builds a board with 2d array as explained above
        char board[][] = new char[size][size];
        return board;
    }

    void printBoard(char[][] board) {
        // prints the board with the same format as explained above
        int colnum = 0, rownum;
        for (char[] col: board) {
            rownum = 0;

            for (char i: col) {
                if (i == 'X' || i == 'O') {
                    System.out.print(" " + i + " ");
                } else {
                    System.out.print("   ");
                }

                rownum += 1;
                if (rownum < size) {
                    System.out.print("|");
                }
            }

            colnum += 1;
            if (colnum < size) {
                System.out.println("\n___|___|___");
            } else {
                System.out.println("\n   |   |   ");
            }
        }
    }

    char[][] updateBoard(int player, int move, char[][] board) {
        // updates the board based on player move.
        // move is an integer from 1 to 9 corresponding to the location of the board,
        // player is an integer, either 1 or 2.

        char symbol;
        if (player == 1) {
            symbol = 'X';
        } else {
            symbol = 'O';
        }

        switch(move) {
            case 1:
                board[0][0] = symbol;
                break;
            case 2:
                board[0][1] = symbol;
                break;
            case 3:
                board[0][2] = symbol;
                break;
            case 4:
                board[1][0] = symbol;
                break;
            case 5:
                board[1][1] = symbol;
                break;
            case 6:
                board[1][2] = symbol;
                break;
            case 7:
                board[2][0] = symbol;
                break;
            case 8:
                board[2][1] = symbol;
                break;
            case 9:
                board[2][2] = symbol;
                break;
        }
        return board;
    }
}
