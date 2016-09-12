package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * A class represents main game character which is a player.
 * Extends ActiveFieldObject.
 */
public class Bird extends ActiveFieldObject {

    public Bird( GeneralFactory generalFactory ) {

        super( generalFactory );
    }

    public void update(long elapsedTime) {

        super.update( elapsedTime );
    }
}
