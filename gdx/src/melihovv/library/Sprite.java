package melihovv.library;

import com.badlogic.gdx.graphics.Texture;
import melihovv.library.collision.Ellipse;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Sprite {
    private Texture _texture;
    private Ellipse _shape;

    private double _x = 0;
    private double _y = 0;

    private double _oldX = 0;
    private double _oldY = 0;

    private double _horizontalSpeed = 0;
    private double _verticalSpeed = 0;

    public Sprite() {

    }

    public Sprite(BufferedImage bi, int x, int y) {
        _x = x;
        _oldX = x;
        _y = y;
        _oldY = y;
        setImage(bi);
    }

    public final void setImage(BufferedImage bi) {
        _texture = TextureManager.getTexture(bi);
        _shape = new Ellipse(
                _x + _texture.getWidth() / 2,
                _y - _texture.getHeight() / 2,
                _texture.getWidth() / 2,
                _texture.getHeight() / 2
        );
    }

    public void update(long elapsed) {
        double nx = _x + _horizontalSpeed * elapsed;
        double ny = _y + _verticalSpeed * elapsed;

        _oldX = _x;
        _oldY = _y;

        _x = nx;
        _y = ny;

        _shape.x0 = _x + _texture.getWidth() / 2;
        _shape.y0 = _y - _texture.getHeight() / 2;
    }

    public void render(Graphics2D g) {
        if (_texture != null) {
            g.getBatch().draw(
                    _texture,
                    (float) _x,
                    (float) (_y - _texture.getHeight())
            );
        }
    }

    public void setX(double x) {
        _x = x;
        _shape.x0 = x + _texture.getWidth() / 2;
    }

    public void setY(double y) {
        _y = y;
        _shape.y0 = y - _texture.getHeight() / 2;
    }

    public double getX() {
        return _x;
    }

    public double getY() {
        return _y;
    }

    public void setHorizontalSpeed(double v) {
        _horizontalSpeed = v;
    }

    public void setVerticalSpeed(double v) {
        _verticalSpeed = v;
    }

    public double getOldX() {
        return _oldX;
    }

    public double getOldY() {
        return _oldY;
    }

    public Point getCenter() {
        return new Point((int) _shape.x0, (int) _shape.y0);
    }

    public Ellipse getCollisionShape() {
        return _shape;
    }

    public int getWidth() {
        return _texture.getWidth();
    }

    public int getHeight() {
        return _texture.getHeight();
    }

    public double getHorizontalSpeed() {
        return _horizontalSpeed;
    }

    public double getVerticalSpeed() {
        return _verticalSpeed;
    }

    public void stopOnGoingOutOfBounds(double totalWidth, double totalHeight) {
        if (this.getX() <= 0 && this.getHorizontalSpeed() < 0) {
            this.setHorizontalSpeed(0);
        }
        if (this.getX() + this.getWidth() >= totalWidth && this.getHorizontalSpeed() > 0) {
            this.setHorizontalSpeed(0);
        }
        if (this.getY() - this.getHeight() <= 0 && this.getVerticalSpeed() < 0) {
            this.setVerticalSpeed(0);
        }
        if (this.getY() >= totalHeight && this.getVerticalSpeed() > 0) {
            this.setVerticalSpeed(0);
        }
    }
}
