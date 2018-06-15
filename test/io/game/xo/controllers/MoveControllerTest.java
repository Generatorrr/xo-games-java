package io.game.xo.controllers;

import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Point;
import io.game.xo.model.exceptions.AlreadyOccupiedException;
import io.game.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoveControllerTest {

    @Test
    public void applyFigure() {
        final MoveController moveController = new MoveController();
        final Field field = new Field(3);
        final Point point = new Point(0, 0);
        final Figure figure = Figure.X;
        try {
            moveController.applyFigure(field, point, figure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            e.printStackTrace();
            fail();
        }
        try {
            final Figure settedFigure = field.getFigure(point);
            assertEquals(figure, settedFigure);
        } catch (InvalidPointException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void applyFigureToNotEmptyField() {
        final MoveController moveController = new MoveController();
        final Field field = new Field(3);
        final Point point = new Point(0, 0);
        final Figure figure = Figure.X;
        try {
            moveController.applyFigure(field, point, figure);
            moveController.applyFigure(field, point, Figure.O);
            fail();
        } catch (AlreadyOccupiedException e) {}
          catch (InvalidPointException e) {
            fail();
        }
    }

}