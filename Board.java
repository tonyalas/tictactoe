/**
 * a board has or contains 9 blocks in a 2D array (3x3) that shapes the game space of tic-tac-toe. It also maintains an internal state 
 * which can be one of the following: EMPTY (the initial state of the board), X (X claims a win), Y (Y claims a win), 
 * or DRAW (where neither X nor Y can claim a win and no further moves are possible). 
 * The board has the key methods makeMove() that is called by a player making a move and getState() or 
 * updateState() that updates the state of the board after every move. It checks for a win or a draw when they occur. 
 * Note that the board instantiates and maintains all the blocks.
 * @author Tony Alas
 * @version 1.0 - November 19, 2018
 * Student ID: 104754179
 */
public class Board {
    // attributes: 

    /** this will make a 3x3 array which is the shape of the tic-tac-toe board */
    public Block blockArray[][] = new Block[3][3]; 


    /** this is the internal state */
    public String boardState;

    // methods:

    /** default constructor */
    public Board() {
        boardState = "EMPTY";
        for(int r = 0; r < 3; r++) {
            for(int c = 0; c < 3; c++) {
                blockArray[r][c] = new Block("EMPTY");
            }
        }
        //instantiate the blocks to empty here
    }

    /** this will make a move invoked by a player 
     * @param int row - the given row
     * @param int col - the given column 
     * @param String symbol - the symbol of the current player making a move
     * @return 0 if the move is available and valid, -1 if there is an error
    */
    public int makeMove(int row, int col, String symbol) {
        if(isValid(row, col) == true) {
            if(blockArray[row][col].getState().equalsIgnoreCase("EMPTY")) {
                System.out.println("\nWill now update the current board");
                //if the player that makes the move has the symbol x, then assign x to the given coordinates
                if(symbol.equalsIgnoreCase("X")) {
                    blockArray[row][col].setState("x");
                }
                else if(symbol.equalsIgnoreCase("O")) {
                    blockArray[row][col].setState("o");
                }
                return 0;
            }
            else {
                System.out.println("\nThis space is not empty and cannot be played anymore. Please try again.\n");
                return -1;
            }
        }
        //if the given row and column are not a legal play then let them know.
        else {
            System.out.println("\nIllegal play. Please try again.\n");
            return -1;
        }
    }

    /** this will make sure the given row and column given by the player is valid 
     * @param int row - the given row
     * @param int col - the given column
     * @return true if valid, false if not
    */
    public boolean isValid(int row, int col) {
        //if the given values are within range, return true
        if(0 <= row && row <=2 && 0 <= col && col <= 2) {
            return true;
        }
        //if they are not, return false
        else {
            return false;
        }
    }

    /** this will update the current state and also display it so that the user can see what they are doing 
     * @return String - the current state of the board
    */
    public String getState() {
        //prints out the board when empty
        if(boardState.equalsIgnoreCase("EMPTY")) {
            System.out.println("Please refer to this number scheme when entering a place to play your turn. (without the brackets)");
            System.out.println("" + "(0 0)" + " | " + "(0 1)" + " | " + "(0 2)");
            System.out.println("---------------------");
            System.out.println("" + "(1 0)" + " | " + "(1 1)" + " | " + "(1 2)");
            System.out.println("---------------------");
            System.out.println("" + "(2 0)" + " | " + "(2 1)" + " | " + "(2 2)\n");
        }
        //if one of the players have won then change the state of the game
        else if(hasWon() == 1) {
            setState("X");
            System.out.println("" + blockArray[0][0] + " | " + blockArray[0][1] + " | " + blockArray[0][2]);
            System.out.println("----------");
            System.out.println("" + blockArray[1][0] + " | " + blockArray[1][1] + " | " + blockArray[1][2]);
            System.out.println("----------");
            System.out.println("" + blockArray[2][0] + " | " + blockArray[2][1] + " | " + blockArray[2][2]);
        }
        else if(hasWon() == 2) {
            setState("O");
            System.out.println("" + blockArray[0][0] + " | " + blockArray[0][1] + " | " + blockArray[0][2]);
            System.out.println("----------");
            System.out.println("" + blockArray[1][0] + " | " + blockArray[1][1] + " | " + blockArray[1][2]);
            System.out.println("----------");
            System.out.println("" + blockArray[2][0] + " | " + blockArray[2][1] + " | " + blockArray[2][2]);
        }
        //if it is a draw
        else if(isDraw() == true) {
            setState("DRAW");
            System.out.println("" + blockArray[0][0] + " | " + blockArray[0][1] + " | " + blockArray[0][2]);
            System.out.println("----------");
            System.out.println("" + blockArray[1][0] + " | " + blockArray[1][1] + " | " + blockArray[1][2]);
            System.out.println("----------");
            System.out.println("" + blockArray[2][0] + " | " + blockArray[2][1] + " | " + blockArray[2][2]);
        }
        //if it is no longer EMPTY, then just print the current board
        else if(boardState.equalsIgnoreCase("IN GAME")) {
            System.out.println("" + blockArray[0][0] + " | " + blockArray[0][1] + " | " + blockArray[0][2]);
            System.out.println("----------");
            System.out.println("" + blockArray[1][0] + " | " + blockArray[1][1] + " | " + blockArray[1][2]);
            System.out.println("----------");
            System.out.println("" + blockArray[2][0] + " | " + blockArray[2][1] + " | " + blockArray[2][2]);
        }
        //return this string to let the Game class that the game is still in progress
        return boardState;
    }

