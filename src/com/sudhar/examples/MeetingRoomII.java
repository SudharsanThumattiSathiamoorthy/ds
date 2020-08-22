package com.sudhar.examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public static void main(String[] args) {

        int[][] a ={ {2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};

        System.out.println(findMeetingRooms(a));

        // System.out.println(countMeetingRoom(a));
    }

    private static int findMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return -1;
        }

        Arrays.sort(intervals, Comparator.comparing((int[] v) -> v[0]));

        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int[] v: intervals) {
            if (queue.isEmpty()) {
                count++;
            } else {
                if (v[0] >= queue.peek()) {
                    queue.poll();
                } else {
                    count++;
                }
            }
            queue.add(v[1]);
        }
        return count;

    }

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

    class Solution {
        public int minMeetingRooms(int[][] intervals) {

            // Check for the base case. If there are no intervals, return 0
            if (intervals.length == 0) {
                return 0;
            }

            // Min heap
            PriorityQueue<Integer> allocator =
                    new PriorityQueue<Integer>(
                            intervals.length,
                            new Comparator<Integer>() {
                                public int compare(Integer a, Integer b) {
                                    return a - b;
                                }
                            });

            // Sort the intervals by start time
            Arrays.sort(
                    intervals,
                    new Comparator<int[]>() {
                        public int compare(final int[] a, final int[] b) {
                            return a[0] - b[0];
                        }
                    });

            // Add the first meeting
            allocator.add(intervals[0][1]);

            // Iterate over remaining intervals
            for (int i = 1; i < intervals.length; i++) {

                // If the room due to free up the earliest is free, assign that room to this meeting.
                if (intervals[i][0] >= allocator.peek()) {
                    allocator.poll();
                }

                // If a new room is to be assigned, then also we add to the heap,
                // If an old room is allocated, then also we have to add to the heap with updated end time.
                allocator.add(intervals[i][1]);
            }

            // The size of the heap tells us the minimum rooms required for all the meetings.
            return allocator.size();
        }
    }
}
