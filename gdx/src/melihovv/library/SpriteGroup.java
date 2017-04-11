package melihovv.library;

import java.util.ArrayList;
import java.util.List;

public class SpriteGroup {
    String _name;
    ArrayList<Sprite> _list;

    public SpriteGroup(String string) {
        _name = string;
        _list = new ArrayList<>();
    }

    public void add(Sprite s) {
        _list.add(s);
    }

    public void remove(Sprite s) {
        _list.remove(s);
    }

    public void setBackground(ImageBackground bg) {

    }

    public void update(long elapsed) {
        _list.forEach((s) -> {
            s.update(elapsed);
        });
    }

    public void render(Graphics2D g) {
        _list.forEach((s) -> {
            s.render(g);
        });
    }

    public List<Sprite> toList() {
        return _list;
    }

    public void clear() {
        _list.clear();
        _name = "";
    }
}
