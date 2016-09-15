package melihovv.PetriDish.factories;

import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.main.PetriDishGame;
import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.views.FieldObjectView;
import melihovv.PetriDish.views.FieldView;

/**
 * A factory to create basic game objects.
 */
public class GeneralFactory {

    private PetriDishGame _application;

    public PetriDishGame createApplication() {

        PetriDishGame application = new PetriDishGame(this);
        _application = application;
        return _application;
    }

    public FieldView createFieldView() {

        FieldView fieldView = new FieldView();
        Field.getInstance().addObjectListener(fieldView);
        return fieldView;
    }

    public FieldObjectView createFieldObjectView() {

        return new FieldObjectView();
    }

    public FieldObjectController createPlayerController() {

        return _application.getPlayerController();
    }
}
