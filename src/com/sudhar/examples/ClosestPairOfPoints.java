package com.sudhar.examples;

public class ClosestPairOfPoints {

    public static void main(String[] args) {
        int[][] a = {{2, 3}, {12, 30}, {40, 50}, {5, 1}, {12, 10}, {3, 4}};

        System.out.println(findClosestPair(a));
    }

    public static float findClosestPair(int[][] a) {
        if (a == null || a.length == 0) {
            return 0;
        }

        Point[] points = new Point[a.length];
        for (int i = 0; i < a.length; i++) {
            points[i] = new Point(a[i][0], a[i][1]);
        }

        float min = Integer.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                min = Math.min(min, distance(points[i], points[j]));
                System.out.println("Distance: " + distance(points[i], points[j]));
            }
        }
        return min;
    }

    public static float distance(Point p1, Point p2) {
        return (float)Math.sqrt(((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())) +
                ((p1.getY() - p2.getY()) * (p1.getY() - p2.getY())));
    }
}

