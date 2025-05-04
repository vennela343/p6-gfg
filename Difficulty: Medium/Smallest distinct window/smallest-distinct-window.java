//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String str = br.readLine();

            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findSubString(String str) {
        // code here
        int n = str.length();
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }
        int required = uniqueChars.size();

        // Frequency map for characters in current window
        int[] windowFreq = new int[256];

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int formed = 0;
        boolean[] visited = new boolean[256];

        while (right < n) {
            char rightChar = str.charAt(right);
            windowFreq[rightChar]++;
            if (!visited[rightChar]) {
                visited[rightChar] = true;
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }

                char leftChar = str.charAt(left);
                windowFreq[leftChar]--;
                if (windowFreq[leftChar] == 0) {
                    visited[leftChar] = false;
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen;
    }
}

   