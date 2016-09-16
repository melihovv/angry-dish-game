package melihovv.PetriDish.factories;

import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.fieldObjects.WoodenObstacle;
import melihovv.PetriDish.views.FieldObjectView;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * The factory to create instances of FieldObjectView class based on field
 * object
 * type.
 */
public class FieldObjectsViewFactory {
    /**
     * The path to bird image.
     */
    private static final String BIRD =
            "/heroes/birds/main_hero.png";

    /**
     * The path to pig image.
     */
    private static final String PIG =
            "/heroes/pigs/pig32px.png";

    /**
     * The path to wooden obstacle image.
     */
    private static final String WOODEN_OBSTACLE =
            "/obstacles/wooden_brick.png";

    /**
     * Creates and instance of FieldObjectView class based on field object type.
     * @param fieldObject field object as a source of type.
     * @return an instance of FieldObjectView class with the same type as
     * specified field object has.
     */
    public FieldObjectView createFieldObjectView(
            final FieldObject fieldObject
    ) {
        FieldObjectView objectView = fieldObject.getObjectView();
        objectView.setFieldObject(fieldObject);

        URI imageUri = null;

        try {
            if (fieldObject instanceof Bird) {
                imageUri = getClass().getResource(BIRD).toURI();
            } else if (fieldObject instanceof Pig) {
                imageUri = getClass().getResource(PIG).toURI();
            } else if (fieldObject instanceof WoodenObstacle) {
                imageUri = getClass().getResource(WOODEN_OBSTACLE).toURI();
            }

            objectView.createObjectView(imageUri);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return objectView;
    }
}
