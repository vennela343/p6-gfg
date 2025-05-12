//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        while (t-- > 0) {
            int n = sc.nextInt(); // Number of rooms
            int m = sc.nextInt(); // Number of meetings
            int[][] meetings = new int[m][2];
            for (int i = 0; i < m; i++) {
                meetings[i][0] = sc.nextInt(); // Start time
                meetings[i][1] = sc.nextInt(); // End time
            }
            Solution ob = new Solution();
            System.out.println(ob.mostBooked(n, meetings));
            System.out.println("~");
        }
        sc.close();
    }
}


// } Driver Code Ends

// User function Template for Java
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        // code here
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.offer(i);
        }
        PriorityQueue<long[]> ongoingMeetings = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });

        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while (!ongoingMeetings.isEmpty() && ongoingMeetings.peek()[0] <= start) {
                int room = (int) ongoingMeetings.poll()[1];
                availableRooms.offer(room);
            }

            int roomToUse;

            if (!availableRooms.isEmpty()) {
                roomToUse = availableRooms.poll();
                ongoingMeetings.offer(new long[]{end, roomToUse});
            } else {
                long[] earliest = ongoingMeetings.poll();
                long newEndTime = earliest[0] + (end - start);
                roomToUse = (int) earliest[1];
                ongoingMeetings.offer(new long[]{newEndTime, roomToUse});
            }

            count[roomToUse]++;
        }
        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }

        return maxRoom;
    }
}

   

//{ Driver Code Starts.
// } Driver Code Ends