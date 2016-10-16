package melihovv.PetriDish.events;

import java.util.EventListener;
import java.util.EventObject;

/**
 * The class represents listener interface for model events.
 */
public interface ModelListener extends EventListener {
    /**
     * The method to fire the event of eating a pig by a bird.
     *
     * @param event event object.
     */
    void birdEatPig(final EventObject event);

    /**
     * The method to fire the event of hitting a wooden obstacle by a bird.
     *
     * @param event event object.
     */
    void birdHitWoodenObstacle(final EventObject event);

    /**
     * The method to fire the event of fighting computer controlled bird by a
     * player bird.
     *
     * @param event event object.
     */
    void playerFoughtComputerBird(final EventObject event);

    /**
     * The method to fire the event of player's death.
     *
     * @param event event object.
     */
    void playerDied(final EventObject event);
}
