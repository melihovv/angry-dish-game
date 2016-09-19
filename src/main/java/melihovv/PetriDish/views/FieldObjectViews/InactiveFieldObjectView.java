package melihovv.PetriDish.views.FieldObjectViews;


import melihovv.PetriDish.fieldObjects.FieldObject;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;

/**
 * The class represents the appearance of an inactive field object.
 */
public abstract class InactiveFieldObjectView extends FieldObjectView {
    /**
     * The basic constructor for class members initialization.
     * @param fieldObject object for the object view.
     */
    public InactiveFieldObjectView(final FieldObject fieldObject) {
        super(fieldObject);
        createObjectView();
    }

    /**
     * Creates field object view for inactive field objects.
     */
    @Override
    public void createObjectView() {
        URI imageUri = null;
        int fieldObjectSize = getFieldObject().getSize();

        BufferedImage image = new BufferedImage(
                fieldObjectSize,
                fieldObjectSize,
                BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g2d = image.createGraphics();

        try {
            imageUri = getClass().getResource(getImagePath()).toURI();

            BufferedImage hero = ImageIO.read(new File(imageUri));
            g2d.drawImage(
                    hero,
                    (fieldObjectSize - hero.getWidth()) / 2,
                    (fieldObjectSize - hero.getHeight()) / 2,
                    null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /* GTGE super class method */
        setImage(image);
    }
}
