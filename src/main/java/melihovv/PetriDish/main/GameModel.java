package melihovv.PetriDish.main;

import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.factories.FieldObjectsFactory;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.Pig;

import java.awt.*;

/**
 * Base game model class which controls game logic.
 */
public class GameModel {

    private final static int PIGS_COUNT = 50;
    private final static int DEFAULT_PLAYER_X_POSITION = 2500;
    private final static int DEFAULT_PLAYER_Y_POSITION = 1875;

    private Bird _player;
    private GeneralFactory _generalFactory;
    private FieldObjectController _playerController;


    public GameModel( GeneralFactory generalFactory ) {

        _generalFactory = generalFactory;
    }

    public void update( long elapsedTime ) {

        Field.getInstance().update( elapsedTime );
    }

    public void startGame() {

        FieldObjectsFactory factory = new FieldObjectsFactory();

        /* Creating main player and its controller */
        _player = ( Bird ) factory.createFieldObject( "Bird",_generalFactory );
        _playerController = _generalFactory.createPlayerController();
        _player.setController( _playerController );
        
        Field.getInstance().addFieldObject( _player, new Point( DEFAULT_PLAYER_X_POSITION, DEFAULT_PLAYER_Y_POSITION ) );

        /* Creating pigs */
        for(int i = 0; i < PIGS_COUNT;++i) {

            Pig pig = ( Pig ) factory.createFieldObject( "Pig",_generalFactory );
            Field.getInstance().addFieldObjectToRandomPosition( pig );
        }
    }

    public Bird getPlayer() {

        return _player;
    }
}
