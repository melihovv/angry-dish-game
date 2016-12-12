package melihovv.PetriDish.main;

import com.golden.gamedev.GameEngine;
import com.golden.gamedev.GameObject;
import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.background.ImageBackground;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class PetriDishGameStart extends GameObject {
    /**
     * The path to background image.
     */
    private static final String BACKGROUND_PATH =
            "src/main/resources/start_game_background.jpg";

    /**
     * The left x-axis coordinate of start button.
     */
    private static final int START_BUTTON_BEGIN_X = 572;

    /**
     * The right x-axis coordinate of start button.
     */
    private static final int START_BUTTON_END_X = 702;

    /**
     * The top y-axis coordinate of start button.
     */
    private static final int START_BUTTON_BEGIN_Y = 284;

    /**
     * The bottom y-axis coordinate of start button.
     */
    private static final int START_BUTTON_END_Y = 342;

    /**
     * The left x-axis coordinate of info button.
     */
    private static final int INFO_BUTTON_BEGIN_X = 1016;

    /**
     * The right x-axis coordinate of info button.
     */
    private static final int INFO_BUTTON_END_X = 1064;

    /**
     * The top y-axis coordinate of info button.
     */
    private static final int INFO_BUTTON_BEGIN_Y = 610;

    /**
     * The bottom y-axis coordinate of info button.
     */
    private static final int INFO_BUTTON_END_Y = 654;

    /**
     * The GameEngine object - parent.
     */
    private GameEngine _gameEngine;

    /**
     * The game over background.
     */
    private Background _background;

    /**
     * The basic constructor for class members initialization.
     *
     * @param gameEngine GameEngine object - parent.
     */
    public PetriDishGameStart(final GameEngine gameEngine) {
        super(gameEngine);

        _gameEngine = gameEngine;

        /* Initializing background */
        try {
            _background = new ImageBackground(
                    ImageIO.read(new File(BACKGROUND_PATH))
            );
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

        int mousePressed = bsInput.getMousePressed();
        int mouseX = bsInput.getMouseX();
        int mouseY = bsInput.getMouseY();

        if (mousePressed == MouseEvent.BUTTON1
                && mouseX >= START_BUTTON_BEGIN_X
                && mouseX <= START_BUTTON_END_X
                && mouseY >= START_BUTTON_BEGIN_Y
                && mouseY <= START_BUTTON_END_Y) {

            _gameEngine.nextGameID = 1;
            finish();

        } else if (mousePressed == MouseEvent.BUTTON1
                && mouseX >= INFO_BUTTON_BEGIN_X
                && mouseX <= INFO_BUTTON_END_X
                && mouseY >= INFO_BUTTON_BEGIN_Y
                && mouseY <= INFO_BUTTON_END_Y) {

            showInfoMessage();
        }
    }

    /**
     * Renders game screen.
     *
     * @param g2d graphics to render on.
     */
    @Override
    public void render(final Graphics2D g2d) {
        _background.render(g2d);
    }

    /**
     * Shows information about realized modifications.
     */
    private void showInfoMessage() {

        /* Showing info message */
        String text = "Модификация №1\n" +
                "- Сделать, чтобы цвет клетки зависел от ее массы\n" +
                "  Например, чем больше клетка, тем она краснее.\n\n" +
                "Модификация №2\n" +
                "- Показывать список возможностей игры и " +
                "выбранные модификации в начале запуска приложения.\n- " +
                "Сделать предельный размер клетки, больше которого нельзя " +
                "было бы физически набрать.\n" +
                "- Дать возможность игроку вводить никнейм перед началом " +
                "игры.\n" +
                "  Никнейм должен отображаться поверх клетки игрока";

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(
                frame,
                text,
                "Модификации",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
