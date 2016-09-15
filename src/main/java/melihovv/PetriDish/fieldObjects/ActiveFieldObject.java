package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.views.FieldObjectView;

import java.awt.Point;

/**
 * A class represents movable field object which do move and can interact with
 * other objects.
 */
public class ActiveFieldObject extends FieldObject {
    private static final int STOP_RADIUS = 15;
    private static final int DEFAULT_SPEED = 1;
    private static final double BREAK_COEFFICIENT = 500;

    private double _speed;
    private int _eatenPigsCounter;
    private Point _destination;
    private FieldObjectController _controller;

    public ActiveFieldObject(final GeneralFactory generalFactory) {
        super(generalFactory);
    }

    @Override
    public void update(final long elapsedTime) {
        move();
        super.update(elapsedTime);
    }

    public void move() {
        if (_destination != null) {
            Point currentPosition = getPosition();
            Point nextPosition = getDestination();
            FieldObjectView fieldObjectView = getObjectView();

            /* Getting distance to the next position */
            int xDistance = nextPosition.x - currentPosition.x
                    - (getSize() / 2);
            int yDistance = nextPosition.y - currentPosition.y
                    - (getSize() / 2);
            int distance = (int) Math
                    .sqrt((xDistance * xDistance) + (yDistance * yDistance));

            /* Changing speed to move */
            if ((Math.pow(xDistance, 2) + Math.pow(yDistance, 2))
                    <= Math.pow(STOP_RADIUS, 2)) {
                fieldObjectView.setSpeed(0, 0);
                _destination = null;
            } else {
                double min = Math.min(_speed, distance / BREAK_COEFFICIENT);
                int x = (Math.abs(xDistance) + Math.abs(yDistance));

                fieldObjectView.setSpeed(
                        min * xDistance / x,
                        min * yDistance / x
                );
            }

            /* Checking borders to stop moving */
            /* Left border */
            if (currentPosition.x <= 0
                    && fieldObjectView.getHorizontalSpeed() < 0) {
                fieldObjectView.setHorizontalSpeed(0);
            }

            /* Right border */
            if ((currentPosition.x + getSize()) >= Field.getFieldWidth()
                    && fieldObjectView.getHorizontalSpeed() > 0) {
                fieldObjectView.setHorizontalSpeed(0);
            }

            /* Top border */
            if (currentPosition.y <= 0
                    && fieldObjectView.getVerticalSpeed() < 0) {
                fieldObjectView.setVerticalSpeed(0);
            }

            /* Bottom border */
            if ((currentPosition.y + getSize()) >= Field.getFieldHeight()
                    && fieldObjectView.getVerticalSpeed() > 0) {
                fieldObjectView.setVerticalSpeed(0);
            }
        }
    }

    public void eat(final FieldObject object) {
        Field.getInstance().removeFieldObject(object);
        ++_eatenPigsCounter;
    }

    public FieldObjectController getController() {
        return _controller;
    }

    public void setController(final FieldObjectController controller) {
        _controller = controller;
    }

    @Override
    public void setSize(final int size) {
        super.setSize(size);
        // #TODO: Adjust speed when size has changed?
        _speed = DEFAULT_SPEED;
    }

    public Point getDestination() {
        if (_destination == null) {
            return new Point(0, 0);
        }

        return _destination;
    }

    public void setDestination(final Point destination) {
        _destination = destination;
    }

    @Override
    public void setPosition(final Point position) {
        super.setPosition(position);
        _destination = new Point(position);
    }

    public int getEatenPigsCounter() {
        return _eatenPigsCounter;
    }
}
