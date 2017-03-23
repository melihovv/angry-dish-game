package melihovv.library;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class SystemFont {
    BitmapFont _font;

    public SystemFont(
            String fontName,
            int attrs,
            int size,
            java.awt.Color clr
    ) {
        _font = new BitmapFont();
        _font.setColor(new Color(
                clr.getRed() / 255.0f,
                clr.getGreen() / 255.0f,
                clr.getBlue() / 255.0f,
                clr.getAlpha() / 255.0f
        ));
    }

    public void drawString(Graphics2D g, String data, int x, int y) {
        float px = x +(GameObject._currentCamera.position.x - Gdx.graphics.getWidth() / 2);
        float py =  (Gdx.graphics.getHeight() - y) + (GameObject._currentCamera.position.y - Gdx.graphics.getHeight() / 2);
        _font.draw(
                g.getBatch(),
                data,
                px,
                py
        );
    }
}
