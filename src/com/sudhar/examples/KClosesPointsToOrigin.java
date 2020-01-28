package com.sudhar.examples;

import java.util.Comparator;
import java.util.PriorityQueue;

class Point {
    private int x;
    private int y;
    private	double distance;

    Point(int x, int y) {
        this.x = x;
        this.y = y;

        this.distance = Math.sqrt((x*x) + (y*y));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getDistance() {
        return distance;
    }
}

public class KClosesPointsToOrigin {

    public int[][] kClosest(int[][] a, int K) {
        if (a == null || a.length == 0) {
            return null;
        }

        Comparator<Point> tempSort = Comparator.comparing(Point::getDistance);

        Comparator<Point> sort = (p1, p2) -> p2.getDistance() - p1.getDistance() == 0 ? 0 : (p2.getDistance() - p1.getDistance() > 0 ? -1 : 1);

        PriorityQueue<Point> queue = new PriorityQueue<>(sort);

        for (int i = 0; i < a.length; i++) {
            Point p = new Point(a[i][0], a[i][1]);
            queue.add(p);
        }

        int[][] result = new int[K][2];

        for (int i = 0; i < K; i++) {
            Point p = queue.poll();

            result[i][0] = p.getX();
            result[i][1] = p.getY();
        }

        return result;
    }

    public static void main(String[] args) {

    }

}