    /** a simpler version to only get the state and do not change anything
     * @return String - the state of the board
     */
    public String getState2() {
        return boardState;
    }

    /** this will determine if the game is at a draw 
     * @return true if all spaces are occupied and no winner has been decided yet, false if there are still empty spaces left
    */
    public boolean isDraw() {
        //loop through each index of the block array
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col++) {
                //if an empty cell has been found then it means it is not a draw yet
                if(blockArray[row][col].getState().equals("EMPTY")) {
                    return false;
                }
            }
        }
        //if no empty cell has been found then it is a draw.
        return true;
    }

    /** this will determine if either of the players have gotten a winning move
     * @return 1 if playerX has won, 0 if playerO has won
     */
    public int hasWon() {
        //3 in-a-row for playerX
        if((blockArray[0][0].getState().equals("x")) && (blockArray[0][1].getState().equals("x")) && (blockArray[0][2].getState().equals("x"))) {
            return 1;
        }
        else if((blockArray[1][0].getState().equals("x")) && (blockArray[1][1].getState().equals("x")) && (blockArray[0][2].getState().equals("x"))) {
            return 1;
        }
        else if((blockArray[2][0].getState().equals("x")) && (blockArray[2][1].getState().equals("x")) && (blockArray[2][2].getState().equals("x"))) {
            return 1;
        }

        //3 in-a-row for playerO
        else if((blockArray[0][0].getState().equals("o")) && (blockArray[0][1].getState().equals("o")) && (blockArray[0][2].getState().equals("o"))) {
            return 2;
        }
        else if((blockArray[1][0].getState().equals("o")) && (blockArray[1][1].getState().equals("o")) && (blockArray[0][2].getState().equals("o"))) {
            return 2;
        }
        else if((blockArray[2][0].getState().equals("o")) && (blockArray[2][1].getState().equals("o")) && (blockArray[2][2].getState().equals("o"))) {
            return 2;
        }

        //3 in-a-column for playerX
        else if((blockArray[0][0].getState().equals("x")) && (blockArray[1][0].getState().equals("x")) && (blockArray[2][0].getState().equals("x"))) {
            return 1;
        }
        else if((blockArray[0][1].getState().equals("x")) && (blockArray[1][1].getState().equals("x")) && (blockArray[2][1].getState().equals("x"))) {
            return 1;
        }
        else if((blockArray[0][2].getState().equals("x")) && (blockArray[1][2].getState().equals("x")) && (blockArray[2][2].getState().equals("x"))) {
            return 1;
        }

        //3 in-a-column for playerO
        else if((blockArray[0][0].getState().equals("o")) && (blockArray[1][0].getState().equals("o")) && (blockArray[2][0].getState().equals("o"))) {
            return 2;
        }
        else if((blockArray[0][1].getState().equals("o")) && (blockArray[1][1].getState().equals("o")) && (blockArray[2][1].getState().equals("o"))) {
            return 2;
        }
        else if((blockArray[0][2].getState().equals("o")) && (blockArray[1][2].getState().equals("o")) && (blockArray[2][2].getState().equals("o"))) {
            return 2;
        }

        //3 in-a-diagonal for playerX
        else if((blockArray[0][0].getState().equals("x")) && (blockArray[1][1].getState().equals("x")) && (blockArray[2][2].getState().equals("x"))) {
            return 1;
        }

        //3 in-a-diagonal for playerO
        else if((blockArray[0][0].getState().equals("o")) && (blockArray[1][1].getState().equals("o")) && (blockArray[2][2].getState().equals("o"))) {
            return 2;
        }

        //3 in-a-alt-diagonal for playerX
        else if((blockArray[0][2].getState().equals("x")) && (blockArray[1][1].getState().equals("x")) && (blockArray[2][0].getState().equals("x"))) {
            return 1;
        }

        //3 in-a-alt-diagonal for playerO
        else if((blockArray[0][2].getState().equals("o")) && (blockArray[1][1].getState().equals("o")) && (blockArray[2][0].getState().equals("o"))) {
            return 2;
        }

        //if it is neither of these options then simply return -1
        return -1;
    }

    /** this will set the state of the current board
     * @param String boardState - the given state that will update the board
     */
    public void setState(String boardState) {
        //if the state given is an x, it is a valid move
        if(boardState.equals("X")) {
            this.boardState = boardState;
        }
        //if the state given is an o, it is also a valid move
        else if(boardState.equals("O")) {
            this.boardState = boardState;
        }
        //if it is neither of those, default it to an empty space
        else if(boardState.equals("DRAW")){
            this.boardState = boardState;
        }
        else if(boardState.equals("IN GAME")) {
            this.boardState = boardState;
        }
    }

}