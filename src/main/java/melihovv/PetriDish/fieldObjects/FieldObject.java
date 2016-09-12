package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.views.FieldObjectView;

import java.awt.*;

/**
 * A class represents basic object on a game field.
 */
public abstract class FieldObject {

    private final static int DEFAULT_SPEED = 1;

    private int _size;
    private double _speed;
    private Point _destination;
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
        // #TODO: Adjust speed when size has changed?
        _speed = DEFAULT_SPEED;
    }

    public Point getDestination() {

        if( _destination == null ) {

            return new Point( 0, 0 );
        }

        return _destination;
    }

    public void setDestination( Point destination ) {

        _destination = destination;
    }

    public void setPosition( Point position ) {

        _fieldObjectView.setPosition( new Point( position ) );
        _destination = new Point( position );
    }

    public Point getPosition() {

        return _fieldObjectView.getPosition();
    }

    public  FieldObjectView getObjectView() {

        return _fieldObjectView;
    }
}
