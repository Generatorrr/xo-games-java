package io.game.xo.model;

public class Game {

    private final Player[] players;
    private final Field field;
    private final String name;

    /**
     * Constructor
     * @param players - array of players
     * @param field - field to store figures
     * @param name - game name
     */
    public Game(final Player[] players, final Field field, final String name) {
        this.players = players;
        this.field = field;
        this.name = name;
    }

    /**
     * Method to get players
     * @return array of players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Method to get field
     * @return game's field
     */
    public Field getField() {
        return field;
    }

    /**
     * Method to get game name
     * @return game's name
     */
    public String getName() {
        return name;
    }
}
