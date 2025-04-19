#User function Template for python3

class Solution:
    def maxXor(self, arr):
        #code here
         root = TrieNode()
         max_xor = 0

         for num in arr:
            node = root
            xor_node = root
            curr_xor = 0

            for i in range(31, -1, -1):  # 32-bit integers
                bit = (num >> i) & 1
                toggled = 1 - bit

                # Insert the bit in the trie
                if bit not in node.children:
                    node.children[bit] = TrieNode()
                node = node.children[bit]

                # Search for the opposite bit to maximize XOR
                if toggled in xor_node.children:
                    curr_xor = (curr_xor << 1) | 1
                    xor_node = xor_node.children[toggled]
                else:
                    curr_xor = (curr_xor << 1)
                    xor_node = xor_node.children.get(bit, xor_node)

            max_xor = max(max_xor, curr_xor)

         return max_xor
class TrieNode:
    def __init__(self):
        self.children = {}
        


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        n = int(input())
        arr = list(map(int, input().split()))
        ob = Solution()
        print(ob.maxXor(arr))
        print("~")

# } Driver Code Ends