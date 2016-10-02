package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * The class represents main game character which is a player.
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
    public RedBird(GeneralFactory generalFactory) {
        super(generalFactory);
        setSize(DEFAULT_SIZE);
        setFieldObjectView(generalFactory.createFieldObjectView(this));
    }

    @Override
    public void eat(FieldObject object) {
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
