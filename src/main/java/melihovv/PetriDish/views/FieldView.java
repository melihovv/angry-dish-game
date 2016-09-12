package melihovv.PetriDish.views;

import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.background.ImageBackground;
import melihovv.PetriDish.main.Application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * A class represents the appearance of a game field.
 */
public class FieldView {

    private final static String BACKGROUND_PATH = "src/main/resources/background.jpg";

    Background _background;

    public FieldView() {

        try {

            _background = new ImageBackground( ImageIO.read( new File( BACKGROUND_PATH ) ) );
            _background.setClip( 0, 0, Application.getScreenWidth(), Application.getScreenHeight() );

        } catch( IOException e ) {

            e.printStackTrace();
        }
    }

    public void render( Graphics2D g2d ) {

        _background.render( g2d );
    }

    public Background getBackground() {

        return _background;
    }
}
