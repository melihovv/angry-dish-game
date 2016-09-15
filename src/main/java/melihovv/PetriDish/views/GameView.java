package melihovv.PetriDish.views;

import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.Pig;
import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.main.GameModel;

import java.awt.*;

import static java.awt.SystemColor.info;

/**
 * Main game view class which controls all its graphics.
 */
public class GameView {

    private final static int EATEN_PIGS_INFO_STRING_X = 1010;
    private final static int EATEN_PIGS_INFO_STRING_Y = 710;

    private FieldView _fieldView;
    private GameModel _gameModel;

    public GameView( FieldView fieldView, GameModel gameModel ) {

        _fieldView = fieldView;
        _gameModel = gameModel;
    }

    public void render( Graphics2D g2d ) {

        /* Rendering field */
        _fieldView.render( g2d );

        /* Rendering game info interface */
        String eatenPigsInfo = "Съедено свиней: " +
                _gameModel.getPlayer().getEatenPigsCounter() +
                "/" +
                Field.getInstance().getPigsCounter();

        g2d.setFont( new Font( "Impact", Font.BOLD, 25 ) );
        g2d.setColor( Color.green.darker() );

        g2d.drawString( eatenPigsInfo, EATEN_PIGS_INFO_STRING_X, EATEN_PIGS_INFO_STRING_Y );
    }

    public FieldView getFieldView() {

        return _fieldView;
    }
}
