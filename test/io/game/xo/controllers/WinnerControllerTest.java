package io.game.xo.controllers;

import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.exceptions.InvalidPointException;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void getWinnerWhenWinnerRow() throws Exception {

        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerRow1() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerRow2() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.O);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertEquals(Figure.X, winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerColumn1() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.X);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.O);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenNoWinnerColumn2() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i = 0; i < 3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0, i), Figure.O);
            field.setFigure(new Point(1, i), Figure.X);
            field.setFigure(new Point(2, i), Figure.X);
            assertNull(winnerController.getWinner(field));
        }
    }

    @Test
    public void getWinnerWhenWinnerDiagonal1() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);

        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenWinnerDiagonal2() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);

        assertEquals(Figure.X, winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal11() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        field.setFigure(new Point(0, 0), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.O);

        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal21() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        field.setFigure(new Point(0, 2), Figure.X);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.O);

        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal12() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        field.setFigure(new Point(0, 0), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 2), Figure.X);

        assertNull(winnerController.getWinner(field));
    }

    @Test
    public void getWinnerWhenNoWinnerDiagonal22() throws Exception {
        final WinnerController winnerController = new WinnerController();
        final Field field = new Field(3);

        field.setFigure(new Point(0, 2), Figure.O);
        field.setFigure(new Point(1, 1), Figure.X);
        field.setFigure(new Point(2, 0), Figure.X);

        assertNull(winnerController.getWinner(field));
    }

}