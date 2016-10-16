package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.FieldObjectsFactory;

/**
 * The class represents game object which player can eat.
 */
public class Pig extends InactiveFieldObject {
    /**
     * The size of the pig.
     */
    private static final int DEFAULT_SIZE = 32;

    /**
     * The basic constructor for class members initialization.
     */
    public Pig() {
        super();
        setSize(DEFAULT_SIZE);
        setFieldObjectView(FieldObjectsFactory.createFieldObjectView(this));
    }
}
