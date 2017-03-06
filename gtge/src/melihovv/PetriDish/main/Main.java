package melihovv.PetriDish.main;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.GameObject;

import java.awt.Dimension;

/**
 * The basic application class which contains main function.
 */
public final class Main extends GameEngine {
    /**
     * The basic private constructor.
     */
    private Main() {
    }

    /**
     * The application main function.
     *
     * @param args command lune arguments.
     */
    public static void main(final String[] args) {

        GameLoader gameLoader = new GameLoader();
        gameLoader.setup(
                new Main(),
                new Dimension(
                        PetriDishGame.getScreenWidth(),
                        PetriDishGame.getScreenHeight()),
                false
        );
        gameLoader.start();
    }

    /**
     * Chooses what game screen to show depending on current gameID.
     *
     * @param gameID current game id.
     * @return game screen.
     */
    @Override
    public GameObject getGame(final int gameID) {

        switch (gameID) {

            case 0: {

                return new PetriDishGameStart(this);
            }
            case 1: {

                PetriDishGame game = new PetriDishGame(this);
                game.startGame();
                return game;
            }
            case 2: {

                return new PetriDishGameOver(this);
            }
            default: {

                return null;
            }
        }
    }
}
