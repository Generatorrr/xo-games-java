package io.game.xo.controllers;

import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Point;
import io.game.xo.model.exceptions.InvalidPointException;

public class CurrentMoveController {

    public Figure currentMove(final Field field) {
        int countFigure = 0;
        for (int x = 0; x < field.getSize(); x++) {
            countFigure += countFiguresInRow(field, x);
        }
        if (countFigure == field.getSize() * field.getSize())
            return null;
        return countFigure % 2 == 0 ? Figure.X : Figure.O;
    }

    private int countFiguresInRow(final Field field, final int row) {
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
