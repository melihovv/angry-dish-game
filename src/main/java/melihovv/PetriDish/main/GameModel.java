package melihovv.PetriDish.main;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.SpriteGroup;
import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.factories.FieldObjectsFactory;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.Pig;

import java.awt.Point;

/**
 * Base game model class which controls game logic.
 */
public class GameModel {

    private static final int PIGS_COUNT = 50;
    private static final int DEFAULT_PLAYER_X_POSITION = 2500;
    private static final int DEFAULT_PLAYER_Y_POSITION = 1875;

    private Bird _player;
    private GeneralFactory _generalFactory;
    private CollisionManager _collisionManager;
    private FieldObjectController _playerController;

    public GameModel(final GeneralFactory generalFactory) {
        _generalFactory = generalFactory;
    }

    public void update(final long elapsedTime) {
        Field.getInstance().update(elapsedTime);

        _collisionManager.checkCollision();
    }

    public void startGame() {
        FieldObjectsFactory factory = new FieldObjectsFactory();

        /* Creating main player and its controller */
        _player = (Bird) factory.createFieldObject(
                Bird.class,
                _generalFactory);

        _playerController = _generalFactory.createPlayerController();
        _player.setController(_playerController);

        Field.getInstance().addFieldObject(
                _player,
                new Point(DEFAULT_PLAYER_X_POSITION, DEFAULT_PLAYER_Y_POSITION)
        );

        /* Creating pigs */
        for (int i = 0; i < PIGS_COUNT; ++i) {

            Pig pig = (Pig) factory.createFieldObject(
                    Pig.class,
                    _generalFactory);

            Field.getInstance().addFieldObjectToRandomPosition(pig);
        }

        /* Setting up collision manager */
        SpriteGroup birdsGroup = Field.getInstance().getSpriteGroup(Bird.class);
        SpriteGroup pigsGroup = Field.getInstance().getSpriteGroup(Pig.class);
        _collisionManager = new BirdToPigCollision(birdsGroup, pigsGroup);
    }

    public Bird getPlayer() {
        return _player;
    }
}
