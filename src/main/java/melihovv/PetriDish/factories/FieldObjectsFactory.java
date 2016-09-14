package melihovv.PetriDish.factories;

import melihovv.PetriDish.fieldObjects.FieldObject;

import java.lang.reflect.Constructor;

/**
 * A factory to create field object based on class name.
 */
public class FieldObjectsFactory {

    /* Path to a package with field objects classes */
    private final static String PATH_TO_GAME_OBJECTS_PACKAGE =
            "melihovv.PetriDish.fieldObjects.";


    public FieldObject createFieldObject(String className,GeneralFactory generalFactory) {

        /* Forming full class name */
        String tmpClassName = PATH_TO_GAME_OBJECTS_PACKAGE;
        tmpClassName = tmpClassName.concat( className );
        Object fieldObject = null;

        try {

            Class c = Class.forName( tmpClassName );
            Constructor<?> constructor = c.getConstructor( GeneralFactory.class );
            fieldObject = constructor.newInstance( generalFactory );


        } catch( Exception e ) {

            e.printStackTrace();
        }

        return (FieldObject) fieldObject;

    }
}
