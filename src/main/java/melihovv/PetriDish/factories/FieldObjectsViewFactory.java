package melihovv.PetriDish.factories;

import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.views.FieldObjectView;

/**
 * A factory to create field object views based in field object type.
 */
public class FieldObjectsViewFactory {

    public FieldObjectView createFieldObjectView( FieldObject fieldObject) {

        FieldObjectView objectView = fieldObject.getObjectView();
        objectView.setFieldObject( fieldObject );

        if(fieldObject instanceof Bird ) {

            objectView.createObjectView();
        }

        return  objectView;
    }
}
