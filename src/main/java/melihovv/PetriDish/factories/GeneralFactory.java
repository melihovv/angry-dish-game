package melihovv.PetriDish.factories;

import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.main.PetriDishGame;
import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.views.FieldObjectView;
import melihovv.PetriDish.views.FieldView;

/**
 * The factory to create instances of basic game objects.
 */
public class GeneralFactory {
    /**
     * The instance of PetriDishGame class.
     */
    private PetriDishGame _petriDishGame;

    /**
     * Creates an instance of PetriDishGame class and saves its.
     * @return PetriDishGame class instance.
     */
    public PetriDishGame createPetriDishGame() {

        PetriDishGame application = new PetriDishGame(this);
        _petriDishGame = application;
        return _petriDishGame;
    }

    /**
     * Creates an instance of FieldView class and adds it to the field's
     * listeners.
     * @return FieldView class instance.
     */
    public FieldView createFieldView() {

        FieldView fieldView = new FieldView();
        Field.getInstance().addObjectListener(fieldView);
        return fieldView;
    }

    /**
     * Creates an instance of FieldObjectView class.
     * @return an instance of FieldObjectView class.
     */
    public FieldObjectView createFieldObjectView() {

        return new FieldObjectView();
    }

    /**
     * Creates an instance of PlayerController class.
     * @return an instance of PlayerController class.
     */
    public FieldObjectController createPlayerController() {

        return _petriDishGame.getPlayerController();
    }
}
