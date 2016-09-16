package melihovv.PetriDish.factories;

import melihovv.PetriDish.fieldObjects.FieldObject;

import java.lang.reflect.Constructor;

/**
 * The factory to create instances of FieldObject class based on subclass types.
 */
public class FieldObjectsFactory {
    /**
     * Creates an instance of FieldObject class based on specified subclass.
     * @param c specified subclass.
     * @param generalFactory general factory as a parameter for field object
     *                       constructor.
     * @return an instance of FieldObject class with the specified subclass
     * type.
     */
    public FieldObject createFieldObject(
            final Class c,
            final GeneralFactory generalFactory
    ) {
        Object fieldObject = null;

        try {
            Constructor<?> constructor = c.getConstructor(GeneralFactory.class);
            fieldObject = constructor.newInstance(generalFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (FieldObject) fieldObject;
    }
}
