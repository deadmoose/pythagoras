//
// Pythagoras - a collection of geometry classes
// http://github.com/samskivert/pythagoras

package pythagoras.f;

import java.io.Serializable;

/**
 * Represents a point on a plane.
 */
public class Point implements IPoint, Serializable
{
    /** The x-coordinate of the point. */
    public float x;

    /** The y-coordinate of the point. */
    public float y;

    /**
     * Constructs a point at (0, 0).
     */
    public Point () {
        setLocation(0, 0);
    }

    /**
     * Constructs a point at the specified coordinates.
     */
    public Point (float x, float y) {
        setLocation(x, y);
    }

    /**
     * Constructs a point with coordinates equal to the supplied point.
     */
    public Point (IPoint p) {
        setLocation(p.getX(), p.getY());
    }

    /**
     * Sets the coordinates of this point to be equal to those of the supplied point.
     */
    public void setLocation (IPoint p) {
        setLocation(p.getX(), p.getY());
    }

    /**
     * Sets the coordinates of this point to the supplied values.
     */
    public void setLocation (float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * A synonym for {@link #setLocation}.
     */
    public void move (float x, float y) {
        setLocation(x, y);
    }

    /**
     * Translates this point by the specified offset.
     */
    public void translate (float dx, float dy) {
        x += dx;
        y += dy;
    }

    @Override // from interface IPoint
    public float getX () {
        return x;
    }

    @Override // from interface IPoint
    public float getY () {
        return y;
    }

    @Override // from interface IPoint
    public float distanceSq (float px, float py) {
        return Geometry.distanceSq(x, y, px, py);
    }

    @Override // from interface IPoint
    public float distanceSq (IPoint p) {
        return Geometry.distanceSq(x, y, p.getX(), p.getY());
    }

    @Override // from interface IPoint
    public float distance (float px, float py) {
        return Geometry.distance(x, y, px, py);
    }

    @Override // from interface IPoint
    public float distance (IPoint p) {
        return Geometry.distance(x, y, p.getX(), p.getY());
    }

    @Override // from interface IPoint
    public Point clone () {
        try {
            return (Point)super.clone();
        } catch (CloneNotSupportedException cnse) {
            throw new AssertionError(cnse);
        }
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Point) {
            Point p = (Point)obj;
            return x == p.x && y == p.y;
        }
        return false;
    }

    @Override
    public int hashCode () {
        return Float.floatToIntBits(x) ^ Float.floatToIntBits(y);
    }

    @Override
    public String toString () {
        return Geometry.pointToString(x, y);
    }
}
