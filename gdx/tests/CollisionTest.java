import junit.framework.Assert;
import melihovv.library.collision.Ellipse;
import melihovv.library.collision.Line;
import melihovv.library.collision.Math;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class CollisionTest {
    @Test
    public void testCollision() {
        {
            double k1 = 0;
            double k2 = 1;
            double k3 = 0;
            double x0 = 0;
            double y0 = 0;
            double a = 1;
            double b = 1;
            Math.CollisionPointPair pair = Math.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            assertEquals(pair.x1, -1.0, 0.001);
            assertEquals(pair.y1, 0.0, 0.001);
            assertEquals(pair.x2, 1.0, 0.001);
            assertEquals(pair.y2, 0.0, 0.001);
        }
        {
            double k1 = 1;
            double k2 = 0;
            double k3 = 0;
            double x0 = 0;
            double y0 = 0;
            double a = 2;
            double b = 2;
            Math.CollisionPointPair pair = Math.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            assertEquals(pair.x1, 0.0, 0.001);
            assertEquals(pair.y1, 2.0, 0.001);
            assertEquals(pair.x2, 0.0, 0.001);
            assertEquals(pair.y2, -2.0, 0.001);
        }
        // Начало координат, эллипс
        {
            double k1 = 0;
            double k2 = 1;
            double k3 = 0;
            double x0 = 0;
            double y0 = 0;
            double a = 2;
            double b = 1;
            Math.CollisionPointPair pair = Math.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            assertEquals(pair.x1, -2.0, 0.001);
            assertEquals(pair.y1, 0.0, 0.001);
            assertEquals(pair.x2, 2.0, 0.001);
            assertEquals(pair.y2, 0.0, 0.001);
        }
        {
            double k1 = 1;
            double k2 = 0;
            double k3 = 0;
            double x0 = 0;
            double y0 = 0;
            double a = 1;
            double b = 2;
            Math.CollisionPointPair pair = Math.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            assertEquals(pair.x1, 0.0, 0.001);
            assertEquals(pair.y1, 2.0, 0.001);
            assertEquals(pair.x2, 0.0, 0.001);
            assertEquals(pair.y2, -2.0, 0.001);
        }
        // Смещение кординат
        {
            double k1 = 0;
            double k2 = 1;
            double k3 = 3;
            double x0 = 2;
            double y0 = 3;
            double a = 2;
            double b = 1;
            Math.CollisionPointPair pair = Math.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            assertEquals(pair.x1, 0.0, 0.001);
            assertEquals(pair.y1, 3.0, 0.001);
            assertEquals(pair.x2, 4.0, 0.001);
            assertEquals(pair.y2, 3.0, 0.001);
        }
        {
            double k1 = 1;
            double k2 = 0;
            double k3 = 2;
            double x0 = 2;
            double y0 = 3;
            double a = 1;
            double b = 2;
            Math.CollisionPointPair pair = Math.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            assertEquals(pair.x1, 2.0, 0.001);
            assertEquals(pair.y1, 5.0, 0.001);
            assertEquals(pair.x2, 2.0, 0.001);
            assertEquals(pair.y2, 1.0, 0.001);
        }
        // Диагональ
        {
            double k1 = 1;
            double k2 = -1;
            double k3 = 0;
            double x0 = 2;
            double y0 = 2;
            double a = 2;
            double b = 2;
            Math.CollisionPointPair pair = Math.getCollisionPointsBetweenLineAndEllipse(k1, k2, k3, x0, y0, a, b);
            assertEquals(pair.x1, 3.4142, 0.001);
            assertEquals(pair.y1, 3.4142, 0.001);
            assertEquals(pair.x2, 0.5857, 0.001);
            assertEquals(pair.y2, 0.5857, 0.001);
        }
    }

    @Test
    public void testLine() {
        {
            Line l = new Line(1, 0, 1, 1);
            assertEquals(l.k1, 1, 0.001);
            assertEquals(l.k2, 0, 0.001);
            assertEquals(l.k3, 1, 0.001);
        }
        {
            Line l = new Line(1, 1, 1, 1);
            assertEquals(l.k1, 1, 0.001);
            assertEquals(l.k2, 0, 0.001);
            assertEquals(l.k3, 1, 0.001);
        }
        {
            Line l = new Line(0, 1, 1, 1);
            assertEquals(l.k1, 0, 0.001);
            assertEquals(l.k2, 1, 0.001);
            assertEquals(l.k3, 1, 0.001);
        }
        {
            Line l = new Line(1, 1, 2, 2);
            assertEquals(l.k1, 1, 0.001);
            assertEquals(l.k2, -1, 0.001);
            assertEquals(l.k3, 0, 0.001);
        }
        {
            Line l = new Line(2, 3, 3, 4);
            assertEquals(l.k1, 1, 0.001);
            assertEquals(l.k2, -1, 0.001);
            assertEquals(l.k3, -1, 0.001);
        }
    }

    @Test
    public void testEllipses() {
        assertTrue((new Ellipse(0, 0, 2, 1)).collidesWith(new Ellipse(0, 0, 2, 1)));
        assertTrue((new Ellipse(0, 0, 2, 1)).collidesWith(new Ellipse(0, 3, 2, 1)));
        assertTrue((new Ellipse(0, 0, 2, 1)).collidesWith(new Ellipse(0, 4, 2, 1)));
        assertFalse((new Ellipse(0, 0, 2, 1)).collidesWith(new Ellipse(0, 5, 2, 1)));
    }
}

