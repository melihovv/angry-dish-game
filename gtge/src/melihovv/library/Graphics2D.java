package melihovv.library;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class Graphics2D {

    private java.awt.Graphics2D _graphics2D;
    private BasicStroke _stroke;
    private Color _color;

    public Graphics2D(java.awt.Graphics2D g) {
        _graphics2D = g;
    }

    public java.awt.Graphics2D get() {
        return _graphics2D;
    }

    public void drawImage(BufferedImage image, int xStart, int yStart,
                          ImageObserver observer) {
        
        _graphics2D.drawImage(image,xStart,yStart, observer);
    }

    public void drawOval(int x, int y, int width, int height) {

        _graphics2D.drawOval(x, y, width, height);
    }

    public void setStroke(BasicStroke stroke) {

        this._stroke = stroke;
    }

    public void setColor(Color color) {
        this._color = color;
    }
}
