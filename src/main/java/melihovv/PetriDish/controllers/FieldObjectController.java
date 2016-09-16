package melihovv.PetriDish.controllers;

import melihovv.PetriDish.fieldObjects.ActiveFieldObject;

/**
 * The interface containing methods to control active field objects behaviour.
 */
public interface FieldObjectController {
    /**
     * The method to control field object movement.
     * @param bird controlled field object.
     */
    void controlMovement(ActiveFieldObject bird);
}
