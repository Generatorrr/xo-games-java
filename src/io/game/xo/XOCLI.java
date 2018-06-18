package io.game.xo;

import io.game.xo.model.Field;
import io.game.xo.model.Figure;
import io.game.xo.model.Game;
import io.game.xo.model.Player;
import io.game.xo.view.ConsoleView;

public class XOCLI {

    public static void main(final String[] args) {
        final String name1 = "Sashok";
        final String name2 = "Yurok";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game<Figure> gameXO = new Game<>(players, new Field<>(3), "XO");

        final ConsoleView consoleView = new ConsoleView();
        // While game is going on - print field after each turn
        while (consoleView.move(gameXO)) {
            consoleView.show(gameXO);
        }
        consoleView.show(gameXO);

    }

}
