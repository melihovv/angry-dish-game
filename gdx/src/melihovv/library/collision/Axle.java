package melihovv.library.collision;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Axle {
    private double _px;
    private double _py;

    private double _x;
    private double _y;
    
    public Axle(Line l, double px, double py) {
        if (abs(l.k1) < 0.001 && abs(l.k2) < 0.001) {
            _x = 1;
            _y = 0;
        } else {
            double length = sqrt(l.k1 * l.k1 + l.k2 * l.k2);
            _x = l.k1 / length;
            _y = l.k2 / length;
        }

        this._px = px;
        this._py = py;
    }

    double projectPoint(double x, double y) {
        return this._x * (x - this._px) + this._y * (y - this._py);
    }
}
