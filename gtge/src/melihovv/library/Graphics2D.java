package melihovv.library;

public class Graphics2D {

    private java.awt.Graphics2D _graphics2D;

    public Graphics2D(java.awt.Graphics2D g) {
        _graphics2D = g;
    }

    java.awt.Graphics2D get() {
        return _graphics2D;
    }
}
