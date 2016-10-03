package melihovv.PetriDish.collisions;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.fieldObjects.RedBird;
import melihovv.PetriDish.views.FieldObjectViews.FieldObjectView;

/**
 * The collision manager that controls collisions between a player
 * (red bird) and computer controlled birds(green birds).
 */
public class PlayerToComputerBirdCollision extends BasicCollisionGroup {
    /**
     * The basic constructor which sets collision groups.
     *
     * @param group1 first collision group.
     * @param group2 second collision group.
     */
    public PlayerToComputerBirdCollision(
            final SpriteGroup group1,
            final SpriteGroup group2
    ) {
        setCollisionGroup(group1, group2);
        pixelPerfectCollision = true;
    }


    /**
     * The collision implementation. Sets the actions when collision is
     * detected.
     *
     * @param s1 first collision sprite.
     * @param s2 second collision sprite.
     */
    @Override
    public void collided(final Sprite s1, final Sprite s2) {
        FieldObjectView fieldObjectView1 = (FieldObjectView) s1;
        FieldObject fieldObject1 = fieldObjectView1.getFieldObject();

        if (fieldObject1 instanceof RedBird) {
            ((RedBird) fieldObject1).fight();
        }
    }
}
