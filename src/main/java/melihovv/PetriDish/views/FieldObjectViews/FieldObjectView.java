package melihovv.PetriDish.views.FieldObjectViews;

import com.golden.gamedev.object.Sprite;
import melihovv.PetriDish.fieldObjects.FieldObject;

import java.awt.Point;

/**
 * The class represents the appearance of a basic field object.
 */
public abstract class FieldObjectView extends Sprite {
    /**
     * The field object associated with the current field object view.
     */
    private FieldObject _fieldObject;

    /**
     * The basic constructor for class members initialization.
     *
     * @param fieldObject object for the object view.
     */
    public FieldObjectView(final FieldObject fieldObject) {
        _fieldObject = fieldObject;
    }

    /**
     * Creates field object view.
     */
    public abstract void createObjectView();

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

    /**
     * Getter for the field object image path.
     *
     * @return image path.
     */
    public abstract String getImagePath();
}
