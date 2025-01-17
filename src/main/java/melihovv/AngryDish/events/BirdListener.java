package melihovv.AngryDish.events;

import java.util.EventListener;
import java.util.EventObject;

/**
 * The class represents listener interface for bird actions.
 */
public interface BirdListener extends EventListener {
    /**
     * The method to fire the event of hitting an obstacle by a bird.
     *
     * @param event event object.
     */
    void woodenObstacleHit(final EventObject event);

    /**
     * The method to fire the event of eating a pig by a bird.
     *
     * @param event event object.
     */
    void pigEaten(final EventObject event);

    /**
     * The method to fire the event of fighting computer controlled bird by a
     * player bird.
     *
     * @param event event object.
     */
    void foughtComputerBird(final EventObject event);

    /**
     * The method to fire the event of player's death.
     *
     * @param event event object.
     */
    void died(final EventObject event);
}
