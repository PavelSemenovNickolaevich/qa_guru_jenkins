package lesson16;

import java.util.Comparator;
import java.util.Objects;

public class Point implements Comparable<Point> {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Point anotherPoint) {
        return this.x - anotherPoint.x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static Comparator<Point> xComparator = new Comparator<Point>() {
        @Override
        public int compare(Point x1, Point x2) {
            return x1.x - x2.x;
        }
    };

    public static Comparator<Point> yComparator = new Comparator<Point>() {
        @Override
        public int compare(Point y1, Point y2) {
            return y1.y - y2.y;
        }
    };


}
