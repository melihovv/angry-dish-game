package melihovv.PetriDish.main;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.GameObject;
import melihovv.PetriDish.factories.GeneralFactory;

import java.awt.Dimension;

/**
 * The basic application class which contains main function.
 */
public final class Main extends GameEngine {
    /**
     * The general game factory to create basic game components.
     */
    private GeneralFactory _generalFactory = new GeneralFactory();

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

    @Override
    public GameObject getGame(final int gameID) {

        switch (gameID) {

            case 0: {

                PetriDishGame game = _generalFactory.createPetriDishGame(this);
                game.startGame();
                return game;

            }
            case 1: {

                return _generalFactory.createPetriDishGameOver(this);
            }
            default: {

                return null;
            }
        }
    }
}
