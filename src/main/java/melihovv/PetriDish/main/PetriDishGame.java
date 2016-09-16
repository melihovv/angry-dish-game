package melihovv.PetriDish.main;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import com.golden.gamedev.object.Background;
import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.views.FieldView;
import melihovv.PetriDish.views.GameView;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 * The basic game class which starts the game, controls its view and model, sets
 * window size.
 */
public class PetriDishGame extends Game {
    /**
     * The width of the game screen.
     */
    private static final int SCREEN_WIDTH = 1280;

    /**
     * The height of the game screen.
     */
    private static final int SCREEN_HEIGHT = 720;

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

    // #TODO: Uncomment the line below when game is ready
    //{distribute=true;}
    /**
     * The basic constructor for class members initialization.
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public PetriDishGame(final GeneralFactory generalFactory) {
        _gameModel = new GameModel(generalFactory);
        _playerController = new PlayerController();
        _gameView = new GameView(generalFactory.createFieldView(), _gameModel);
    }

    /**
     * The getter for SCREEN_WIDTH class member.
     * @return value of SCREEN_WIDTH.
     */
    public static int getScreenWidth() {

        return SCREEN_WIDTH;
    }

    /**
     * The getter for SCREEN_HEIGHT class member.
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
     * @param elapsedTime time passed after the last update.
     */
    @Override
    public void update(final long elapsedTime) {
        _gameModel.update(elapsedTime);
    }

    /**
     * Renders game screen.
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

        GameLoader gameLoader = new GameLoader();
        gameLoader.setup(
                this,
                new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT),
                false
        );
        gameLoader.start();
    }

    /**
     * The getter for _playerController class member.
     * @return value of _playerController.
     */
    public PlayerController getPlayerController() {
        return _playerController;
    }

    /**
     * The player controller class which controls player's behaviour.
     */
    private class PlayerController implements FieldObjectController {

        /**
         * Controls basic player movement.
         * @param bird player to control.
         */
        @Override
        public void controlMovement(final Bird bird) {
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
}
