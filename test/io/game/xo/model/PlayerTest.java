package io.game.xo.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getName() {
        final String inputName = "Alex";
        final String expectedName = inputName;

        final Player player = new Player(inputName, null);
        final String actualName = player.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    public void getFigure() {
        final Figure inputFigure = Figure.X;
        final Figure expectedFigure = inputFigure;

        final Player player = new Player(null, inputFigure);
        final Figure actualFigure = player.getFigure();

        assertEquals(expectedFigure, actualFigure);
    }
}