package melihovv.AngryDish.factories;

import melihovv.AngryDish.fieldObjects.FieldObject;
import melihovv.AngryDish.fieldObjects.GreenBird;
import melihovv.AngryDish.fieldObjects.Pig;
import melihovv.AngryDish.fieldObjects.RedBird;
import melihovv.AngryDish.fieldObjects.WoodenObstacle;
import melihovv.AngryDish.views.FieldObjectViews.FieldObjectView;
import melihovv.AngryDish.views.FieldObjectViews.GreenBirdView;
import melihovv.AngryDish.views.FieldObjectViews.PigView;
import melihovv.AngryDish.views.FieldObjectViews.RedBirdView;
import melihovv.AngryDish.views.FieldObjectViews.WoodenObstacleView;

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
