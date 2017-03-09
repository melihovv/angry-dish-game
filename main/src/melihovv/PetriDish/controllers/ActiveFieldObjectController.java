package melihovv.PetriDish.controllers;

import melihovv.PetriDish.fieldObjects.ActiveFieldObject;

/**
 * Basic interface to control field object's behaviour.
 */
public interface ActiveFieldObjectController {
    /**
     * The method to control active field object.
     * @param object controlled active field object.
     */
    void controlMovement(ActiveFieldObject object);
}
