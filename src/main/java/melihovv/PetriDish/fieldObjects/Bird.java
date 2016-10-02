package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.events.BirdListener;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.main.Field;
import melihovv.PetriDish.views.FieldObjectViews.ActiveFieldObjectView;

import java.awt.Point;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

/**
 * The class represents abstract bird which is field object.
 * Birds can move, eat pigs and hit obstacles.
 */
public abstract class Bird extends ActiveFieldObject {
    /**
     * The new position adjustment when hits a wooden obstacle.
     */
    private static final int POS_ADJUSTMENT = 400;

    /**
     * The set of bird listeners.
     */
    private List<BirdListener> _birdListeners = new ArrayList<>();

    /**
     * The amount of eaten pigs after the last growth.
     */
    private int _eatenPigsAfterGrowth;

    /**
     * The amount of eaten objects to grow. An active field object must eat this
     * amount to grow to a next size.
     */
    private int _birdsToGrowth;

    /**
     * The basic constructor for class members initialization.
     *
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public Bird(final GeneralFactory generalFactory) {
        super(generalFactory);
        _birdsToGrowth = 1;
    }

    /**
     * Updates bird state.
     *
     * @param elapsedTime time passed after the last update.
     */
    public void update(final long elapsedTime) {
        super.update(elapsedTime);

        if (getController() != null) {
            getController().controlMovement(this);
        }
    }

    /**
     * Throws the bird in the opposite direction when it hits the obstacle.
     *
     * @param obstacle obstacle which is hit by the bird.
     */
    public void flyAwayFromObstacle(final FieldObject obstacle) {

        Point newPos = null;

        Point playerPos = getPosition();
        Point obstaclePos = obstacle.getPosition();

        int minDistanceDifference = (getSize() + obstacle.getSize()) / 2;

        /* Flying from the bottom */
        if (Math.abs(playerPos.x - obstaclePos.x) < minDistanceDifference
                && playerPos.y > obstaclePos.y) {

            newPos = new Point(playerPos.x, playerPos.y + POS_ADJUSTMENT);

        /* Flying from the left */
        } else if (
                Math.abs(playerPos.y - obstaclePos.y) < minDistanceDifference
                        && playerPos.x < obstaclePos.x) {

            newPos = new Point(playerPos.x - POS_ADJUSTMENT, playerPos.y);

        /* Flying from the right */
        } else if (
                Math.abs(playerPos.y - obstaclePos.y) < minDistanceDifference
                        && playerPos.x > obstaclePos.x) {

            newPos = new Point(playerPos.x + POS_ADJUSTMENT, playerPos.y);

        /* Flying from the top */
        } else if (Math.abs(playerPos.x - obstaclePos.x) < minDistanceDifference
                && playerPos.y < obstaclePos.y) {

            newPos = new Point(playerPos.x, playerPos.y - POS_ADJUSTMENT);
        }

        setDestination(newPos);
        fireWoodenObstacleHit();
    }

    /**
     * Eats field object. Simply deletes it from the field and increases
     * eaten pigs counter.
     *
     * @param object object to eat.
     */
    public void eat(final FieldObject object) {
        Field.getInstance().removeFieldObject(object);
        ++_eatenPigsAfterGrowth;
        resize();
        firePigEaten();
    }

    /**
     * Adds bird listener.
     *
     * @param birdListener listener to add.
     */
    public void addBirdListener(final BirdListener birdListener) {
        _birdListeners.add(birdListener);
    }

    /**
     * Removes bird listener.
     *
     * @param birdListener listener to remove.
     */
    public void deleteBirdListener(final BirdListener birdListener) {
        _birdListeners.remove(birdListener);
    }

    /**
     * Fires the event of hitting the wooden obstacle to all bird listeners.
     */
    protected void fireWoodenObstacleHit() {
        EventObject event = new EventObject(this);
        for (BirdListener birdListener : _birdListeners) {
            birdListener.woodenObstacleHit(event);
        }
    }

    /**
     * Fires the event of eating a pig to all bird listeners.
     */
    protected void firePigEaten() {
        EventObject event = new EventObject(this);
        for (BirdListener birdListener : _birdListeners) {
            birdListener.pigEaten(event);
        }
    }

    /**
     * Fires the event of fighting computer bird to all bird listeners.
     */
    protected void fireFoughtComputerBird() {
        EventObject event = new EventObject(this);
        for (BirdListener birdListener : _birdListeners) {
            birdListener.foughtComputerBird(event);
        }
    }

    /**
     * Increases bird size if it ate enough birds.
     */
    private void resize() {

        if (_eatenPigsAfterGrowth >= _birdsToGrowth) {

            int currentSize = ((ActiveFieldObjectView) getFieldObjectView())
                    .getOvalSize();

            ((ActiveFieldObjectView) getFieldObjectView())
                    .setOvalSize(++currentSize);

            getFieldObjectView().createObjectView();
            refreshSpeed();

            ++_birdsToGrowth;
            _eatenPigsAfterGrowth = 0;
        }
    }
}
