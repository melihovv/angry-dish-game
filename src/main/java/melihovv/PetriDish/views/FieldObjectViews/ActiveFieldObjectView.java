package melihovv.PetriDish.views.FieldObjectViews;


import melihovv.PetriDish.fieldObjects.FieldObject;

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;

/**
 * The class represents the appearance of an active field object.
 */
public abstract class ActiveFieldObjectView extends FieldObjectView {
    /**
     * The adjustment of an image size to look better.
     */
    private static final int IMAGE_SIZE_ADJUSTMENT = 5;

    /**
     * The oval stroke width.
     */
    private static final int STROKE_WIDTH = 3;

    /**
     * The default oval size. The oval is designed to show object growth.
     */
    private static final int DEFAULT_OVAL_SIZE = 7;

    /**
     * The oval size. The oval is designed to show object growth.
     */
    private int _ovalSize = DEFAULT_OVAL_SIZE;

    /**
     * The basic constructor for class members initialization.
     * @param fieldObject object for the object view.
     */
    public ActiveFieldObjectView(final FieldObject fieldObject) {
        super(fieldObject);
        createObjectView();
    }

    /**
     * Creates field object view for active field objects.
     */
    @Override
    public void createObjectView() {
        URI imageUri = null;
        int fieldObjectSize = getFieldObject().getSize();


        BufferedImage image = new BufferedImage(
                fieldObjectSize + _ovalSize + IMAGE_SIZE_ADJUSTMENT,
                fieldObjectSize + _ovalSize + IMAGE_SIZE_ADJUSTMENT,
                BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g2d = image.createGraphics();

        /* Drawing an oval */
        g2d.setColor(Color.ORANGE);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH));
        g2d.drawOval(
                1,
                1,
                fieldObjectSize + _ovalSize,
                fieldObjectSize + _ovalSize);
        /* GTGE super class method */
        setImage(image);

        try {
            imageUri = getClass().getResource(getImagePath()).toURI();

            BufferedImage hero = ImageIO.read(new File(imageUri));
            g2d.drawImage(
                    hero,
                    (fieldObjectSize + _ovalSize - hero.getWidth()) / 2,
                    (fieldObjectSize + _ovalSize - hero.getHeight()) / 2,
                    null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        getFieldObject().setSize(fieldObjectSize + _ovalSize);
    }

    /**
     * Getter for _ovalSize class member.
     * @return value of _ovalSize.
     */
    public int getOvalSize() {
        return _ovalSize;
    }

    /**
     * Setter for _ovalSize class member.
     * @param ovalSize value of _ovalSize.
     */
    public void setOvalSize(final int ovalSize) {
        _ovalSize = ovalSize;
    }
}
