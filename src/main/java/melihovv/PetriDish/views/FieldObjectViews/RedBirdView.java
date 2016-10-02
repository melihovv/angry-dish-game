package melihovv.PetriDish.views.FieldObjectViews;


import melihovv.PetriDish.fieldObjects.FieldObject;

/**
 * The class represents the appearance of a bird.
 */
public class RedBirdView extends ActiveFieldObjectView {
    /**
     * The path to the bird image.
     */
    private static final String IMAGE_PATH = "/heroes/birds/main_hero.png";

    /**
     * The basic constructor for class members initialization.
     * @param fieldObject object for the object view.
     */
    public RedBirdView(final FieldObject fieldObject) {
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
