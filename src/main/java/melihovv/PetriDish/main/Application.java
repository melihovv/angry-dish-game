package melihovv.PetriDish.main;

import com.golden.gamedev.Game;
import com.golden.gamedev.GameLoader;
import melihovv.PetriDish.views.FieldView;
import melihovv.PetriDish.views.GameView;

import java.awt.*;

/**
 * Basic game class which starts the game, controls its view and model, sets window size.
 * Extends GTGE Game class.
 */
public class Application extends Game {

    private final static int SCREEN_WIDTH = 1280;
    private final static int SCREEN_HEIGHT = 720;

    private GameView _gameView;
    private GameModel _gameModel;

    public Application() {

        _gameView = new GameView(new FieldView());
        _gameModel = new GameModel();
    }

    @Override
    public void initResources() {

    }

    @Override
    public void update( long l ) {

    }

    @Override
    public void render( Graphics2D g2d ) {

        _gameView.render( g2d );
    }

    public void startApplication() {

        GameLoader gameLoader = new GameLoader();
        gameLoader.setup(
                this,
                new Dimension( SCREEN_WIDTH, SCREEN_HEIGHT ),
                false );
        gameLoader.start();
    }

    public static int getScreenWidth() {

        return SCREEN_WIDTH;
    }

    public static int getScreenHeight() {

        return SCREEN_HEIGHT;
    }
}
