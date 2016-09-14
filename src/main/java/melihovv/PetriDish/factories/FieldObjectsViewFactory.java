package melihovv.PetriDish.factories;

import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.views.FieldObjectView;

/**
 * A factory to create field object views based on field object type.
 */
public class FieldObjectsViewFactory {

    private final static String BIRD = "src/main/resources/heroes/birds/main_hero.png";
    private final static String PIG = "src/main/resources/heroes/pigs/pig32px.png";

    public FieldObjectView createFieldObjectView( FieldObject fieldObject) {

        FieldObjectView objectView = fieldObject.getObjectView();
        objectView.setFieldObject( fieldObject );

        if(fieldObject instanceof Bird ) {

            objectView.createObjectView(BIRD);

        } else if(fieldObject instanceof Pig) {

            objectView.createObjectView( PIG );
        }

        return  objectView;
    }


}
