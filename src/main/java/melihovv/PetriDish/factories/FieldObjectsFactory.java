package melihovv.PetriDish.factories;

import melihovv.PetriDish.fieldObjects.FieldObject;

import java.lang.reflect.Constructor;

/**
 * A factory to create field object based on class name.
 */
public class FieldObjectsFactory {
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
