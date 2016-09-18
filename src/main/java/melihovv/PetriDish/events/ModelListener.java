package melihovv.PetriDish.events;

/**
 * The class represents listener interface for model events.
 */
public interface ModelListener {
    /**
     * The method to fire the event of eating a pig by a bird.
     */
    void birdEatPig();

    /**
     * The method to fire the event of hitting a wooden obstacle by a bird.
     */
    void birdHitWoodenObstacle();
}
