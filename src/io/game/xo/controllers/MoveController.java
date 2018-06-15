package io.game.xo.controllers;

import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Point;
import io.game.xo.model.exceptions.AlreadyOccupiedException;
import io.game.xo.model.exceptions.InvalidPointException;


public class MoveController {

    /**
     * Method to set figure to game's field
     * @param field - game's field
     * @param point - point to choose coordinate to set into field
     * @param figure - figure to set into field
     * @throws InvalidPointException - throws if you tried to set figure with point coordinates out of field size
     * @throws AlreadyOccupiedException - throws if you tried to set figure with not empty coordinates
     */
    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException, AlreadyOccupiedException {

        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }
        field.setFigure(point, figure);

    }

}
