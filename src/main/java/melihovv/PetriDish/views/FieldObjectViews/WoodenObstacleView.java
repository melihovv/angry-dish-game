package melihovv.PetriDish.views.FieldObjectViews;


import melihovv.PetriDish.fieldObjects.FieldObject;

/**
 * The class represents the appearance of a wooden obstacle.
 */
public class WoodenObstacleView extends InactiveFieldObjectView {
    /**
     * The path to the wooden obstacle image.
     */
    private static final String IMAGE_PATH = "/obstacles/wooden_brick.png";

    /**
     * The basic constructor for class members initialization.
     *
     * @param fieldObject object for the object view.
     */
    public WoodenObstacleView(final FieldObject fieldObject) {
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
