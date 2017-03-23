package melihovv.library;

import java.util.List;

public class BasicCollisionGroup {
    SpriteGroup _group1;

    SpriteGroup _group2;

    public BasicCollisionGroup() {

    }

    public void checkCollision() {
        if (_group1 != null && _group2 != null) {
            List<Sprite> sprites1 = _group1.toList();
            List<Sprite> sprites2 = _group2.toList();
            for (int i = 0; i < sprites1.size(); i++) {
                for (int j = 0; j < sprites2.size(); j++) {
                    Sprite s1 = sprites1.get(i);
                    Sprite s2 = sprites2.get(j);
                    if (s1 != s2 && s1.getCollisionShape().collidesWith(s2.getCollisionShape())) {
                        this.collided(s1, s2);
                    }
                }
            }
        }
    }

    public void setCollisionGroup(SpriteGroup s1, SpriteGroup s2) {
        _group1 = s1;
        _group2 = s2;
    }


    public void collided(Sprite first, Sprite second) {

    }
}
