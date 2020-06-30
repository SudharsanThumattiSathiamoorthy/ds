package com.sudhar.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public static void main(String[] args) {

        int[][] a ={ {2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};

        //System.out.println(findMeetingRooms(a));

        System.out.println(countMeetingRoom(a));
    }

//    private static int findMeetingRooms(int[][] intervals) {
//        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
//            return -1;
//        }
//
//        Arrays.sort(intervals, Comparator.comparing((int[] v) -> v[0]));
//
//        int count = 0;
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//
//        for (int[] v: intervals) {
//            if (queue.isEmpty()) {
//                count++;
//            } else {
//                if (v[0] >= queue.peek()) {
//                    queue.poll();
//                } else {
//                    count++;
//                }
//            }
//            queue.add(v[1]);
//        }
//        return count;
//
//    }

    private static int countMeetingRoom(int[][] meetings) {
        if (meetings == null || meetings.length == 0|| meetings[0].length == 0) {
            return 0;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] v) -> v[0]));

        for (int[] a: meetings) {
            queue.add(a);
        }

        Integer prev = null;
        int count = 0;

        for (int[] q: queue) {
            if (prev == null || prev < q[0]) {
                count++;
            }
            prev = q[1];
        }

        return count;
    }
}
