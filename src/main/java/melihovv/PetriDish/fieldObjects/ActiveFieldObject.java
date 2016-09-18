package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.controllers.FieldObjectController;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.views.FieldObjectView;

import java.awt.Point;

/**
 * The class represents movable field object which do move and can interact with
 * other objects.
 */
public class ActiveFieldObject extends FieldObject {

    /**
     * The radius around the object where it starts decreasing its speed.
     */
    private static final int STOP_RADIUS = 15;

    /**
     * The default object speed.
     */
    private static final int DEFAULT_SPEED = 1;

    /**
     * The stopping factor.
     */
    private static final double BREAK_COEFFICIENT = 500;

    /**
     * The speed of the object.
     */
    private double _speed;

    /**
     * The destination point. Object moves towards it point.
     */
    private Point _destination;

    /**
     * The object controller.
     */
    private FieldObjectController _controller;

    /**
     * The basic constructor for class members initialization.
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public ActiveFieldObject(final GeneralFactory generalFactory) {
        super(generalFactory);
        _speed = DEFAULT_SPEED;
    }

    /**
     * Updates object state.
     * @param elapsedTime time passed after the last update.
     */
    @Override
    public void update(final long elapsedTime) {
        move();
        super.update(elapsedTime);
    }

    /**
     * Moves the object to its destination point.
     */
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

    /**
     * The getter for _controller class member.
     * @return value of _controller.
     */
    public FieldObjectController getController() {
        return _controller;
    }

    /**
     * The setter for _controller class member/
     * @param controller value to set.
     */
    public void setController(final FieldObjectController controller) {
        _controller = controller;
    }

    /**
     * The setter for _size class member.
     * @param size value to set.
     */
    @Override
    public void setSize(final int size) {
        super.setSize(size);
        // #TODO: Adjust speed when size has changed?
    }

    /**
     * The getter for _destination class member.
     * @return value of _destination.
     */
    public Point getDestination() {
        if (_destination == null) {
            return new Point(0, 0);
        }

        return _destination;
    }

    /**
     * The setter for _destination class member.
     * @param destination value to set.
     */
    public void setDestination(final Point destination) {
        _destination = destination;
    }

    /**
     * The setter for _position class member.
     * @param position value to set.
     */
    @Override
    public void setPosition(final Point position) {
        super.setPosition(position);
        _destination = new Point(position);
    }
}
