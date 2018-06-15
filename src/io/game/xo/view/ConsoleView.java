package io.game.xo.view;

import io.game.xo.controllers.CurrentMoveController;
import io.game.xo.controllers.MoveController;
import io.game.xo.controllers.WinnerController;
import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Game;
import io.game.xo.model.Point;
import io.game.xo.model.exceptions.AlreadyOccupiedException;
import io.game.xo.model.exceptions.InvalidPointException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {

    private final CurrentMoveController currentMoveController = new CurrentMoveController();
    private final WinnerController winnerController = new WinnerController();
    private final MoveController moveController = new MoveController();

    /**
     * Show field in console
     * @param game - game knows all about field and players
     */
    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName());
        final Field field = game.getField();

        for (int x = 0; x < field.getSize(); x++) {
            if(x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    /**
     * Game's turn action
     * @param game - game knows all about field and players
     * @return true - game is go on, false - game over
     */
    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure winner = winnerController.getWinner(field);
        // winner != null - we have a winner
        if (winner != null) {
            // Print congratulations and switch off the game
            System.out.format("We have a winner!!! Congratulations for: %s\n", winner);
            return false;
        }
        final Figure currentFigure = currentMoveController.currentMove(field);
        // currentFigure == null - all slots are not empty and we haven't got a winner - game over
        if (currentFigure == null) {
            // Print message and switch off the game
            System.out.println("No winner and no moves available!");
            return false;
        }
        System.out.format("Please, enter move point for: %s\n", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            // Prints error message and ask current player to input coordinates
            System.out.println("Point is invalid!");
        }
        return true;
    }

    /**
     * Get coordinates for next player's turn
     * @return point (coordinate) of field's slot user want to insert figure
     */
    private Point askPoint() {
        // Accept that user will be insert coordinate starts from 1;
        return new Point(askCoordinate("X") - 1, askCoordinate("Y") - 1);
    }

    /**
     * Await for user input coordinate
     * @param coordinateName - name of coordinate need to input
     * @return needed coordinate
     */
    private int askCoordinate(final String coordinateName) {
        System.out.format("Please, input %s:", coordinateName);
        final Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (final InputMismatchException e) {
            // If user input wrong data -> print error message and ask one more time
            System.out.println("Input valid integer, please");
            return askCoordinate(coordinateName);
        }
    }

    /**
     * Method for print field's row with figures
     * @param field - game's field
     * @param x - number of current field's row
     */
    private void printLine(final Field field, final int x) {
        // Iterate over field row's elements
        for (int y = 0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (final InvalidPointException e) {
                // Forbidden program's behavior -> print error in console and shot down program
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            // Print figure or empty space if there is no figure in field's slot
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * Method to separate field's rows
     */
    private void printSeparator() {
        System.out.println("~~~~~~~~~~~");
    }

}
