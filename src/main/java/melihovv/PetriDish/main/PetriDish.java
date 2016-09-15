package melihovv.PetriDish.main;

import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.main.Application;

/**
 * Basic application class which contains main function.
 */
public class PetriDish {

    public static void main(String[] args) {

        GeneralFactory generalFactory = new GeneralFactory();
        Application application = generalFactory.createApplication();
        application.startApplication();
    }
}
