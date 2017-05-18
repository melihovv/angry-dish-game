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
            Math.CollisionPointPair pair = Math.
                    getCollisionPointsBetweenLineAndEllipse(0, 1, 0, 0, 0, 1, 1);
            assertEquals(pair.x1, -1.0, 0.001);
            assertEquals(pair.y1, 0.0, 0.001);
            assertEquals(pair.x2, 1.0, 0.001);
            assertEquals(pair.y2, 0.0, 0.001);
        }
        {
            Math.CollisionPointPair pair = Math
                    .getCollisionPointsBetweenLineAndEllipse(1, 0, 0, 0, 0, 2, 2);
            assertEquals(pair.x1, 0.0, 0.001);
            assertEquals(pair.y1, 2.0, 0.001);
            assertEquals(pair.x2, 0.0, 0.001);
            assertEquals(pair.y2, -2.0, 0.001);
        }
        {
            Math.CollisionPointPair pair = Math.
                    getCollisionPointsBetweenLineAndEllipse(0, 1, 0, 0, 0, 2, 1);
            assertEquals(pair.x1, -2.0, 0.001);
            assertEquals(pair.y1, 0.0, 0.001);
            assertEquals(pair.x2, 2.0, 0.001);
            assertEquals(pair.y2, 0.0, 0.001);
        }
        {
            Math.CollisionPointPair pair = Math.
                    getCollisionPointsBetweenLineAndEllipse(1, 0, 0, 0, 0, 1, 2);
            assertEquals(pair.x1, 0.0, 0.001);
            assertEquals(pair.y1, 2.0, 0.001);
            assertEquals(pair.x2, 0.0, 0.001);
            assertEquals(pair.y2, -2.0, 0.001);
        }
        {
            Math.CollisionPointPair pair = Math.
                    getCollisionPointsBetweenLineAndEllipse(0, 1, 3, 2,
                            3, 2, 1);
            assertEquals(pair.x1, 0.0, 0.001);
            assertEquals(pair.y1, 3.0, 0.001);
            assertEquals(pair.x2, 4.0, 0.001);
            assertEquals(pair.y2, 3.0, 0.001);
        }
        {
            Math.CollisionPointPair pair = Math.
                    getCollisionPointsBetweenLineAndEllipse(1, 0, 2, 2, 3, 1, 2);
            assertEquals(pair.x1, 2.0, 0.001);
            assertEquals(pair.y1, 5.0, 0.001);
            assertEquals(pair.x2, 2.0, 0.001);
            assertEquals(pair.y2, 1.0, 0.001);
        }
        {
            Math.CollisionPointPair pair = Math
                    .getCollisionPointsBetweenLineAndEllipse(1, -1, 0, 2, 2, 2, 2);
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

