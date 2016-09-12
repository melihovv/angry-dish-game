package melihovv.PetriDish.main;

/**
 * A class represents game field.
 * Singleton class.
 */
public class Field {

    private final static int FIELD_WIDTH = 5000;
    private final static int FIELD_HEIGH = 3750;

    private static Field _instance;

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
}
