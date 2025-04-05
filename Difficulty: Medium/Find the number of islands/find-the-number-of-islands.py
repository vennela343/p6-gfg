#User function Template for python3

class Solution:
    def numIslands(self, grid):
        # code here
    
        if not grid or not grid[0]:
            return 0
        
        rows = len(grid)
        cols = len(grid[0])
       
        directions = [(-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1)]
        
        def dfs(r, c):
            if r < 0 or r >= rows or c < 0 or c >= cols or grid[r][c] == 'W':
                return
            
            grid[r][c] = 'W'
            
            for dr, dc in directions:
                dfs(r + dr, c + dc)
 
        island_count = 0
        
        for i in range(rows):
            for j in range(cols):
                if grid[i][j] == 'L':
                    dfs(i, j)  
                    island_count += 1  
        
        return island_count



#{ 
 # Driver Code Starts
# Driver code
if __name__ == "__main__":
    for _ in range(int(input())):
        n = int(input().strip())
        m = int(input().strip())
        grid = [input().strip().split() for _ in range(n)]

        obj = Solution()
        print(obj.numIslands(grid))
        print("~")

# } Driver Code Ends