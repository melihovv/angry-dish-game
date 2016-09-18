package melihovv.PetriDish.views;

import com.golden.gamedev.object.Sprite;
import melihovv.PetriDish.fieldObjects.FieldObject;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * The class represents the appearance of a basic field object.
 */
public class FieldObjectView extends Sprite {
    /**
     * The field object associated with the current field object view.
     */
    private FieldObject _fieldObject;

    /**
     * Creates field object wiew based on image path.
     *
     * @param imagePath field object view image path.
     */
    public void createObjectView(final URI imagePath) {
        int fieldObjectSize = _fieldObject.getSize();

        BufferedImage image = new BufferedImage(
                fieldObjectSize,
                fieldObjectSize,
                BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g2d = image.createGraphics();

        // TODO: Add if-clause to check object type
        try {
            BufferedImage hero = ImageIO.read(new File(imagePath));
            g2d.drawImage(
                    hero,
                    (fieldObjectSize - hero.getWidth()) / 2,
                    (fieldObjectSize - hero.getHeight()) / 2,
                    null);

        } catch (IOException e) {
            e.printStackTrace();
        }

        /* GTGE super class method */
        setImage(image);
    }

    /**
     * Updates field object view image.
     *
     * @param elapsedTime time passed after the last update.
     */
    @Override
    public void update(final long elapsedTime) {
        super.update(elapsedTime);
        // TODO: resize if model size has changed
    }

    /**
     * The getter for the field object view position.
     *
     * @return field object view position
     */
    public Point getPosition() {
        return new Point((int) getX(), (int) getY());
    }

    /**
     * The setter for the field object view position.
     *
     * @param point value to set.
     */
    public void setPosition(final Point point) {
        setX(point.x);
        setY(point.y);
    }

    /**
     * The getter for the field object associated with the current field object
     * view.
     *
     * @return field object associated with the current field object view.
     */
    public FieldObject getFieldObject() {
        return _fieldObject;
    }

    /**
     * The setter for the field object associated with the current field object
     * view.
     *
     * @param fieldObject field object to set.
     */
    public void setFieldObject(final FieldObject fieldObject) {
        _fieldObject = fieldObject;
    }
}
