package melihovv.PetriDish.main;

import javax.imageio.ImageIO;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;

import melihovv.library.GameEngine;
import melihovv.library.GameObject;
import melihovv.library.Graphics2D;
import melihovv.library.ImageBackground;

/**
 * This game class represents game over screen and allows user to restart tne
 * game.
 */
public class PetriDishGameOver extends GameObject {
    /**
     * The path to background image.
     */
    private static final String BACKGROUND_PATH = "game_over_background.jpg";

    /**
     * The left x-axis coordinate of reset button.
     */
    private static final int RESET_BUTTON_BEGIN_X = 1198;

    /**
     * The right x-axis coordinate of reset button.
     */
    private static final int RESET_BUTTON_END_X = 1275;

    /**
     * The top y-axis coordinate of reset button.
     */
    private static final int RESET_BUTTON_BEGIN_Y = 635;

    /**
     * The bottom y-axis coordinate of reset button.
     */
    private static final int RESET_BUTTON_END_Y = 710;

    /**
     * The game over background.
     */
    private ImageBackground _background;

    /**
     * The GameEngine object - parent.
     */
    private GameEngine _gameEngine;

    /**
     * The basic constructor for class members initialization.
     *
     * @param gameEngine GameEngine object - parent.
     */
    public PetriDishGameOver(final GameEngine gameEngine) {

        //super(gameEngine);
        _gameEngine = gameEngine;

        /* Initializing background */
        try {
            final InputStream stream = getClass()
                    .getClassLoader()
                    .getResourceAsStream(BACKGROUND_PATH);
            _background = new ImageBackground(ImageIO.read(stream));
            _background.setClip(
                    0,
                    0,
                    PetriDishGame.getScreenWidth(),
                    PetriDishGame.getScreenHeight()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        int mouseX = getMouseX();
        int mouseY = getMouseY();


        if (isLeftMouseKeyPressed()
                && mouseX >= RESET_BUTTON_BEGIN_X
                && mouseX <= RESET_BUTTON_END_X
                && mouseY >= RESET_BUTTON_BEGIN_Y
                && mouseY <= RESET_BUTTON_END_Y) {

            //_gameEngine.nextGameID = 0;
            //finish();
        }
    }

    /**
     * Renders game screen.
     *
     * @param g2d graphics to render on.
     */
    @Override
    public void renderInContext(final Graphics2D g2d) {
        _background.render(g2d);
    }
}
