package melihovv.PetriDish.factories;

import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.GreenBird;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.fieldObjects.RedBird;
import melihovv.PetriDish.fieldObjects.WoodenObstacle;
import melihovv.PetriDish.views.FieldObjectViews.FieldObjectView;
import melihovv.PetriDish.views.FieldObjectViews.GreenBirdView;
import melihovv.PetriDish.views.FieldObjectViews.PigView;
import melihovv.PetriDish.views.FieldObjectViews.RedBirdView;
import melihovv.PetriDish.views.FieldObjectViews.WoodenObstacleView;

/**
 * The factory to create instances of basic game objects.
 */
public class GeneralFactory {
    /**
     * Creates an instance of FieldObjectView subclass.
     *
     * @param fieldObject object of object view.
     * @return an instance of FieldObjectView class.
     */
    public FieldObjectView createFieldObjectView(final FieldObject
                                                         fieldObject) {

        FieldObjectView fieldObjectView = null;

        if (fieldObject instanceof Pig) {
            fieldObjectView = new PigView(fieldObject);
        } else if (fieldObject instanceof RedBird) {
            fieldObjectView = new RedBirdView(fieldObject);
        } else if (fieldObject instanceof GreenBird) {
            fieldObjectView = new GreenBirdView(fieldObject);
        } else if (fieldObject instanceof WoodenObstacle) {
            fieldObjectView = new WoodenObstacleView(fieldObject);
        }

        return fieldObjectView;
    }

}
