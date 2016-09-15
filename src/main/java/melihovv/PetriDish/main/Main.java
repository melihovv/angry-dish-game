package melihovv.PetriDish.main;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * Basic application class which contains main function.
 */
public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        GeneralFactory generalFactory = new GeneralFactory();
        PetriDishGame application = generalFactory.createApplication();
        application.startApplication();
    }
}
