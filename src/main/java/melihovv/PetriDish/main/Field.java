package melihovv.PetriDish.main;

import melihovv.PetriDish.events.FieldObjectListener;
import melihovv.PetriDish.fieldObjects.FieldObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * A class represents game field.
 * Singleton class.
 */
public class Field {

    private final static int FIELD_WIDTH = 5000;
    private final static int FIELD_HEIGHT = 3750;

    private static Field _instance;
    private ArrayList< FieldObject > _fieldObjects = new ArrayList<>();
    private ArrayList< FieldObjectListener > _fieldObjectListeners = new ArrayList<>();

    public void addFieldObject( FieldObject object, Point position ) {

        object.setPosition( position );
        _fieldObjects.add( object );
        fireObjectAdded( object );
    }

    public void removeFieldObject( FieldObject object ) {

        _fieldObjects.remove( object );
        fireObjectDeleted( object );
    }

    public void update( long elapsedTime ) {

        for( FieldObject object : _fieldObjects ) {

            object.update( elapsedTime );
        }
    }

    public void addFieldObjectToRandomPosition( FieldObject object ) {

        Random randomizer = new Random();

        /* Getting random position coordinates */
        int x = randomizer.nextInt( FIELD_WIDTH );
        int y = randomizer.nextInt( FIELD_HEIGHT );

        Point randomPosition = new Point( x, y );

        if(isPositionFree( randomPosition,object )) {

            addFieldObject( object, randomPosition );
        }
    }

    public boolean isPositionFree( Point position, FieldObject object ) {

        int x = position.x;
        int y = position.y;
        int halfObjectSize = object.getSize() / 2;

        /* Checking field borders */
        if( x - halfObjectSize < 0 ||
                x + halfObjectSize >= FIELD_WIDTH ||
                y - halfObjectSize < 0 ||
                y + halfObjectSize >= FIELD_HEIGHT ) {

            return false;
        }

        /* Checking overlays with other field objects */
        for( FieldObject fieldObject : _fieldObjects ) {

            int x1 = fieldObject.getPosition().x;
            int y1 = fieldObject.getPosition().y;

            double distanceBetweenCenters = Math.sqrt( ( x - x1 ) * ( x - x1 ) + ( y - y1 ) * ( y - y1 ) );

            if(distanceBetweenCenters <= (object.getSize() + fieldObject.getSize()) / 2.0) {

                return  false;
            }
        }

        return  true;
    }

    public static Field getInstance() {

        if( _instance == null ) {

            _instance = new Field();
        }

        return _instance;
    }

    public static int getFieldWidth() {

        return FIELD_WIDTH;
    }

    public static int getFieldHeight() {

        return FIELD_HEIGHT;
    }

    public ArrayList< FieldObject > getFieldObjects() {

        return _fieldObjects;
    }

    public void addObjectListener( FieldObjectListener objectListener ) {

        _fieldObjectListeners.add( objectListener );
    }

    public void deleteObjectListener( FieldObjectListener objectListener ) {

        _fieldObjectListeners.remove( objectListener );
    }

    private void fireObjectAdded( FieldObject fieldObject ) {

        for( FieldObjectListener objectListener : _fieldObjectListeners ) {

            objectListener.fieldObjectAdded( fieldObject );
        }
    }

    private void fireObjectDeleted( FieldObject fieldObject ) {

        for( FieldObjectListener objectListener : _fieldObjectListeners ) {

            objectListener.fieldObjectDeleted( fieldObject );
        }
    }
}
