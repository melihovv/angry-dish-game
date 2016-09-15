package melihovv.PetriDish.main;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * Basic application class which contains main function.
 */
public class PetriDish {

    public static void main(String[] args) {
        GeneralFactory generalFactory = new GeneralFactory();
        PetriDishGame application = generalFactory.createApplication();
        application.startApplication();
    }
}
