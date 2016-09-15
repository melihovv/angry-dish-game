package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.views.FieldObjectView;

import java.awt.Point;

/**
 * A class represents basic object on a game field.
 */
public abstract class FieldObject {
    private int _size;
    private FieldObjectView _fieldObjectView;

    public FieldObject(final GeneralFactory generalFactory) {
        _fieldObjectView = generalFactory.createFieldObjectView();
    }

    public void update(final long elapsedTime) {
        _fieldObjectView.update(elapsedTime);
    }

    public int getSize() {
        return _size;
    }

    public void setSize(final int size) {
        _size = size;
    }

    public Point getPosition() {
        return _fieldObjectView.getPosition();
    }

    public void setPosition(final Point position) {
        _fieldObjectView.setPosition(new Point(position));
    }

    public FieldObjectView getObjectView() {
        return _fieldObjectView;
    }
}
