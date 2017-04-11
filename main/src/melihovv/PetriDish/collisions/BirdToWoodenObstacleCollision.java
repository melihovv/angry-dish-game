package melihovv.PetriDish.collisions;

import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.views.FieldObjectViews.FieldObjectView;

import melihovv.library.Sprite;
import melihovv.library.SpriteGroup;
import melihovv.library.BasicCollisionGroup;


/**
 * The collision manager that controls collisions between a player (bird) and
 * wooden obstacles.
 */
public class BirdToWoodenObstacleCollision extends BasicCollisionGroup {
    /**
     * The debug class member to count the amount collided function calls.
     */
    private int _counter = 0;

    /**
     * The basic constructor which sets collision groups.
     *
     * @param group1 first collision group.
     * @param group2 second collision group.
     */
    public BirdToWoodenObstacleCollision(
            final SpriteGroup group1,
            final SpriteGroup group2
    ) {
        setCollisionGroup(group1, group2);
    }

    /**
     * The collision implementation. Sets the actions when collision is
     * detected.
     * Bird stops when hit wooden obstacle.
     *
     * @param s1 first collision sprite.
     * @param s2 second collision sprite.
     */

    @Override
    public void collided(final Sprite s1, final Sprite s2) {
        // TODO: Delete 2 lines below
        System.out.print(++_counter);
        System.out.println(".Ooops! We've just hit that piece of wood!");

        FieldObjectView fieldObjectView1 = (FieldObjectView) s1;
        FieldObject fieldObject1 = fieldObjectView1.getFieldObject();

        FieldObjectView fieldObjectView2 = (FieldObjectView) s2;
        FieldObject fieldObject2 = fieldObjectView2.getFieldObject();

        if (fieldObject1 instanceof Bird) {

            Bird player = (Bird) fieldObject1;
            player.flyAwayFromObstacle(fieldObject2);
        }
    }
}
