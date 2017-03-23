package melihovv.library.collision;

import melihovv.library.collision.Math.CollisionPointPair;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Ellipse {
    public double x0;
    public double y0;
    public double _widthRadius;
    public double _heightRadius;

    public Ellipse(double x0, double y0, double wr, double hr) {
        this.x0 = x0;
        this.y0 = y0;
        this._widthRadius = wr;
        this._heightRadius = hr;
    }

    private CollisionPointPair getIntersectionPoints(Line l) {
        return Math.getCollisionPointsBetweenLineAndEllipse(
                l.k1,
                l.k2,
                l.k3,
                x0,
                y0,
                this._widthRadius,
                this._heightRadius
        );
    }

    protected boolean narrowCollidesWith(Ellipse o) {
        Line l = new Line(this.x0, this.y0, o.x0, o.y0);

        CollisionPointPair myPair = this.getIntersectionPoints(l);
        CollisionPointPair secondPair = this.getIntersectionPoints(l);

        Axle a = new Axle(l, this.x0, this.y0);
        double x11 = a.projectPoint(myPair.x1, myPair.y1);
        double x12 = a.projectPoint(myPair.x2, myPair.y2);

        double x21 = a.projectPoint(secondPair.x1, secondPair.y1);
        double x22 = a.projectPoint(secondPair.x2, secondPair.y2);

        return Math.collides1D(x11, x12, x21, x22);
    }

    public boolean collidesWith(Ellipse o) {
        double dx = java.lang.Math.abs(x0 - o.x0);
        double dy = java.lang.Math.abs(y0 - o.y0);

        if (dx <= 0.001 && dy <= 0.001) {
            return true;
        }

        double dist = java.lang.Math.sqrt(dx * dx + dy * dy);
        double maxNonCollisionDist = max(this._widthRadius, this._heightRadius)
                + max(o._widthRadius, o._heightRadius);
        double minNonCollisionDist = min(this._widthRadius, this._heightRadius)
                + min(o._widthRadius, o._heightRadius);

        if (dist > maxNonCollisionDist) {
            return false;
        }

        if (dist < minNonCollisionDist) {
            return true;
        }

        return this.narrowCollidesWith(o);
    }
}
