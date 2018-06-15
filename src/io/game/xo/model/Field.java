package io.game.xo.model;

import io.game.xo.model.exceptions.InvalidPointException;

public class Field {

    public static final int MIN_COORDINATE = 0;

    private final int fieldSize;
    private final Figure[][] field;

    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = new Figure[fieldSize][fieldSize];
    }

    public int getSize() {
        return fieldSize;
    }

    public Figure getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.y][point.x];
    }

    public void setFigure(final Point point, final Figure figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.y][point.x] = figure;
    }

    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
