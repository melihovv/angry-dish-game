package melihovv.PetriDish.views;

import java.awt.*;

/**
 * Main game view class which controls all its graphics.
 */
public class GameView {

    private FieldView _fieldView;

    public GameView( FieldView fieldView ) {

        _fieldView = fieldView;
    }

    public void render( Graphics2D g2d) {

        _fieldView.render( g2d );
    }

    public FieldView getFieldView() {

        return _fieldView;
    }
}
