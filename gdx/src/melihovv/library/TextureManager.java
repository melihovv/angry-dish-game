package melihovv.library;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TextureManager {
    private static List<Entry> _entries;
    private static HashMap<String, Texture> _cache = new HashMap<>();

    private static class Entry {
        Texture _texture;
        BufferedImage _image;
    }

    public static Texture imageToTexture(BufferedImage img) {
        String s = img.toString();
        if (_cache.containsKey(s)) {
            return _cache.get(s);
        }

        Pixmap px = new Pixmap(
                img.getWidth(),
                img.getHeight(),
                Pixmap.Format.RGBA8888
        );
        px.setBlending(Pixmap.Blending.None);
        px.setColor(Color.CYAN);

        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int color = img.getRGB(i, j);
                int red = (color & 0x00ff0000) >> 16;
                int green = (color & 0x0000ff00) >> 8;
                int blue = color & 0x000000ff;
                int alpha = (color >> 24) & 0xff;
                px.setColor(
                        red / 255.0f,
                        green / 255.0f,
                        blue / 255.0f,
                        alpha / 255.0f
                );
                px.drawPixel(i, j);
            }
        }

        Texture t = new Texture(px);
        _cache.put(s, t);

        return t;
    }

    public static Texture getTexture(BufferedImage img) {
        if (_entries == null) {
            _entries = new ArrayList<>();
        }

        for (Entry m_entry : _entries) {
            if (m_entry._image == img) {
                return m_entry._texture;
            }
        }

        Texture tex = TextureManager.imageToTexture(img);
        Entry e = new Entry();
        e._image = img;
        e._texture = tex;
        _entries.add(e);

        return e._texture;
    }

    public static void disposeTextures() {
        if (_entries != null) {
            _entries.forEach((m_entry) -> m_entry._texture.dispose());
        }
    }
}
