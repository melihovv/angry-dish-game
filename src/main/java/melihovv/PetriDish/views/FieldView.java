package melihovv.PetriDish.views;

import com.golden.gamedev.object.Background;
import com.golden.gamedev.object.background.ImageBackground;
import melihovv.PetriDish.events.FieldObjectListener;
import melihovv.PetriDish.factories.FieldObjectsViewFactory;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.main.Application;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class represents the appearance of a game field.
 */
public class FieldView implements FieldObjectListener{

    // #TODO: Move resources folder out of src?
    private final static String BACKGROUND_PATH = "src/main/resources/background.jpg";

    Background _background;
    private ArrayList< FieldObjectView > _fieldObjectViews = new ArrayList<>();
    private FieldObjectsViewFactory _fieldObjectViewFactory = new FieldObjectsViewFactory();

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

        for(FieldObjectView objectView : _fieldObjectViews) {

            objectView.render( g2d );
        }
    }

    public Background getBackground() {

        return _background;
    }

    @Override
    public void fieldObjectAdded( FieldObject fieldObject ) {

        FieldObjectView fieldObjectView = _fieldObjectViewFactory.createFieldObjectView( fieldObject );
        fieldObjectView.setBackground( _background );
        _fieldObjectViews.add( fieldObjectView );
    }

    @Override
    public void fieldObjectDeleted( FieldObject fieldObject ) {

        for(FieldObjectView objectView : _fieldObjectViews) {

            if(fieldObject.equals( objectView.getFieldObject() )) {

                _fieldObjectViews.remove( objectView );
                return;
            }
        }
    }
}
