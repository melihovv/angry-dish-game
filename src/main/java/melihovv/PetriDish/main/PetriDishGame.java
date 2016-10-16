package melihovv.PetriDish.main;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;
import com.golden.gamedev.object.Background;
import melihovv.PetriDish.events.ModelListener;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.fieldObjects.ActiveFieldObject;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.views.FieldView;
import melihovv.PetriDish.views.GameView;

import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.List;
import java.util.Random;

/**
 * The basic game class which starts the game, controls its view and model, sets
 * window size.
 */
public class PetriDishGame extends GameObject implements ModelListener {
    /**
     * The time to play sound again.
     */
    private static final int REPEAT_SOUND_TIMER_TIME = 1000;

    /**
     * The width of the game screen.
     */
    private static final int SCREEN_WIDTH = 1280;

    /**
     * The height of the game screen.
     */
    private static final int SCREEN_HEIGHT = 720;

    /**
     * The flag to control whether the game is able to play obstacle hit sound
     * or not.
     */
    private boolean _canPlayObstacleSound = true;

    /**
     * The flag to control whether the game is able to play computer bird
     * fight sound or not.
     */
    private boolean _canPlayFightSound = true;

    /**
     * The timer to set _canPlayObstacleSound variable to true.
     */
    private Timer _repeatObstacleSoundTimer;

    /**
     * The timer to set _canPlayFightSound variable to true.
     */
    private Timer _repeatFightSoundTimer;

    /**
     * The part of the game which controls its appearance.
     */
    private GameView _gameView;

    /**
     * The part of the game which controls its logic and behaviour.
     */
    private GameModel _gameModel;

    /**
     * The part of the game which controls player's behaviour.
     */
    private PlayerController _playerController;

    /**
     * The part of the game which controls computer bird's behaviour.
     */
    private AIController _aiController;

    /**
     * The flag to control whether the game is over or not.
     */
    private boolean _isGameOver = false;

    /**
     * The GameEngine object - parent.
     */
    private GameEngine _gameEngine;

    // #TODO: Uncomment the line below when game is ready
    //{distribute=true;}

    /**
     * The basic constructor for class members initialization.
     *
     * @param generalFactory general game factory to create basic game
     *                       components.
     * @param gameEngine     GameEngine object - parent.
     */
    public PetriDishGame(final GameEngine gameEngine,
                         final GeneralFactory generalFactory) {
        super(gameEngine);
        _gameEngine = gameEngine;
        _gameModel = new GameModel(generalFactory);
        _gameModel.addModelListener(this);
        _playerController = new PlayerController();
        _aiController = new AIController();
        _gameView = new GameView(generalFactory.createFieldView(), _gameModel);

        /* Setting up the timers */
        _repeatObstacleSoundTimer = new Timer(
                REPEAT_SOUND_TIMER_TIME,
                new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        _canPlayObstacleSound = true;
                    }
                });
        _repeatObstacleSoundTimer.setRepeats(false);
        _repeatObstacleSoundTimer.stop();

        _repeatFightSoundTimer = new Timer(
                REPEAT_SOUND_TIMER_TIME,
                new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
                        _canPlayFightSound = true;
                    }
                });
        _repeatFightSoundTimer.setRepeats(false);
        _repeatFightSoundTimer.stop();
    }

    /**
     * The getter for SCREEN_WIDTH class member.
     *
     * @return value of SCREEN_WIDTH.
     */
    public static int getScreenWidth() {

        return SCREEN_WIDTH;
    }

    /**
     * The getter for SCREEN_HEIGHT class member.
     *
     * @return value of SCREEN_HEIGHT.
     */
    public static int getScreenHeight() {

        return SCREEN_HEIGHT;
    }

    /**
     * Initializes game variables.
     */
    @Override
    public void initResources() {
    }

    /**
     * Updates game variables.
     *
     * @param elapsedTime time passed after the last update.
     */
    @Override
    public void update(final long elapsedTime) {

        if (!_isGameOver) {

            _gameModel.update(elapsedTime);

        } else {

            _gameEngine.nextGameID = 1;
            finish();
        }
    }

    /**
     * Renders game screen.
     *
     * @param g2d graphics to render on.
     */
    @Override
    public void render(final Graphics2D g2d) {
        FieldView fieldView = _gameView.getFieldView();
        Bird player = _gameModel.getPlayer();
        int playerX = player.getPosition().x;
        int playerY = player.getPosition().y;
        fieldView.getBackground().setToCenter(
                playerX,
                playerY,
                player.getSize(),
                player.getSize()
        );
        _gameView.render(g2d);
    }

    /**
     * Starts the game.
     */
    public void startGame() {
        _gameModel.startGame();
    }

    /**
     * The getter for _playerController class member.
     *
     * @return value of _playerController.
     */
    public PlayerController getPlayerController() {
        return _playerController;
    }

    /**
     * The getter for _aiController class member.
     *
     * @return value of _aiController.
     */
    public AIController getAIController() {
        return _aiController;
    }

    /**
     * The reaction on bird eat pig event.
     *
     * @param event event object.
     */
    @Override
    public void birdEatPig(final EventObject event) {
        if (event.getSource().equals(_gameModel.getPlayer())) {
            bsSound.play("/sounds/pig_grunt.wav");
        }
    }

    /**
     * The reaction on bird hit wooden obstacle event.
     *
     * @param event event object.
     */
    @Override
    public void birdHitWoodenObstacle(final EventObject event) {
        if (event.getSource().equals(_gameModel.getPlayer())
                && _canPlayObstacleSound) {

            bsSound.play("/sounds/hit_wood.wav");
            bsSound.play("/sounds/bird_ouch.wav");
            _canPlayObstacleSound = false;
            _repeatObstacleSoundTimer.start();
        }
    }

    /**
     * The reaction on player fight computer bird event.
     *
     * @param event event obhect.
     */
    @Override
    public void playerFoughtComputerBird(final EventObject event) {
        if (event.getSource().equals(_gameModel.getPlayer())
                && _canPlayFightSound) {

            bsSound.play("/sounds/fight_computer_bird.wav");
            _canPlayFightSound = false;
            _repeatFightSoundTimer.start();
        }
    }

    @Override
    public void playerDied(final EventObject event) {
        _isGameOver = true;
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
            int baseMouseX = bsInput.getMouseX();
            int baseMouseY = bsInput.getMouseY();

            /* Getting background coordinates */
            Background background = _gameView.getFieldView().getBackground();
            int backgroundX = (int) background.getX();
            int backgroundY = (int) background.getY();

            /* Getting mouse coordinates on field */
            int mouseX = baseMouseX + backgroundX;
            int mouseY = baseMouseY + backgroundY;

            bird.setDestination(new Point(mouseX, mouseY));
        }
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
                        && object != _gameModel.getPlayer()) {

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
}
