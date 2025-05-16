//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class DriverClass {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[][] = new int[k][n];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();
            }
            ArrayList<Integer> range = new Solution().findSmallestRange(arr);
            System.out.println(range.get(0) + " " + range.get(1));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {
    class Element implements Comparable<Element> {
        int value, row, index;

        Element(int value, int row, int index) {
            this.value = value;
            this.row = row;
            this.index = index;
        }

        public int compareTo(Element other) {
            return this.value - other.value;
        }
    }

    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;     
        int n = arr[0].length;   

        PriorityQueue<Element> minHeap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            minHeap.add(new Element(arr[i][0], i, 0));
            max = Math.max(max, arr[i][0]);
        }

        int start = 0, end = Integer.MAX_VALUE;

        while (true) {
            Element curr = minHeap.poll();
            int min = curr.value;

            // Update range if smaller
            if (max - min < end - start) {
                start = min;
                end = max;
            }

            if (curr.index + 1 < n) {
                int nextVal = arr[curr.row][curr.index + 1];
                minHeap.add(new Element(nextVal, curr.row, curr.index + 1));
                max = Math.max(max, nextVal);
            } else {
                break;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(start);
        result.add(end);
        return result;
    }
}
