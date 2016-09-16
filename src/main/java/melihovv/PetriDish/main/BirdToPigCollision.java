package melihovv.PetriDish.main;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.views.FieldObjectView;

/**
 * The basic collision manager that controls collisions between a player
 * (bird) and
 * pigs.
 */
public class BirdToPigCollision extends BasicCollisionGroup {
    /**
     * The debug class member to count the amount collided function calls.
     */
    private int _counter = 0;

    /**
     * The basic constructor which sets collision groups.
     * @param group1 first collision group.
     * @param group2 second collision group.
     */
    public BirdToPigCollision(
            final SpriteGroup group1,
            final SpriteGroup group2
    ) {
        setCollisionGroup(group1, group2);
        pixelPerfectCollision = true;
    }


    /**
     * The collision implementation. Sets the actions when collision is
     * detected.
     * Bird eats pig.
     * @param s1 first collision sprite.
     * @param s2 second collision sprite.
     */
    @Override
    public void collided(final Sprite s1, final Sprite s2) {
        // TODO: Delete 2 lines below
        System.out.print(++_counter);
        System.out.println(".A Bird has just eaten a pig!");

        FieldObjectView fieldObjectView1 = (FieldObjectView) s1;
        FieldObjectView fieldObjectView2 = (FieldObjectView) s2;

        FieldObject fieldObject1 = fieldObjectView1.getFieldObject();
        FieldObject fieldObject2 = fieldObjectView2.getFieldObject();

        if (fieldObject1 instanceof Bird) {
            ((Bird) fieldObject1).eat(fieldObject2);
        }
    }
}
