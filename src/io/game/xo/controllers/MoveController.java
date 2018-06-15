package io.game.xo.controllers;

import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Point;
import io.game.xo.model.exceptions.AlreadyOccupiedException;
import io.game.xo.model.exceptions.InvalidPointException;


public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException, AlreadyOccupiedException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }

}
