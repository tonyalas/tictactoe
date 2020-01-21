/**
 * a block represents a playable cell and maintains a state attribute that is either EMPTY, occupied by X, or occupied by O). 
 * By default it is EMPTY, would require setState, getState, and a toString where EMPTY is just a blank space.
 * @author Tony Alas
 * @version 1.0 - November 19, 2018
 * Student ID: 104754179
 */
public class Block {
    // attribute(s):

    /** this will store the current state of the block. */
    private String state;

    // methods:

    /** a default constructor */
    public Block() {
        //the default of a block is EMPTY
        state = "EMPTY";
    }

    /** overloaded constructor 
     * @param String state - the new state to change to
    */
    public Block(String state) {
        this();
        setState(state);
    }

    /** this will set the current state
     * @param String state - the state to be set
     */
    public void setState(String state) {
        //if the state given is an x, it is a valid move
        if(state.equalsIgnoreCase("x")) {
            this.state = state;
        }
        //if the state given is an o, it is also a valid move
        else if(state.equalsIgnoreCase("o")) {
            this.state = state;
        }
        //if it is neither of those, default it to an empty space
        else {
            this.state = "EMPTY";
        }
    }

    /** this will get the current state of the block 
     * @return the current state
    */
    public String getState() {
        return state;
    }

    /** overridden toString method that displays the current state */
    public String toString() {
        if(state.equalsIgnoreCase("x")) {
            return "x";
        }
        //if the state given is an o, it is also a valid move
        else if(state.equalsIgnoreCase("o")) {
            return "o";
        }
        return " ";
    }

}