package melihovv.library.collision;

/**
 * Математика для коллизий
 */
public class Math {
    
    /**
     * Пара точек, которые могут образоваться в процессе пересечения
     */
    public static class CollisionPointPair {
        public double x1;
        public double y1;
        
        public double x2;
        public double y2;
    }
    
    
    /**
     * Возвращает точки пересечения между линией. Формулы выведены решением в 
     * wxMaxima.
     * На входе прямая
     * k1x+k2y = k3 и эллипс
     * (_x-x0) / asq^2 + (_y - y0) / bsq^2 = 1
     * @param k1
     * @param k2
     * @param k3
     * @param x0
     * @param y0
     * @param asq
     * @param bsq
     * @return пара точек - результат пересечения
     */
    public static CollisionPointPair getCollisionPointsBetweenLineAndEllipse(
        double k1,
        double k2,
        double k3,
        double x0,
        double y0,
        double asq,
        double bsq
    )  {
        double a = asq * asq;
        double b = bsq * bsq;
        assert( java.lang.Math.abs(a) > 0.0001 );
        assert( java.lang.Math.abs(b) > 0.0001 );
        assert( (java.lang.Math.abs(k1) > 0.0001) || (java.lang.Math.abs(k2) > 0.0001) );
        double k32 = k3 * k3;
        double k22 = k2 * k2;
        double k12 = k1 * k1;       
        double x02 = x0 * x0;
        double y02 = y0 *y0;
        double b2 = b * b;
        double a2 = a * a;
        double delimiter = (b*k22+a*k12);
        double D1 = java.lang.Math.sqrt(-a*b*k22*y02+(2*a*b*k2*k3-2*a*b*k1*k2*x0)*y0-a*b*k12*x02+2*a*b*k1*k3*x0-a*b*k32+a*b2*k22+a2*b*k12);        
        double xr = a*k1*k2*y0-b*k22*x0-a*k1*k3;
        
        double D2 = java.lang.Math.sqrt(a*b)*k1*java.lang.Math.sqrt(-k22*y02-2*k1*k2*x0*y0+2*k2*k3*y0-k12*x02+2*k1*k3*x0-k32+b*k22+a*k12);
        double yr = a*k12*y0-b*k1*k2*x0+b*k2*k3;
        
        double xr1 = -(k2 * D1 + xr) / delimiter;
        double xr2 =  (k2 * D1 - xr)  / delimiter;
        double yr1 = (D2 + yr) / delimiter;
        double yr2 = (-D2 + yr) / delimiter;
        CollisionPointPair pair = new CollisionPointPair();
        pair.x1 = xr1;
        pair.x2 = xr2;
        pair.y1 = yr1;
        pair.y2 = yr2;
                
        return pair;
    }
    
    /**
     * Решает проблему определения пересечения для двух одномерных отрезков
     * [x11, x12], [x21, x22]
     * @param x11
     * @param x12
     * @param x21
     * @param x22
     * @return пересекаются ли отрезки
     */
    public static boolean collides1D(double x11, double x12, double x21, double x22) {
        if (x11 > x12) { 
            double tmp = x11;
            x11 = x12;
            x12 = tmp;
        }
        if (x21 > x22) { 
            double tmp = x21;
            x21 = x22;
            x22 = tmp;
        }
        return (x21 <= x12) && (x22 >= x11);        
    }
}
