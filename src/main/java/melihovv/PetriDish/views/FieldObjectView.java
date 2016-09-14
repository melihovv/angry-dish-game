package melihovv.PetriDish.views;

import com.golden.gamedev.object.Sprite;
import melihovv.PetriDish.fieldObjects.FieldObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * A class represents the appearance of a basic field object.
 */
public class FieldObjectView extends Sprite {

    private FieldObject _fieldObject;

    public void createObjectView(String imagePath) {

        int fieldObjectSize = _fieldObject.getSize();

        BufferedImage image = new BufferedImage( fieldObjectSize, fieldObjectSize, BufferedImage.TYPE_INT_ARGB );
        Graphics2D g2d = image.createGraphics();

        // TODO: Add if-clause to check object type
        try {

            BufferedImage hero = ImageIO.read( new File( imagePath ) );
            g2d.drawImage(
                    hero,
                    ( fieldObjectSize - hero.getWidth() ) / 2,
                    ( fieldObjectSize - hero.getHeight() ) / 2,
                    null );

        } catch( IOException e ) {

            e.printStackTrace();
        }

        /* GTGE super class method */
        setImage( image );
    }

    @Override
    public void update( long elapsedTime ) {

        super.update( elapsedTime );
        //#TODO: resize if model size has changed
    }

    public void setPosition( Point point ) {

        setX( point.x );
        setY( point.y );
    }

    public Point getPosition() {

        Point position = new Point( ( int ) getX(), ( int ) getY() );
        return position;
    }

    public FieldObject getFieldObject() {

        return _fieldObject;
    }

    public void setFieldObject( FieldObject fieldObject ) {

        _fieldObject = fieldObject;
    }
}
