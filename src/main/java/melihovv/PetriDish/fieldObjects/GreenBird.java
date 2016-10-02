package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;
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
     *
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public GreenBird(final GeneralFactory generalFactory) {
        super(generalFactory);
        setSize(DEFAULT_SIZE);
        setFieldObjectView(generalFactory.createFieldObjectView(this));
    }

    /**
     * Overrides parent method by calling it and then decreasing field's pig
     * counter.
     *
     * @param object object to eat.
     */
    @Override
    public void eat(final FieldObject object) {
        super.eat(object);
        Field.getInstance().decreasePigsCounter();
    }
}
