package melihovv.PetriDish.factories;

import com.golden.gamedev.GameEngine;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.GreenBird;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.fieldObjects.RedBird;
import melihovv.PetriDish.fieldObjects.WoodenObstacle;
import melihovv.PetriDish.main.PetriDishGame;
import melihovv.PetriDish.main.PetriDishGameOver;
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
     * The instance of PetriDishGame class.
     */
    private PetriDishGame _petriDishGame;

    /**
     * Creates an instance of PetriDishGame class and saves its.
     *
     * @param gameEngine GameEngine object - parent of PetriDishGame.
     * @return PetriDishGame class instance.
     */
    public PetriDishGame createPetriDishGame(final GameEngine gameEngine) {

        PetriDishGame application = new PetriDishGame(gameEngine, this);
        _petriDishGame = application;
        return _petriDishGame;
    }

    /**
     * Creates an instance of PetriDishGameOver class.
     *
     * @param gameEngine GameEngine object - parent of PetriDishGameOver.
     * @return PetriDishGameOver class instance.
     */
    public PetriDishGameOver createPetriDishGameOver(
            final GameEngine gameEngine) {

        return new PetriDishGameOver(gameEngine);
    }


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
