package melihovv.library;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class SystemFont {
    BitmapFont _font;
    public static final String RUSSIAN_CHARACTERS =
        "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
        + "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
        + "1234567890.,:;";

    public SystemFont(
            String fontName,
            int attrs,
            int size,
            java.awt.Color clr
    ) {
        _font = generateFont("Imperial Web.ttf", RUSSIAN_CHARACTERS + FreeTypeFontGenerator.DEFAULT_CHARS);
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

    private BitmapFont generateFont(String fontName, String characters) {
        // Configure font parameters
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = characters;
        parameter.size = 16;

        // Generate font
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(
            Gdx.files.internal(fontName)
        );
        BitmapFont font = generator.generateFont(parameter);

        // Dispose resources.
        generator.dispose();

        return font;
    }
}
