package melihovv.AngryDish.views.FieldObjectViews;


import melihovv.AngryDish.fieldObjects.FieldObject;

/**
 * The class represents the appearance of a green bird.
 */
public class GreenBirdView extends ActiveFieldObjectView {
    /**
     * The path to the bird image.
     */
    private static final String IMAGE_PATH = "heroes/birds/computer_hero.png";

    /**
     * The basic constructor for class members initialization.
     *
     * @param fieldObject object for the object view.
     */
    public GreenBirdView(final FieldObject fieldObject) {
        super(fieldObject);
    }

    /**
     * Getter for the IMAGE_PATH class member.
     *
     * @return value of IMAGE_PATH.
     */
    @Override
    public String getImagePath() {
        return IMAGE_PATH;
    }
}
