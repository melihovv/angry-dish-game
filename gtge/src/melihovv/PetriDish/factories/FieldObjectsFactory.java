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

import java.lang.reflect.Constructor;

/**
 * The factory to create instances of FieldObject class based on subclass types.
 */
public final class FieldObjectsFactory {
    /**
     * Private constructor.
     */
    private FieldObjectsFactory() {

    }

    /**
     * Creates an instance of FieldObject class based on specified subclass.
     *
     * @param c specified subclass.
     * @return an instance of FieldObject class with the specified subclass
     * type.
     */
    public static FieldObject createFieldObject(final Class c) {
        Object fieldObject = null;

        try {

            Constructor<?> constructor = c.getConstructor();
            fieldObject = constructor.newInstance();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return (FieldObject) fieldObject;
    }

    /**
     * Creates an instance of FieldObjectView subclass.
     *
     * @param fieldObject object of object view.
     * @return an instance of FieldObjectView class.
     */
    public static FieldObjectView createFieldObjectView(final FieldObject
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
