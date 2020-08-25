package melihovv.AngryDish.controllers;

import melihovv.AngryDish.fieldObjects.ActiveFieldObject;

/**
 * The interface containing methods to control computer players.
 */
public interface AIController extends ActiveFieldObjectController {
    /**
     * The method to control computer players.
     * @param object controlled computer player.
     */
    void controlMovement(ActiveFieldObject object);
}
