package melihovv.library;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class ImageBackground {
    private int _totalWidth = 0;

    private int _totalHeight = 0;

    private int _viewportWidth = 0;

    private int _viewportHeight = 0;

    private TextureRegion _region;

    private Texture _texture;

    public ImageBackground(BufferedImage bi) {
        _texture = TextureManager.getTexture(bi);
        _texture.setWrap(
                Texture.TextureWrap.Repeat,
                Texture.TextureWrap.Repeat
        );
    }

    public void setClip(int x, int y, int width, int height) {
        _viewportWidth = width;
        _viewportHeight = height;
    }

    public void setTotalClip(int totalWidth, int totalHeight) {
        this._totalWidth = totalWidth;
        this._totalHeight = totalHeight;
        _region = new TextureRegion(_texture);
    }

    public void update(long elapsed) {

    }

    public void render(Graphics2D g) {
        if (_region != null) {
            g.getBatch().draw(
                    _region,
                    0,
                    0,
                    this._totalWidth,
                    this._totalHeight
            );
        }
    }

    public void setToCenter(Sprite s) {
        Point center = s.getCenter();
        float x = center.x;
        float y = center.y;

        if ((x - _viewportWidth / 2) < 0) {
            x = _viewportWidth / 2;
        }

        if ((y - _viewportHeight / 2) < 0) {
            y = _viewportHeight / 2;
        }

        if ((x + _viewportWidth / 2) > _totalWidth) {
            x = _totalWidth - _viewportWidth / 2;
        }

        if ((y + _viewportHeight / 2) > _totalHeight) {
            y = _totalHeight - _viewportHeight / 2;
        }

        GameObject._currentCamera.position.set(x, y, 0);
    }

    public double getX() {
        return GameObject._currentCamera.position.x;
    }

    public double getY() {
        return GameObject._currentCamera.position.y;
    }
}
