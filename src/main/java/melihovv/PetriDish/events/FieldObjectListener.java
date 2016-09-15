package melihovv.PetriDish.events;

import melihovv.PetriDish.fieldObjects.FieldObject;

/**
 * A class represents listener interface for adding/deleting objects to/from
 * game field.
 */
public interface FieldObjectListener {
    void fieldObjectAdded(FieldObject fieldObject);

    void fieldObjectDeleted(FieldObject fieldObject);
}
