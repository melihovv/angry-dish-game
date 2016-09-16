package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * The class represents static field object which can't move and do anything.
 */
public class InactiveFieldObject extends FieldObject {
    /**
     * The basic constructor for class members initialization.
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public InactiveFieldObject(final GeneralFactory generalFactory) {
        super(generalFactory);
    }
}
