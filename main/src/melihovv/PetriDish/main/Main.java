package melihovv.PetriDish.main;

import java.awt.Dimension;

import melihovv.library.GameEngine;
import melihovv.library.GameLoader;
import melihovv.library.GameObject;

/**
 * The basic application class which contains main function.
 */
public final class Main  {
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

        PetriDishGame game = new PetriDishGame();
        GameLoader gameLoader  = new GameLoader();
        gameLoader.setup(
                game,
                new Dimension(
                        PetriDishGame.getScreenWidth(),
                        PetriDishGame.getScreenHeight()),
                false
        );
        gameLoader.start();
    }
}
