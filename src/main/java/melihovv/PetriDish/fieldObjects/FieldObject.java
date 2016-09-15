package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.views.FieldObjectView;

import java.awt.*;

/**
 * A class represents basic object on a game field.
 */
public abstract class FieldObject {

    private int _size;
    private FieldObjectView _fieldObjectView;

    public FieldObject( GeneralFactory generalFactory ) {

        _fieldObjectView = generalFactory.createFieldObjectView();
    }

    public void update(long elapsedTime) {

        _fieldObjectView.update( elapsedTime );
    }

    public int getSize() {

        return _size;
    }

    public void setSize( int size ) {

        _size = size;
    }

    public void setPosition( Point position ) {

        _fieldObjectView.setPosition( new Point( position ) );
    }

    public Point getPosition() {

        return _fieldObjectView.getPosition();
    }

    public  FieldObjectView getObjectView() {

        return _fieldObjectView;
    }
}
