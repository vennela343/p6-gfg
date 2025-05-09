#User function Template for python3

class Solution:
    
    #Function to find the largest number after k swaps.
    def findMaximumNum(self, s, k):
        self.max_num = s

        def helper(s_list, k, index):
            if k == 0 or index == len(s_list):
                return

            max_digit = max(s_list[index:])
            if s_list[index] != max_digit:
                for j in range(len(s_list) - 1, index, -1):
                    if s_list[j] == max_digit:
                        s_list[index], s_list[j] = s_list[j], s_list[index]
                        current = ''.join(s_list)
                        if current > self.max_num:
                            self.max_num = current
                        helper(s_list, k - 1, index + 1)
                        s_list[index], s_list[j] = s_list[j], s_list[index]  
            else:
                helper(s_list, k, index + 1)  

        helper(list(s), k, 0)
        return self.max_num


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == "__main__":
    for _ in range(int(input())):
        k = int(input())
        s = input()
        ob = Solution()
        print(ob.findMaximumNum(s, k))

        print("~")

# } Driver Code Ends