package melihovv.PetriDish.views.FieldObjectViews;


import melihovv.PetriDish.fieldObjects.FieldObject;

import javax.imageio.ImageIO;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
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
     * Default Saturation component in HSB color model.
     * Used to paint oval around ActiveFieldObject.
     */
    private static final float OVAL_SATURATION = 0.9f;

    /**
     * Default Brightness component in HSB color model.
     * Used to paint oval around ActiveFieldObject.
     */
    private static final float OVAL_BRIGHTNESS = 0.9f;

    /**
     * Maximum value for Hue component in HSB color model.
     * Used to paint oval around ActiveFieldObject.
     */
    private static final float OVAL_HUE_MAX = 0.4f;

    /**
     * HUE component adjustment which changes the hueCoefficient value
     * every time the object grows.
     */
    private static final float HUE_ADJUSTMENT = 0.05f;
    /**
     * The default oval size. The oval is designed to show object growth.
     */
    private static final int DEFAULT_OVAL_SIZE = 7;
    /**
     * HUE component coefficient which changes the oval color when the object
     * grows.
     */
    private float _hueCoefficient = 0.0f;
    /**
     * The oval size. The oval is designed to show object growth.
     */
    private int _ovalSize = DEFAULT_OVAL_SIZE;

    /**
     * The maximum size of oval.
     */
    private static final int MAXIMUM_OVAL_SIZE = 21;

    /**
     * The basic constructor for class members initialization.
     *
     * @param fieldObject object for the object view.
     */
    public ActiveFieldObjectView(final FieldObject fieldObject) {
        super(fieldObject);
        createObjectView();
    }

    /**
     * Creates field object view for active field objects with size oval.
     *
     * @return object view.
     */
    @Override
    public Graphics2D createObjectView() {
        URI imageUri = null;
        int fieldObjectSize = getFieldObject().getSize();


        BufferedImage image = new BufferedImage(
                fieldObjectSize + _ovalSize + IMAGE_SIZE_ADJUSTMENT,
                fieldObjectSize + _ovalSize + IMAGE_SIZE_ADJUSTMENT,
                BufferedImage.TYPE_INT_ARGB
        );
        Graphics2D g2d = image.createGraphics();

        /* Drawing an oval */
        Color ovalColor = getHSBColor(_hueCoefficient);
        g2d.setColor(ovalColor);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH));
        g2d.drawOval(
                1,
                1,
                fieldObjectSize + _ovalSize,
                fieldObjectSize + _ovalSize);
        /* GTGE super class method */
        setImage(image);

        try {
            final InputStream stream = getClass()
                    .getClassLoader()
                    .getResourceAsStream(getImagePath());

            BufferedImage hero = ImageIO.read(stream);
            g2d.drawImage(
                    hero,
                    (fieldObjectSize + _ovalSize - hero.getWidth()) / 2,
                    (fieldObjectSize + _ovalSize - hero.getHeight()) / 2,
                    null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        getFieldObject().setSize(fieldObjectSize + _ovalSize);

        return g2d;
    }

    /**
     * Getter for _ovalSize class member.
     *
     * @return value of _ovalSize.
     */
    public int getOvalSize() {
        return _ovalSize;
    }

    /**
     * Adjusts object size.
     *
     * @param ovalSize value of _ovalSize.
     * @return if size was adjusted.
     */
    public boolean adjustSize(final int ovalSize) {

        if(ovalSize < MAXIMUM_OVAL_SIZE) {
            _ovalSize = ovalSize;
            _hueCoefficient += HUE_ADJUSTMENT;
            return true;

        } else {

            return false;
        }
    }

    /**
     * Gets color depending on hueCoefficient.
     * Uses HSB color model. Color range is limited by
     * OVAL_HUE_MAX class constant and 0. Saturation and Brightness
     * components are class constants.
     *
     * @param hueCoefficient HUE component coefficient to control color.
     * @return new color.
     */
    public Color getHSBColor(final float hueCoefficient) {

        /* Getiing HSB components */
        float hue = OVAL_HUE_MAX - hueCoefficient;
        float saturation = OVAL_SATURATION;
        float brightness = OVAL_BRIGHTNESS;

        /* Keeping red color as minimum */
        if (hue < 0) {

            hue = 0;
        }

        return Color.getHSBColor(hue, saturation, brightness);
    }
}
