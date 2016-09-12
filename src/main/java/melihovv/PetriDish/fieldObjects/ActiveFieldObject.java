package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.factories.GeneralFactory;

/**
 * A class represents movable field object which do move and can interact with other objects.
 * Extends FieldObject.
 */
public class ActiveFieldObject extends FieldObject {

    private FieldObjectController _controller;

    public ActiveFieldObject( GeneralFactory generalFactory ) {

        super( generalFactory );
    }

    public FieldObjectController getController() {

        return _controller;
    }

    public void setController( FieldObjectController controller ) {

        _controller = controller;
    }
}
