package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * A class represents game object which player can eat.
 */
public class Pig extends InactiveFieldObject {
    private static final int DEFAULT_SIZE = 32;

    public Pig(final GeneralFactory generalFactory) {
        super(generalFactory);

        setSize(DEFAULT_SIZE);
    }
}
