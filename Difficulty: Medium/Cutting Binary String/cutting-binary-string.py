class Solution:
    def cuts(self, s):
        # code here
        n = len(s)

        powers_of_5 = set()
        power = 1
        while True:
            binary = bin(power)[2:]
            if len(binary) > n:
                break
            powers_of_5.add(binary)
            power *= 5

        dp = [float('inf')] * (n + 1)
        dp[0] = 0  

        for i in range(1, n + 1):
            
            for j in range(i - 1, -1, -1):
                if s[j] == '0':
                    continue  
                if s[j:i] in powers_of_5:
                    dp[i] = min(dp[i], dp[j] + 1)

        return dp[n] if dp[n] != float('inf') else -1
        