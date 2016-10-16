package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.FieldObjectsFactory;
import melihovv.PetriDish.main.Field;

/**
 * The class represents computer controlled birds.
 */
public class GreenBird extends Bird {
    /**
     * The size of the bird.
     */
    private static final int DEFAULT_SIZE = 64;

    /**
     * The basic constructor for class members initialization.
     */
    public GreenBird() {
        super();
        setSize(DEFAULT_SIZE);
        setFieldObjectView(FieldObjectsFactory.createFieldObjectView(this));
    }

    /**
     * Overrides parent method by calling it and then decreasing field's pig
     * counter.
     *
     * @param object object to eat.
     */
    @Override
    public void eatPig(final FieldObject object) {
        super.eatPig(object);
        Field.getInstance().decreasePigsCounter();
    }
}
