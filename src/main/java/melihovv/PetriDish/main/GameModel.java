package melihovv.PetriDish.main;

import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.Timer;
import melihovv.PetriDish.collisions.BirdToPigCollision;
import melihovv.PetriDish.collisions.BirdToWoodenObstacleCollision;
import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.events.BirdListener;
import melihovv.PetriDish.events.ModelListener;
import melihovv.PetriDish.factories.FieldObjectsFactory;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.fieldObjects.WoodenObstacle;

import java.awt.Point;
import java.util.ArrayList;

/**
 * The base game model class which controls game logic.
 */
public class GameModel implements BirdListener {
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
     * The amount of time before new pig is created.
     */
    private static final int PIGS_CREATINON_TIME = 10000;

    /**
     * The factory to create field objects.
     */
    private FieldObjectsFactory _fieldObjectsFactory;

    /**
     * The set of model listeners.
     */
    private ArrayList<ModelListener> _modelListeners = new ArrayList<>();

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
     * The timer to create new pigs when the time's up.
     */
    private Timer _pigsCreationTimer;

    /**
     * The player controller to control player's behaviour.
     */
    private FieldObjectController _playerController;

    /**
     * The basic constructor for class members initialization.
     *
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public GameModel(final GeneralFactory generalFactory) {
        _generalFactory = generalFactory;
        _fieldObjectsFactory = new FieldObjectsFactory();
        _pigsCreationTimer = new Timer(PIGS_CREATINON_TIME);
    }

    /**
     * Updates game model variables.
     *
     * @param elapsedTime time passed after the last update.
     */
    public void update(final long elapsedTime) {
        Field.getInstance().update(elapsedTime);

        _playerToPigsCollisionManager.checkCollision();
        _playerToWoodenObstaclesCollisionManager.checkCollision();

        if (_pigsCreationTimer.action(elapsedTime)) {
            System.out.println("God damn! A new pig is here!");

            Pig pig = (Pig) _fieldObjectsFactory.createFieldObject(
                    Pig.class,
                    _generalFactory);

            Field.getInstance().addFieldObjectToRandomPosition(pig);
        }
    }

    /**
     * Starts the game by creating its objects and setting up main components.
     */
    public void startGame() {

        /* Creating main player and its controller */
        _player = (Bird) _fieldObjectsFactory.createFieldObject(
                Bird.class,
                _generalFactory);

        _playerController = _generalFactory.createPlayerController();
        _player.setController(_playerController);
        _player.addBirdListener(this);

        Field.getInstance().addFieldObject(
                _player,
                new Point(DEFAULT_PLAYER_X_POSITION, DEFAULT_PLAYER_Y_POSITION)
        );

        /* Creating pigs */
        for (int i = 0; i < PIGS_COUNT; ++i) {

            Pig pig = (Pig) _fieldObjectsFactory.createFieldObject(
                    Pig.class,
                    _generalFactory);

            Field.getInstance().addFieldObjectToRandomPosition(pig);
        }

        /* Creating wooden obstacles */
        for (int i = 0; i < WOODEN_OBSTACLES_COUNT; ++i) {

            WoodenObstacle obstacle =
                    (WoodenObstacle) _fieldObjectsFactory.createFieldObject(
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
     *
     * @return value of _player.
     */
    public Bird getPlayer() {
        return _player;
    }

    /**
     * Adds model listener.
     *
     * @param modelListener listener to add.
     */
    public void addModelListener(final ModelListener modelListener) {
        _modelListeners.add(modelListener);
    }

    /**
     * Removes model listener.
     *
     * @param modelListener listener to remove.
     */
    public void deleteModelListener(final BirdListener modelListener) {
        _modelListeners.remove(modelListener);
    }

    /**
     * Fires the event of hitting the wooden obstacle by a bird to all model
     * listeners.
     */
    private void fireBirdHitWoodenObstacle() {
        for (ModelListener modelListener : _modelListeners) {
            modelListener.birdHitWoodenObstacle();
        }
    }

    /**
     * Fires the event of eating a pig by a bird to all model listeners.
     */
    private void fireBirdEatPig() {
        for (ModelListener modelListener : _modelListeners) {
            modelListener.birdEatPig();
        }
    }

    /**
     * The reaction on bird hit wooden obstacle event.
     */
    @Override
    public void woodenObstacleHit() {
            fireBirdHitWoodenObstacle();
    }

    /**
     * The reaction on pig eat bird event.
     */
    @Override
    public void pigEaten() {
            fireBirdEatPig();
    }
}
