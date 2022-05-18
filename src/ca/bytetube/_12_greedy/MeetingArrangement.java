package ca.bytetube._12_greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingArrangement {


    private static class Meeting{
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int arrangeMeeting(Meeting[] meetings, int current){
        Arrays.sort(meetings, new Comparator<Meeting>() {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                return m1.end - m2.end;
            }
        });

        int count = 0;

        for (int i = 0; i < meetings.length; i++) {
            if (current  <= meetings[i].start) {
                count++;
                current = meetings[i].end;
            }
        }

        return count;

    }
}
