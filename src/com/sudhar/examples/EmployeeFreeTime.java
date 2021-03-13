package com.sudhar.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Interval {

    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
}

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        int OPEN = 0, CLOSE = 1;

        List<int[]> events = new ArrayList();
        for (List<Interval> employee : avails) {
            for (Interval iv : employee) {
                events.add(new int[]{iv.start, OPEN});
                events.add(new int[]{iv.end, CLOSE});
            }
        }

        Collections.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<Interval> ans = new ArrayList();

        int prev = -1, bal = 0;
        for (int[] event : events) {
            // event[0] = time, event[1] = command
            if (bal == 0 && prev >= 0) {
                ans.add(new Interval(prev, event[0]));
            }
            bal += event[1] == OPEN ? 1 : -1;
            prev = event[0];
        }

        return ans;
    }
    class Solution1 {
        public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
            List<Interval> ans = new ArrayList();
            PriorityQueue<Job> pq = new PriorityQueue<Job>((a, b) ->
                                                                   avails.get(a.eid).get(a.index).start -
                                                                   avails.get(b.eid).get(b.index).start);
            int ei = 0, anchor = Integer.MAX_VALUE;

            for (List<Interval> employee: avails) {
                pq.offer(new Job(ei++, 0));
                anchor = Math.min(anchor, employee.get(0).start);
            }

            while (!pq.isEmpty()) {
                Job job = pq.poll();
                Interval iv = avails.get(job.eid).get(job.index);
                if (anchor < iv.start)
                    ans.add(new Interval(anchor, iv.start));
                anchor = Math.max(anchor, iv.end);
                if (++job.index < avails.get(job.eid).size())
                    pq.offer(job);
            }

            return ans;
        }
    }

    class Job {
        int eid, index;
        Job(int e, int i) {
            eid = e;
            index = i;
        }
    }

}
