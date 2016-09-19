package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

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
     *
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public WoodenObstacle(final GeneralFactory generalFactory) {
        super(generalFactory);
        setSize(DEFAULT_SIZE);
        _fieldObjectView = generalFactory.createFieldObjectView(this);
    }
}
