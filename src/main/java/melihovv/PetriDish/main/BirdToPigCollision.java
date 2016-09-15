package melihovv.PetriDish.main;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;
import melihovv.PetriDish.fieldObjects.Bird;
import melihovv.PetriDish.fieldObjects.FieldObject;
import melihovv.PetriDish.views.FieldObjectView;

/**
 * Basic collision manager that controls collisions between a player(bird) and
 * pigs.
 */
public class BirdToPigCollision extends BasicCollisionGroup {
    private int _counter = 0;

    public BirdToPigCollision(
            final SpriteGroup group1,
            final SpriteGroup group2
    ) {
        setCollisionGroup(group1, group2);
        pixelPerfectCollision = true;
    }


    @Override
    public void collided(final Sprite s1, final Sprite s2) {
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
