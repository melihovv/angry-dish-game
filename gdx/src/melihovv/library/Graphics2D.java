package melihovv.library;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

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
}
