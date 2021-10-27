package lesson16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lesson16.Point.xComparator;
import static lesson16.Point.yComparator;

public class Main {

    public static void main(String[] args) {
        Point point1 = new Point(4, 3);
        Point point2 = new Point(1, 5);
        Point point3 = new Point(7, 3);
        Point point4 = new Point(3, 3);

        List<Point> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        //   Arrays.sort(new Point[] {point1, point2, point3, point4});

        Collections.sort(points);
        for (Point p : points) {
            System.out.println(p);
        }
        System.out.println();
        Collections.sort(points, xComparator);
        for (Point p : points) {
            System.out.println(p);
        }
        System.out.println();
        Collections.sort(points, yComparator);
        for (Point p : points) {
            System.out.println(p);
        }

    }
}
