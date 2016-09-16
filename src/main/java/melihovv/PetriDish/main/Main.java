package melihovv.PetriDish.main;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * The basic application class which contains main function.
 */
public final class Main {
    /**
     * The basic private constructor.
     */
    private Main() {
    }

    /**
     * The application main function.
     * @param args command lune arguments.
     */
    public static void main(final String[] args) {
        GeneralFactory generalFactory = new GeneralFactory();
        PetriDishGame application = generalFactory.createPetriDishGame();
        application.startGame();
    }
}
