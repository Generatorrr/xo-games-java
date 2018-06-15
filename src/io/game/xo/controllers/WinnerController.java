package io.game.xo.controllers;

import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Point;
import io.game.xo.model.exceptions.InvalidPointException;

public class WinnerController {

    /**
     * Method to try get winner
     * @param field - game's field
     * @return figure of winner or null if have no winner
     */
    public Figure getWinner(final Field field) {
        try {
            for (int i = 0; i < 3; i++)
                if(check(field, new Point(i, 0), p -> new Point(p.x, p.y +1)))
                    return field.getFigure(new Point(i, 0));

            for (int i = 0; i < 3; i++)
                if(check(field, new Point(0, i),p -> new Point(p.x + 1, p.y)))
                    return field.getFigure(new Point(0, i));

            if(check(field, new Point(0, 0),p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(0, 0));

            if(check(field, new Point(0, 2), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(1, 1));

        } catch (final InvalidPointException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param field - game's field
     * @param currentPoint - current field's slot coordinate
     * @param pointGenerator - rule for iterator, tells next method call coordinates of next slot to check
     * @return false - game is not over, true - there is a winner -> game over
     */
    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) {

        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);

            if (currentFigure == null) {
                // empty field - game is not over
                return false;
            }

            nextFigure = field.getFigure(nextPoint);
        } catch (final InvalidPointException e) {
            // there are no more slots in line and
            // all slots were filled with same figures - we have a winner, game over
            return true;
        }
        // recursive call itself to next field's slot if right conditions
        return currentFigure == nextFigure && check(field, nextPoint, pointGenerator);

    }

    /**
     * Rule for change checking coordinates for next call of iterator
     */
    private interface IPointGenerator {
        Point next(final Point point);
    }

}
