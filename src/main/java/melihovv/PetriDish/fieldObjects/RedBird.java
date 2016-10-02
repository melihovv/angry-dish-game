package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * The class represents main game character controlled by a player.
 */
public class RedBird extends Bird {
    /**
     * The size of the bird.
     */
    private static final int DEFAULT_SIZE = 64;

    /**
     * The amount of eaten pigs.
     */
    private int _eatenPigsCounter;

    /**
     * The basic constructor for class members initialization.
     *
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public RedBird(final GeneralFactory generalFactory) {
        super(generalFactory);
        setSize(DEFAULT_SIZE);
        setFieldObjectView(generalFactory.createFieldObjectView(this));
    }

    /**
     * Overrides parent method by calling it and then increasing internal
     * counter of eaten pigs.
     *
     * @param object object to eat.
     */
    @Override
    public void eat(final FieldObject object) {
        super.eat(object);
        ++_eatenPigsCounter;
    }

    /**
     * The getter for _eatenPigsCounter class member.
     *
     * @return value of _eatenPigsCounter.
     */
    public int getEatenPigsCounter() {
        return _eatenPigsCounter;
    }
}
