package melihovv.PetriDish.main;

import com.golden.gamedev.object.Sprite;
import com.golden.gamedev.object.SpriteGroup;
import com.golden.gamedev.object.collision.BasicCollisionGroup;

/**
 * Basic collision manager that controls collisions between a player(bird) and pigs.
 */
public class BirdToPigCollision extends BasicCollisionGroup {

    int _counter = 0;

    public BirdToPigCollision( SpriteGroup group1,SpriteGroup group2 ) {

        setCollisionGroup( group1, group2 );
        pixelPerfectCollision = true;
    }


    @Override
    public void collided( Sprite s1, Sprite s2 ) {

        System.out.print(++_counter);
        System.out.println( "A Bird has just eaten a pig!" );
    }
}
