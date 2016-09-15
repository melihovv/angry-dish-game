package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;

/**
 * A class represents main game character which is a player.
 * Extends ActiveFieldObject.
 */
public class Bird extends ActiveFieldObject {

    private final int DEFAULT_SIZE = 64;

    public Bird( GeneralFactory generalFactory ) {

        super( generalFactory );
        setSize( DEFAULT_SIZE );
    }

    public void update(long elapsedTime) {

        super.update( elapsedTime );

        if(getController() != null) {

            getController().controlMovement( this );
        }
    }
}
