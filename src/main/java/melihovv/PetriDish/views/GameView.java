package melihovv.PetriDish.views;

import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.main.GameModel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 * Main game view class which controls all its graphics.
 */
public class GameView {
    private static final int EATEN_PIGS_INFO_STRING_X = 1010;
    private static final int EATEN_PIGS_INFO_STRING_Y = 710;

    private FieldView _fieldView;
    private GameModel _gameModel;

    public GameView(final FieldView fieldView, final GameModel gameModel) {

        _fieldView = fieldView;
        _gameModel = gameModel;
    }

    public void render(final Graphics2D g2d) {

        /* Rendering field */
        _fieldView.render(g2d);

        /* Rendering game info interface */
        String eatenPigsInfo = "Съедено свиней: "
                + _gameModel.getPlayer().getEatenPigsCounter()
                + "/"
                + Field.getInstance().getPigsCounter();

        final int fontSize = 25;
        g2d.setFont(new Font("Impact", Font.BOLD, fontSize));
        g2d.setColor(Color.green.darker());

        g2d.drawString(
                eatenPigsInfo,
                EATEN_PIGS_INFO_STRING_X,
                EATEN_PIGS_INFO_STRING_Y
        );
    }

    public FieldView getFieldView() {
        return _fieldView;
    }
}
