package melihovv.PetriDish.fieldObjects;

import melihovv.PetriDish.events.BirdListener;
import melihovv.PetriDish.factories.GeneralFactory;
import melihovv.PetriDish.main.Field;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * The class represents main game character which is a player.
 */
public class Bird extends ActiveFieldObject {
    /**
     * The size of the bird.
     */
    private static final int DEFAULT_SIZE = 64;

    /**
     * The new position adjustment when hits a wooden obstacle.
     */
    private static final int POS_ADJUSTMENT = 400;

    /**
     * The amount of eaten pigs.
     */
    private int _eatenPigsCounter;

    /**
     * The set of bird listeners.
     */
    private List<BirdListener> _birdListeners = new ArrayList<>();

    /**
     * The basic constructor for class members initialization.
     *
     * @param generalFactory general game factory to create basic game
     *                       components.
     */
    public Bird(final GeneralFactory generalFactory) {
        super(generalFactory);
        setSize(DEFAULT_SIZE);
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
        ++_eatenPigsCounter;
        firePigEaten();
    }

    /**
     * The getter for _eatenPigsCounter class member.
     *
     * @return value of _eatenPigsCounter.
     */
    public int getEatenPigsCounter() {
        return _eatenPigsCounter;
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
    public void deleteObjectListener(final BirdListener birdListener) {
        _birdListeners.remove(birdListener);
    }

    /**
     * Fires the event of hitting the wooden obstacle to all bird listeners.
     */
    private void fireWoodenObstacleHit() {
        for (BirdListener birdListener : _birdListeners) {
            birdListener.woodenObstacleHit();
        }
    }

    /**
     * Fires the event of eating a pig to all bird listeners.
     */
    private void firePigEaten() {
        for (BirdListener birdListener : _birdListeners) {
            birdListener.pigEaten();
        }
    }
}
