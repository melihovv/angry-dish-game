package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * A class represents main game character which is a player.
 */
public class Bird extends ActiveFieldObject {
    private static final int DEFAULT_SIZE = 64;

    public Bird(final GeneralFactory generalFactory) {
        super(generalFactory);
        setSize(DEFAULT_SIZE);
    }

    public void update(final long elapsedTime) {
        super.update(elapsedTime);

        if (getController() != null) {
            getController().controlMovement(this);
        }
    }
}
