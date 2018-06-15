package io.game.xo.model;

public class Player {

    private final String name;
    private final Figure figure;

    /**
     * Constructor
     * @param name - player's name
     * @param figure - player's figure
     */
    public Player(String name, Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    /**
     * Get player's name
     * @return player's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get player's figure
     * @return player's figure
     */
    public Figure getFigure() {
        return figure;
    }
}
