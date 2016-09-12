package melihovv.PetriDish.main;

import melihovv.PetriDish.events.FieldObjectListener;
import melihovv.PetriDish.fieldObjects.FieldObject;

import java.awt.*;
import java.util.ArrayList;

/**
 * A class represents game field.
 * Singleton class.
 */
public class Field {

    private final static int FIELD_WIDTH = 5000;
    private final static int FIELD_HEIGH = 3750;

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

    public static Field getInstance() {

        if( _instance == null ) {

            _instance = new Field();
        }

        return _instance;
    }

    public static int getFieldWidth() {

        return FIELD_WIDTH;
    }

    public static int getFieldHeigh() {

        return FIELD_HEIGH;
    }

    public ArrayList< FieldObject > getFieldObjects() {

        return _fieldObjects;
    }

    public void addObjectListener(FieldObjectListener objectListener) {

        _fieldObjectListeners.add( objectListener );
    }

    public void deleteObjectListener(FieldObjectListener objectListener) {

        _fieldObjectListeners.remove( objectListener );
    }

    private void fireObjectAdded( FieldObject fieldObject ) {

        for( FieldObjectListener objectListener : _fieldObjectListeners) {

            objectListener.fieldObjectAdded( fieldObject );
        }
    }

    private void fireObjectDeleted(FieldObject fieldObject) {

        for( FieldObjectListener objectListener : _fieldObjectListeners ) {

            objectListener.fieldObjectDeleted( fieldObject );
        }
    }
}
