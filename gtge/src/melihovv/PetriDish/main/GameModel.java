package melihovv.PetriDish.main;

import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.CollisionManager;
import com.golden.gamedev.object.Timer;
import melihovv.PetriDish.collisions.BirdToPigCollision;
import melihovv.PetriDish.collisions.BirdToWoodenObstacleCollision;
import melihovv.PetriDish.collisions.PlayerToComputerBirdCollision;
import melihovv.PetriDish.events.BirdListener;
import melihovv.PetriDish.events.ModelListener;
import melihovv.PetriDish.factories.FieldObjectsFactory;
import melihovv.PetriDish.fieldObjects.ActiveFieldObject;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.GreenBird;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.fieldObjects.RedBird;
import melihovv.PetriDish.fieldObjects.WoodenObstacle;

import java.awt.Point;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;
import java.util.Random;

import melihovv.library.SpriteGroup;

/**
 * The base game model class which controls game logic.
 */
public class GameModel implements BirdListener {
    /**
     * The amount of pigs(game object) on start of the game.
     */
    private static final int PIGS_COUNT = 50;

    /**
     * The amount of computer controlled birds on start of the game.
     */
    private static final int COMPUTER_BIRDS_COUNT = 5;

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
     * The set of model listeners.
     */
    private ArrayList<ModelListener> _modelListeners = new ArrayList<>();

    /**
     * The main player of the game.
     */
    private RedBird _player;

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
     * The collision manager to control collisions between the player and
     * computer birds.
     */
    private CollisionManager _playerToComputerBirdsCollisionManager;

    /**
     * The timer to create new pigs when the time's up.
     */
    private Timer _pigsCreationTimer;

    /**
     * The player controller to control player's behaviour.
     */
    private PlayerController _playerController;

    /**
     * The ai controller to control computer bird's behaviour.
     */
    private AIController _aiController;

    /**
     * Main game class instance.
     */
    private PetriDishGame _gameInstance;

    /**
     * The basic constructor for class members initialization.
     *
     * @param gameInstance main game class instance.
     */
    public GameModel(final PetriDishGame gameInstance) {
        _pigsCreationTimer = new Timer(PIGS_CREATINON_TIME);
        _gameInstance = gameInstance;
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
        _playerToComputerBirdsCollisionManager.checkCollision();

        if (_pigsCreationTimer.action(elapsedTime)) {

            System.out.println("God damn! A new pig is here!");

            Pig pig = (Pig) FieldObjectsFactory.createFieldObject(Pig.class);
            Field.getInstance().addFieldObjectToRandomPosition(pig);
        }
    }

    /**
     * Starts the game by creating its objects and setting up main components.
     */
    public void startGame() {

        /* Get player name */
        PlayerNameDialog dialog = new PlayerNameDialog();
        dialog.askUserName();

        /* Creating main player and its controller */
        _player = (RedBird) FieldObjectsFactory.createFieldObject(
                RedBird.class
        );

        _playerController = new PlayerController();
        _player.setController(_playerController);
        _player.addBirdListener(this);
        _player.setPlayerName(dialog.getPlayerName());

        _aiController = new AIController();

        Field.getInstance().addFieldObject(
                _player,
                new Point(DEFAULT_PLAYER_X_POSITION, DEFAULT_PLAYER_Y_POSITION)
        );


        /* Creating computer controlled birds */
        for (int i = 0; i < COMPUTER_BIRDS_COUNT; ++i) {

            GreenBird greenBird =
                    (GreenBird) FieldObjectsFactory.createFieldObject(
                            GreenBird.class
                    );
            greenBird.setController(_aiController);
            greenBird.addBirdListener(this);

            Field.getInstance().addFieldObjectToRandomPosition(greenBird);
        }

        /* Creating pigs */
        for (int i = 0; i < PIGS_COUNT; ++i) {

            Pig pig = (Pig) FieldObjectsFactory.createFieldObject(Pig.class);

            Field.getInstance().addFieldObjectToRandomPosition(pig);
        }

        /* Creating wooden obstacles */
        for (int i = 0; i < WOODEN_OBSTACLES_COUNT; ++i) {

            WoodenObstacle obstacle =
                    (WoodenObstacle) FieldObjectsFactory.createFieldObject(
                            WoodenObstacle.class
                    );

            Field.getInstance().addFieldObjectToRandomPosition(obstacle);
        }

        /* Setting up collision manager */
        SpriteGroup birdsGroup =
                Field.getInstance().getSpriteGroup(Bird.class);

        SpriteGroup pigsGroup =
                Field.getInstance().getSpriteGroup(Pig.class);

        SpriteGroup woodenObstaclesGroup =
                Field.getInstance().getSpriteGroup(WoodenObstacle.class);

        SpriteGroup mainPlayerGroup =
                Field.getInstance().getSpriteGroup(RedBird.class);

        _playerToPigsCollisionManager =
                new BirdToPigCollision(
                        birdsGroup,
                        pigsGroup
                );

        _playerToWoodenObstaclesCollisionManager =
                new BirdToWoodenObstacleCollision(
                        birdsGroup,
                        woodenObstaclesGroup
                );

        _playerToComputerBirdsCollisionManager =
                new PlayerToComputerBirdCollision(
                        mainPlayerGroup,
                        birdsGroup
                );
    }

