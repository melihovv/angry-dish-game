package melihovv.PetriDish.controllers;

import melihovv.PetriDish.fieldObjects.ActiveFieldObject;

/**
 * The interface containing methods to control computer players.
 */
public interface AIController {
    /**
     * The method to control computer players.
     * @param bird controlled computer player.
     */
    void controlMovement(ActiveFieldObject bird);
}
