import java.util.Scanner;

public class PlayerInput {

    static ArrayManipulation myArray = new ArrayManipulation();

    // a move is valid if:
    // the input is an integer between 1 to 9 inclusive, and
    // no repeated moves, i.e. if 3 is already picked it can't be picked again
    static boolean validateMoves(int move, int validMoves[]) {
        if (myArray.isin(move, validMoves)) {
            return true;
        } else {
            return false;
        }
    }

    // once a player makes a valid move, update the validMoves array
    static int[] updateValidMoves(int move, int validMoves[]) {
        return myArray.remove(move, validMoves);
    }
    

    static int getInput(int player, int validMoves[]) {
        // gets input from player and checks for validity
        // int player can only take value of either 1 or 2
        int move = 0;
        boolean valid = false;

        while (!valid) {
            // get input
            Scanner input = new Scanner(System.in);
            System.out.println("Player " + player + ", please make a move (1-9)");
            try {
                move = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: move is invalid");
                continue;
            }

            // validate input
            if (validateMoves(move, validMoves)) {
                valid = true;
            } else {
                System.out.println("Error: move is invalid");
            }
        }
        return move;
    }
}