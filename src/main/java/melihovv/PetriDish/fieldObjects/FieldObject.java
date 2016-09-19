package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.views.FieldObjectViews.FieldObjectView;

import java.awt.Point;

/**
 * The class represents basic object on a game field.
 */
public abstract class FieldObject {
    /**
     * The size of an object. Object is considered as square.
     */
    private int _size;

    /**
     * The appearance of an object.
     */
    private FieldObjectView _fieldObjectView;

    /**
     * The basic constructor for class members initialization.
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public FieldObject(final GeneralFactory generalFactory) {
    }

    /**
     * Updates object view.
     * @param elapsedTime time passed after the last update.
     */
    public void update(final long elapsedTime) {
        _fieldObjectView.update(elapsedTime);
    }

    /**
     * The getter for _size class member.
     * @return value of _size.
     */
    public int getSize() {
        return _size;
    }

    /**
     * The setter for _size class member.
     *
     * @param size value of _size.
     */
    public void setSize(final int size) {
        _size = size;
    }

    /**
     * The getter for object position.
     * @return object position on field.
     */
    public Point getPosition() {
        return _fieldObjectView.getPosition();
    }

    /**
     * The setter for object position.
     * @param position position to set.
     */
    public void setPosition(final Point position) {
        _fieldObjectView.setPosition(new Point(position));
    }

    /**
     * The getter for _fieldObjectView class member.
     * @return value of _fieldObjectView.
     */
    public FieldObjectView getObjectView() {
        return _fieldObjectView;
    }

    /**
     * Getter for _fieldObjectView class member.
     * @return value of _fieldObjectView.
     */
    public FieldObjectView getFieldObjectView() {
        return _fieldObjectView;
    }
}
