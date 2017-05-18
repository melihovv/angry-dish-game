package melihovv.library.collision;

import static java.lang.Math.abs;

public class Line {
    public double k1;
    public double k2;
    public double k3;
    
    public Line(double x1, double y1, double x2, double y2) {
        boolean xAreEqual = abs(x1 - x2) < 0.001;
        boolean yAreEqual = abs(y1 - y2) < 0.001;

        if (yAreEqual) {
            if (xAreEqual) {
                k1 = 1;
                k2 = 0;
                k3 = x1;
            } else {
                k1 = 0;
                k2 = 1;
                k3 = y1;
            }
        } else {
            k1 = 1;
            k2 = (x2 - x1) / (y1 - y2);
            k3 = k1 * x1 + k2 * y1;
        }
    }
}