    /**
     * Finishes the game and reset its components when game is over.
     */
    public void finishGame() {

        /* Reset controllers */
        _playerController = null;
        _aiController = null;

        /* Reset collision managers */
        _playerToPigsCollisionManager = null;
        _playerToWoodenObstaclesCollisionManager = null;
        _playerToComputerBirdsCollisionManager = null;

        /* Reset player */
        _player.deleteBirdListener(this);
        _player = null;

        /* Reset field */
        Field.getInstance().clearField();
    }

    /**
     * The getter for _player class member.
     *
     * @return value of _player.
     */
    public RedBird getPlayer() {
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
    public void deleteModelListener(final ModelListener modelListener) {
        _modelListeners.remove(modelListener);
    }

    /**
     * Fires the event of hitting the wooden obstacle by a bird to all model
     * listeners.
     *
     * @param event event object.
     */
    private void fireBirdHitWoodenObstacle(final EventObject event) {
        for (ModelListener modelListener : _modelListeners) {
            modelListener.birdHitWoodenObstacle(event);
        }
    }

    /**
     * Fires the event of eating a pig by a bird to all model listeners.
     *
     * @param event event object.
     */
    private void fireBirdEatPig(final EventObject event) {
        for (ModelListener modelListener : _modelListeners) {
            modelListener.birdEatPig(event);
        }
    }

    /**
     * Fires the event of fighting computer controlled bird by a player bird to
     * all model listeners.
     *
     * @param event event object.
     */
    private void firePlayerFoughtComputerBird(final EventObject event) {
        for (ModelListener modelListener : _modelListeners) {
            modelListener.playerFoughtComputerBird(event);
        }
    }

    /**
     * Fires the event of player's death to all model listeners.
     *
     * @param event event object.
     */
    private void firePlayerDied(final EventObject event) {
        for (ModelListener modelListener : _modelListeners) {
            modelListener.playerDied(event);
        }
    }

    /**
     * The reaction on bird hit wooden obstacle event.
     *
     * @param event event object.
     */
    @Override
    public void woodenObstacleHit(final EventObject event) {
        fireBirdHitWoodenObstacle(event);
    }

    /**
     * The reaction on pig eat bird event.
     *
     * @param event event object.
     */
    @Override
    public void pigEaten(final EventObject event) {

        ActiveFieldObject object = (ActiveFieldObject) event.getSource();
        fireBirdEatPig(event);
    }

    /**
     * The reaction on player fight computer bird event.
     *
     * @param event event object.
     */
    @Override
    public void foughtComputerBird(final EventObject event) {

        /* Creating new enemy */
        GreenBird enemyBird =
                (GreenBird) FieldObjectsFactory.createFieldObject(
                        GreenBird.class
                );
        enemyBird.setController(_aiController);
        enemyBird.addBirdListener(this);
        Field.getInstance().addFieldObjectToRandomPosition(enemyBird);

        firePlayerFoughtComputerBird(event);
    }

    @Override
    public void died(final EventObject event) {

        firePlayerDied(event);
    }

    /**
     * The AI controller class which controls computer player's behaviour.
     */
    private class AIController
            implements melihovv.PetriDish.controllers.AIController {
        /**
         * The probability to change destination point.
         */
        private static final double CHANGE_DESTINATION_PROBABILITY = 0.0015;

        /**
         * Controls basic computer player movement.
         *
         * @param bird computer player to control.
         */
        @Override
        public void controlMovement(final ActiveFieldObject bird) {
            Random randomizer = new Random();
            int fieldWidth = Field.getFieldWidth();
            int fieldHeight = Field.getFieldHeight();
            List<FieldObject> objects =
                    Field.getInstance().getFieldObjects();

            /* Setting a new destination for all computer players */
            for (FieldObject object : objects) {

                if (object instanceof ActiveFieldObject
                        && object != getPlayer()) {

                    if (Math.random() < CHANGE_DESTINATION_PROBABILITY) {

                        Point newDestination = new Point(
                                randomizer.nextInt(fieldWidth),
                                randomizer.nextInt(fieldHeight)
                        );

                        ((ActiveFieldObject) object).setDestination(
                                newDestination
                        );
                    }
                }
            }
        }
    }

    /**
     * The player controller class which controls player's behaviour.
     */
    private class PlayerController
            implements melihovv.PetriDish.controllers.PlayerController {
        /**
         * Controls basic player movement.
         *
         * @param bird player to control.
         */
        @Override
        public void controlMovement(final ActiveFieldObject bird) {
            /* Getting base mouse coordinates */
            int baseMouseX = _gameInstance.getMouseX();
            int baseMouseY = _gameInstance.getMouseY();

            /* Getting background coordinates */
            Background background = _gameInstance.getGameView().getFieldView()
                    .getBackground();
            int backgroundX = (int) background.getX();
            int backgroundY = (int) background.getY();

            /* Getting mouse coordinates on field */
            int mouseX = baseMouseX + backgroundX;
            int mouseY = baseMouseY + backgroundY;

            bird.setDestination(new Point(mouseX, mouseY));
        }
    }
}
