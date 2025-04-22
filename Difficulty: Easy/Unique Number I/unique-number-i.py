class Solution:
    def findUnique(self, arr):
        # code here 
        result = 0
        for num in arr:
            result ^= num  # XOR each number
        return result



#{ 
 # Driver Code Starts
# Initial Template for Python 3

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        ob = Solution()
        ans = ob.findUnique(arr)
        print(ans)
        print("~")
# } Driver Code Ends