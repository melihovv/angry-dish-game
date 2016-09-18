package melihovv.PetriDish.events;

/**
 * The class represents listener interface for bird actions.
 */
public interface BirdListener {
    /**
     * The method to fire the event of hitting an obstacle by a bird.
     */
    void woodenObstacleHit();

    /**
     * The method to fire the event of eating a pig by a bird.
     */
    void pigEaten();
}
