package melihovv.PetriDish.factories;

import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.views.FieldObjectView;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * A factory to create field object views based on field object type.
 */
public class FieldObjectsViewFactory {
    private static final String BIRD =
            "/heroes/birds/main_hero.png";

    private static final String PIG =
            "/heroes/pigs/pig32px.png";

    public FieldObjectView createFieldObjectView(
            final FieldObject fieldObject
    ) {
        FieldObjectView objectView = fieldObject.getObjectView();
        objectView.setFieldObject(fieldObject);

        URI imageUri = null;

        try {
            if (fieldObject instanceof Bird) {
                imageUri = getClass().getResource(BIRD).toURI();
                objectView.createObjectView(imageUri);
            } else if (fieldObject instanceof Pig) {
                imageUri = getClass().getResource(PIG).toURI();
                objectView.createObjectView(imageUri);
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return objectView;
    }
}
