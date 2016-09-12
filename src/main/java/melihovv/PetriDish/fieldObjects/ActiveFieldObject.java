package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * A class represents movable field object which do move and can interact with other objects.
 * Extends FieldObject.
 */
public class ActiveFieldObject extends FieldObject {

    public ActiveFieldObject( GeneralFactory generalFactory ) {

        super( generalFactory );
    }
}
