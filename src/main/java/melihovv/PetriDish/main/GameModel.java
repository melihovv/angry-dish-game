package melihovv.PetriDish.main;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.SpriteGroup;
import melihovv.PetriDish.collisions.BirdToPigCollision;
import melihovv.PetriDish.collisions.BirdToWoodenObstacleCollision;
import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.factories.FieldObjectsFactory;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.fieldObjects.WoodenObstacle;

import java.awt.Point;

/**
 * The base game model class which controls game logic.
 */
public class GameModel {
    /**
     * The amount of pigs(game object) on start of the game.
     */
    private static final int PIGS_COUNT = 50;

    /**
     * The amount of wooden obstacles(game object) on start of the game.
     */
    private static final int WOODEN_OBSTACLES_COUNT = 20;

    /**
     * The x coordinate of player position on start of the game.
     */
    private static final int DEFAULT_PLAYER_X_POSITION = 2500;

    /**
     * The y coordinate of player position on start of the game.
     */
    private static final int DEFAULT_PLAYER_Y_POSITION = 1875;

    /**
     * The main player of the game.
     */
    private Bird _player;

    /**
     * The general game factory to create basic game components.
     */
    private GeneralFactory _generalFactory;

    /**
     * The collision manager to control collisions between the player and pigs.
     */
    private CollisionManager _playerToPigsCollisionManager;

    /**
     * The collision manager to control collisions between the player and
     * wooden obstacles.
     */
    private CollisionManager _playerToWoodenObstaclesCollisionManager;

    /**
     * The player controller to control player's behaviour.
     */
    private FieldObjectController _playerController;

    /**
     * The basic constructor for class members initialization.
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public GameModel(final GeneralFactory generalFactory) {
        _generalFactory = generalFactory;
    }

    /**
     * Updates game model variables.
     * @param elapsedTime time passed after the last update.
     */
    public void update(final long elapsedTime) {
        Field.getInstance().update(elapsedTime);

        _playerToPigsCollisionManager.checkCollision();
        _playerToWoodenObstaclesCollisionManager.checkCollision();
    }

    /**
     * Starts the game by creating its objects and setting up main components.
     */
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

        /* Creating wooden obstacles */
        for (int i = 0; i < WOODEN_OBSTACLES_COUNT; ++i) {

            WoodenObstacle obstacle =
                    (WoodenObstacle) factory.createFieldObject(
                            WoodenObstacle.class,
                            _generalFactory);

            Field.getInstance().addFieldObjectToRandomPosition(obstacle);
        }

        /* Setting up collision manager */
        SpriteGroup birdsGroup =
                Field.getInstance().getSpriteGroup(Bird.class);

        SpriteGroup pigsGroup =
                Field.getInstance().getSpriteGroup(Pig.class);

        SpriteGroup woodenObstaclesGroup =
                Field.getInstance().getSpriteGroup(WoodenObstacle.class);

        _playerToPigsCollisionManager =
                new BirdToPigCollision(
                        birdsGroup,
                        pigsGroup);

        _playerToWoodenObstaclesCollisionManager =
                new BirdToWoodenObstacleCollision(
                        birdsGroup,
                        woodenObstaclesGroup);
    }

    /**
     * The getter for _player class member.
     * @return value of _player.
     */
    public Bird getPlayer() {
        return _player;
    }
}
