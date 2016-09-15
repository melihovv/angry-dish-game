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
 * Basic game class which starts the game, controls its view and model, sets
 * window size.
 */
public class PetriDishGame extends Game {
    private static final int SCREEN_WIDTH = 1280;
    private static final int SCREEN_HEIGHT = 720;

    private GameView _gameView;
    private GameModel _gameModel;
    private PlayerController _playerController;

    // #TODO: Uncomment the line below when game is ready
    //{distribute=true;}
    public PetriDishGame(final GeneralFactory generalFactory) {
        _gameModel = new GameModel(generalFactory);
        _playerController = new PlayerController();
        _gameView = new GameView(generalFactory.createFieldView(), _gameModel);
    }

    public static int getScreenWidth() {

        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {

        return SCREEN_HEIGHT;
    }

    @Override
    public void initResources() {
    }

    @Override
    public void update(final long elapsedTime) {
        _gameModel.update(elapsedTime);
    }

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

    public void startApplication() {
        _gameModel.startGame();

        GameLoader gameLoader = new GameLoader();
        gameLoader.setup(
                this,
                new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT),
                false
        );
        gameLoader.start();
    }

    public PlayerController getPlayerController() {
        return _playerController;
    }

    private class PlayerController implements FieldObjectController {

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
