#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends

#User function Template for python3
class Solution:
    def longestSubarray(self, arr, k):
        # Code Here
        temp = [1 if x > k else -1 for x in arr]

        prefix_sum = 0
        max_len = 0
        first_occurrence = {}

        for i in range(len(arr)):
            prefix_sum += temp[i]
            if prefix_sum > 0:
                max_len = i + 1
            if prefix_sum not in first_occurrence:
                first_occurrence[prefix_sum] = i
            if (prefix_sum - 1) in first_occurrence:
                j = first_occurrence[prefix_sum - 1]
                max_len = max(max_len, i - j)

        return max_len



#{ 
 # Driver Code Starts.

if __name__ == "__main__":
    t = int(input())
    while t > 0:
        
        arr = [int(x) for x in input().strip().split()]
        k = int(input())
        
        ob = Solution()
        print(ob.longestSubarray(arr, k))
        print("~")
        t -= 1
# } Driver Code Ends