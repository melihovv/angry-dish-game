package melihovv.AngryDish.views.FieldObjectViews;


import melihovv.AngryDish.fieldObjects.FieldObject;

/**
 * The class represents the appearance of a pig.
 */
public class PigView extends InactiveFieldObjectView {
    /**
     * The path to the pig image.
     */
    private static final String IMAGE_PATH = "heroes/pigs/Pig32px.png";

    /**
     * The basic constructor for class members initialization.
     * @param fieldObject object for the object view.
     */
    public PigView(final FieldObject fieldObject) {
        super(fieldObject);
    }

    /**
     * Getter for the IMAGE_PATH class member.
     * @return value of IMAGE_PATH.
     */
    @Override
    public String getImagePath() {
        return IMAGE_PATH;
    }
}
