package melihovv.library;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Graphics2D {
    SpriteBatch _batch;

    public Graphics2D(SpriteBatch batch) {
        _batch = batch;
    }

    public void begin() {
        _batch.begin();
    }

    public void end() {
        _batch.end();
    }

    public SpriteBatch getBatch() {
        return _batch;
    }

    public void setColor(Color color) {
        _batch.setColor(
                color.getRed(),
                color.getGreen(),
                color.getBlue(),
                color.getAlpha()
        );
    }

    public void setStroke(BasicStroke stroke) {
        // TODO
    }
}
