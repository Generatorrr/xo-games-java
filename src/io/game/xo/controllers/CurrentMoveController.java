package io.game.xo.controllers;

import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Point;
import io.game.xo.model.exceptions.InvalidPointException;

public class CurrentMoveController {

    /**
     * This method need to set figure that have to be set in this turn
     * @param field - game's field
     * @return Figure - current player's figure
     */
    public Figure currentMove(final Field<Figure> field) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            countFigure += countFiguresInRow(field, x);
        }
        if (countFigure == field.getSize() * field.getSize())
            return null;
        return countFigure % 2 == 0 ? Figure.X : Figure.O;
    }

    /**
     * Supporting method for currentMove method
     * @param field - game's field
     * @param row - row of the game's field now iterating over
     * @return figures count in the current iterating game's field row
     */
    private int countFiguresInRow(final Field<Figure> field, final int row) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null)
                    countFigure++;
            } catch (InvalidPointException e) {
                e.printStackTrace();
            }
        }
        return countFigure;
    }

}
