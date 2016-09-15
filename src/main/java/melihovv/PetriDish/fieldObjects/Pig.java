package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * A class represents game object which player can eat.
 * Extends InactiveFieldObject.
 */
public class Pig extends InactiveFieldObject{

    private final static int DEFAULT_SIZE = 32;

    public Pig( GeneralFactory generalFactory ) {

        super( generalFactory );
        setSize( DEFAULT_SIZE );
    }
}
