package melihovv.AngryDish.controllers;

import melihovv.AngryDish.fieldObjects.ActiveFieldObject;

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
