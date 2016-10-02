package melihovv.PetriDish.controllers;

import melihovv.PetriDish.fieldObjects.ActiveFieldObject;

/**
 * The interface containing methods to control main player.
 */
public interface PlayerController extends ActiveFieldObjectController{
    /**
     * The method to control main player movement.
     * @param object controlled player.
     */
    void controlMovement(ActiveFieldObject object);
}
