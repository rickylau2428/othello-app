package model;

import static model.State.*;

// Holds information for each game piece on the board (i.e. its position and current status)
public class GamePiece {
    private State state;
    private int position;

    // EFFECTS: Initializes a game piece with the given state and position
    public GamePiece() {

    }

    // getters:
    public int getPosition() {
        return this.position;
    }

    public State getState() {
        return this.state;
    }

    // setters:
    public void setState(State state) {
        this.state = state;
    }

    // MODIFIES: this
    // EFFECTS: Changes this.state from BLACK to WHITE or vice versa. Does nothing
    //          if this.state is EMPTY.
    public void flip() {
        if (state.equals(BLACK)) {
            state = WHITE;
        } else {
            state = BLACK;
        }
    }
}