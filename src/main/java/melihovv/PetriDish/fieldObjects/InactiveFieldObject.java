package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * A class represents static field object which can't move and do anything.
 * Extends FieldObject.
 */
public class InactiveFieldObject extends FieldObject{

    public InactiveFieldObject( GeneralFactory generalFactory ) {

        super( generalFactory );
    }
}
