package melihovv.PetriDish.views;

import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.main.GameModel;
import java.awt.Color;
import java.awt.Font;

import melihovv.library.SystemFont;
import melihovv.library.Graphics2D;

/**
 * The main game view class which controls all its graphics.
 */
public class GameView {
    /**
     * The x coordinate of the string with the information about eaten pigs.
     */
    private static final int EATEN_PIGS_INFO_STRING_X = 1010;

    /**
     * The y coordinate of the string with the information about eaten pigs.
     */

    private static final int EATEN_PIGS_INFO_STRING_Y = 680;

    /**
     * The part of game view which controls the appearance of game field.
     */
    private FieldView _fieldView;

    /**
     * The game model instance.
     */
    private GameModel _gameModel;

    /**
     * The basic constructor for class members initialization.
     *
     * @param gameModel game model instance.
     */
    public GameView(final GameModel gameModel) {

        _fieldView = new FieldView();
        Field.getInstance().addObjectListener(_fieldView);
        _gameModel = gameModel;
    }

    /**
     * Renders game view objects.
     *
     * @param g2d graphics to render on.
     */
    public void render(final Graphics2D g2d) {

        /* Rendering field */
        _fieldView.render(g2d);

        /* Rendering game info interface */
        String eatenPigsInfo = "Съедено свиней: "
                + _gameModel.getPlayer().getTotalAmountOfEatenPigs()
                + "/"
                + Field.getInstance().getPigsCounter();

        final int fontSize = 25;
        SystemFont font = new SystemFont(
                "Impact",
                Font.BOLD,
                fontSize,
                Color
                .green.darker()
        );

        font.drawString(
                g2d,
                eatenPigsInfo,
                EATEN_PIGS_INFO_STRING_X,
                EATEN_PIGS_INFO_STRING_Y
        );
    }

    /**
     * The getter for _fieldView class member.
     *
     * @return value of _fieldView.
     */
    public FieldView getFieldView() {
        return _fieldView;
    }
}
