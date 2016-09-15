package melihovv.PetriDish.views;

import melihovv.PetriDish.main.GameModel;

import java.awt.*;

/**
 * Main game view class which controls all its graphics.
 */
public class GameView {

    private FieldView _fieldView;
    private GameModel _gameModel;

    public GameView( FieldView fieldView,GameModel gameModel ) {

        _fieldView = fieldView;
        _gameModel = gameModel;
    }

    public void render( Graphics2D g2d) {

        _fieldView.render( g2d );

        g2d.setFont( new Font( "Impact",Font.BOLD,25 ));
        g2d.setColor( Color.green.darker());

        g2d.drawString( "Съедено свиней: 5/10",1000,700 );
    }

    public FieldView getFieldView() {

        return _fieldView;
    }
}
