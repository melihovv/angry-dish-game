package melihovv.PetriDish.controllers;

import melihovv.PetriDish.fieldObjects.Bird;

/**
 * An interface containing methods to control active field objects behaviour.
 */
public interface FieldObjectController {

    void controlMovement(Bird bird);
}
