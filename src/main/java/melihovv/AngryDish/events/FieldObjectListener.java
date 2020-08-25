package melihovv.AngryDish.events;

import melihovv.AngryDish.fieldObjects.FieldObject;

import java.util.EventListener;

/**
 * The class represents listener interface for adding/deleting objects to/from
 * game field.
 */
public interface FieldObjectListener extends EventListener {
    /**
     * The method to fire the event of adding field object.
     *
     * @param fieldObject added field object.
     */
    void fieldObjectAdded(final FieldObject fieldObject);

    /**
     * The method to fire the event of deleting field object.
     *
     * @param fieldObject deleted field object.
     */
    void fieldObjectDeleted(final FieldObject fieldObject);
}
