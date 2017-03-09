package melihovv.library;

import java.awt.Font;

public class SystemFont extends com.golden.gamedev.object.font.SystemFont {

    public SystemFont(String fontName, int attrs, int size, java.awt.Color clr) {
        super(new Font(fontName, attrs, size), clr);
    }

    public void drawString(Graphics2D g, String data, int x, int y) {
        super.drawString(g.get(), data, x, y);
    }
}
