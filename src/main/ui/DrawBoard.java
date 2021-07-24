package ui;

import model.GameBoard;
import model.GamePiece;

import java.util.List;

import static model.GameBoard.SIDE_LENGTH;

// Prints a board state to console
public class DrawBoard {
    public static final String WHITE_CIRCLE = "⭘";
    public static final String BLACK_CIRCLE = "●";
    public static final String LINE = "+---";
    public static final String SIDE_LINE = "|";

    private final List<GamePiece> board;

    // EFFECTS: Constructs a drawer with access to the game board
    public DrawBoard(List<GamePiece> board) {
        this.board = board;
    }

    // EFFECTS: prints the entire board to the console
    public void printBoard() {
        printLetters();
        for (int i = 0; i < GameBoard.SIDE_LENGTH; i++) {
            printLine();
            printNumber(i);
            for (int j = 0; j < SIDE_LENGTH; j++) {
                System.out.print(SIDE_LINE + " " + retrievePiece(GameBoard.SIDE_LENGTH * i + j) + " ");
            }
            System.out.println(SIDE_LINE);
        }
        printLine();
    }

    // EFFECTS: Returns the appropriate character to console based on contents of board at
    //          positions: " " for EMPTY, WHITE_CIRCLE for WHITE, BLACK_CIRCLE for BLACK
    private String retrievePiece(int position) {
        switch (board.get(position).getState()) {
            case WHITE:
                return WHITE_CIRCLE;
            case BLACK:
                return BLACK_CIRCLE;
            default:
                return " ";
        }
    }

    // EFFECTS: Prints number denominations along the side of the board
    private void printNumber(int num) {
        System.out.print(" " + (num + 1) + " ");
    }

    // EFFECTS: Prints a horizontal line spanning the board
    private void printLine() {
        printTab();
        for (int i = 0; i < SIDE_LENGTH; i++) {
            System.out.print(LINE);
        }
        System.out.println("+");
    }

    // EFFECTS: Prints letters starting from 'A' across the top of the board
    private void printLetters() {
        printTab();
        int start = 'A';
        char toPrint;
        for (int i = 0; i < SIDE_LENGTH; i++) {
            toPrint = (char) (start + i);
            System.out.print("  " + toPrint + " ");
        }
        System.out.println();
    }

    // EFFECTS: Prints three blank spaces to the console
    private void printTab() {
        System.out.print("   ");
    }
}
