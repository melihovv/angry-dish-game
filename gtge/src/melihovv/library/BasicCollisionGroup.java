package melihovv.library;

public class BasicCollisionGroup extends
        com.golden.gamedev.object.collision.BasicCollisionGroup{

    public BasicCollisionGroup() {
        super();
        this.pixelPerfectCollision = true;
    }

    @Override
    public void checkCollision() {
        super.checkCollision();
    }

    public void setCollisionGroup(SpriteGroup s1, SpriteGroup s2) {
        super.setCollisionGroup(s1, s2);
    }

    @Override
    public void collided(com.golden.gamedev.object.Sprite first,
                         com.golden.gamedev.object.Sprite second) {
        this.collided(first, second);
    }

    public void collided(Sprite first, Sprite second) {

    }
}
