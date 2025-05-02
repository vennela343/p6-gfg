#User function Template for python3
class Solution:

	def findMaximum(self, arr):
		# code here
        left = 0
        right = len(arr) - 1

        while left <= right:
            mid = (left + right) // 2

            # Check if mid is the bitonic point
            if mid > 0 and mid < len(arr) - 1:
                if arr[mid] > arr[mid - 1] and arr[mid] > arr[mid + 1]:
                    return arr[mid]
                elif arr[mid] > arr[mid - 1] and arr[mid] < arr[mid + 1]:
                    left = mid + 1
                else:
                    right = mid - 1
            elif mid == 0:
                return arr[0] if arr[0] > arr[1] else arr[1]
            elif mid == len(arr) - 1:
                return arr[-1] if arr[-1] > arr[-2] else arr[-2]



#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        ans = ob.findMaximum(arr)
        print(ans)
        tc -= 1
        print("~")

# } Driver Code Ends