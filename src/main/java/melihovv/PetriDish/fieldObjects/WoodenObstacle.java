package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.FieldObjectsFactory;

/**
 * The wooden obstacle object which player can't go through.
 */
public class WoodenObstacle extends InactiveFieldObject {
    /**
     * The size of the pig.
     */
    private static final int DEFAULT_SIZE = 48;

    /**
     * The basic constructor for class members initialization.
     */
    public WoodenObstacle() {
        super();
        setSize(DEFAULT_SIZE);
        setFieldObjectView(FieldObjectsFactory.createFieldObjectView(this));
    }
}
