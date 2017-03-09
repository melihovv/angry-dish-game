package melihovv.library;

import java.util.ArrayList;
import java.util.List;

public class SpriteGroup extends com.golden.gamedev.object.SpriteGroup {

    public SpriteGroup(String s) {
        super(s);
    }

    public void add(Sprite sprite) {
        super.add(sprite);
    }


    public void remove(Sprite sprite) {
        super.remove(sprite);
    }

    public void setBackground(ImageBackground background) {
        super.setBackground(background);
    }

    @Override
    public void update(long l) {
        super.update(l);
    }

    public void render(Graphics2D g) {
        super.render(g.get());
    }

    public List<Sprite> toList() {

        List<Sprite> result = new ArrayList<>();
        com.golden.gamedev.object.Sprite[] local = this.getSprites();

        for (com.golden.gamedev.object.Sprite sprite : local) {

            result.add((Sprite) sprite);
        }

        return result;
    }

}
