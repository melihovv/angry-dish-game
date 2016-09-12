package melihovv.PetriDish.factories;

import melihovv.PetriDish.main.Application;
import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.views.FieldObjectView;
import melihovv.PetriDish.views.FieldView;

/**
 * A factory to create basic game objects.
 */
public class GeneralFactory {

    private Application _application;

    public Application createApplication() {

        Application application = new Application( this );
        _application = application;
        return _application;
    }

    public FieldView createFieldView() {

        FieldView fieldView = new FieldView();
        return  fieldView;
    }

    public FieldObjectView createFieldObjectView() {

        return new FieldObjectView();
    }
}
