// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {
        // your code here
        int n = s.length();
        int[] mp = new int[26];  
        int[] dp = new int[26];  
        Arrays.fill(dp, -1);

        int j = 0;
        int ans = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            mp[ch - 'a']++;
            dp[ch - 'a'] = i;

            if (mp[ch - 'a'] == 1) {
                count++;  
            }

            while (j < i && count > k) {
                char leftChar = s.charAt(j);
                mp[leftChar - 'a']--;
                if (mp[leftChar - 'a'] == 0) {
                    count--;
                }
                j++;
            }

            if (count < k) {
                continue;
            }

            int l_limit = Integer.MAX_VALUE;
            for (int l = 0; l < 26; l++) {
                if (dp[l] >= j) {
                    l_limit = Math.min(l_limit, dp[l]);
                }
            }

            ans += (l_limit - j + 1);
        }

        return ans;
    }
}

  