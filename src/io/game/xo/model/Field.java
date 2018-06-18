package io.game.xo.model;

import io.game.xo.model.exceptions.InvalidPointException;

public class Field<T> {

    private static final int MIN_COORDINATE = 0;

    private final int fieldSize;
    private final T[][] field;

    /**
     * Constructor
     * @param fieldSize - size of your square field
     */
    public Field(final int fieldSize) {
        this.fieldSize = fieldSize;
        this.field = (T[][])new Object[fieldSize][fieldSize];
    }

    /**
     * Method to get field size
     * @return field size
     */
    public int getSize() {
        return fieldSize;
    }

    /**
     * Try to get figure lies in field's slot by coordinates
     * @param point - input point (coordinates)
     * @return figure lies in field's slot by passed coordinates, or null if there isn't figure by passed coordinates
     * @throws InvalidPointException - throws if invalid coordinates were passed
     */
    public T getFigure(final Point point) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }
        return field[point.y][point.x];
    }

    /**
     * Set figure to field's slot if valid
     * @param point - input point
     * @param figure - input figure
     * @throws InvalidPointException - throws if check not passed
     */
    public void setFigure(final Point point, final T figure) throws InvalidPointException {
        if (!checkPoint(point)) {
            throw new InvalidPointException();
        }

        field[point.y][point.x] = figure;
    }

    /**
     * Check input point for valid coordinates
     * @param point - input point to check
     * @return true - valid, false - invalid
     */
    private boolean checkPoint(final Point point) {
        return checkCoordinate(point.x, field.length) && checkCoordinate(point.y, field[point.x].length);
    }

    /**
     * Checks coordinate validity
     * @param coordinate - coordinate to check
     * @param maxCoordinate - max valid coordinate
     * @return true - valid, false - invalid
     */
    private boolean checkCoordinate(final int coordinate, final int maxCoordinate) {
        return coordinate >= MIN_COORDINATE && coordinate < maxCoordinate;
    }
}
