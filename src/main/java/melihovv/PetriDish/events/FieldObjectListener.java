package melihovv.PetriDish.events;

import melihovv.PetriDish.fieldObjects.FieldObject;

/**
 * The class represents listener interface for adding/deleting objects to/from
 * game field.
 */
public interface FieldObjectListener {
    /**
     * The method to fire the event of adding field object.
     * @param fieldObject added field object.
     */
    void fieldObjectAdded(FieldObject fieldObject);

    /**
     * The method to fire the event of deleting field object.
     * @param fieldObject deleted field object.
     */
    void fieldObjectDeleted(FieldObject fieldObject);
}
