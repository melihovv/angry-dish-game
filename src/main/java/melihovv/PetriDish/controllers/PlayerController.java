package melihovv.PetriDish.controllers;

import melihovv.PetriDish.fieldObjects.ActiveFieldObject;

/**
 * The interface containing methods to control main player.
 */
public interface PlayerController {
    /**
     * The method to control player movement.
     * @param bird controlled player.
     */
    void controlMovement(ActiveFieldObject bird);
}
