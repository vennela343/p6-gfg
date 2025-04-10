#User function Template for python3
class Solution:
    def minCost(self, houses):
      # code here
        import heapq
        n = len(houses)
        visited = [False] * n
        minHeap = [(0, 0)]  
        totalCost = 0
        housesConnected = 0

        while housesConnected < n:
            cost, u = heapq.heappop(minHeap)
            if visited[u]:
                continue
            visited[u] = True
            totalCost += cost
            housesConnected += 1

            for v in range(n):
                if not visited[v]:
                    dist = abs(houses[u][0] - houses[v][0]) + abs(houses[u][1] - houses[v][1])
                    heapq.heappush(minHeap, (dist, v))

        return totalCost

      


#{ 
 # Driver Code Starts
#Initial Template for Python 3
#Position this line where user code will be pasted.

if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        n = int(input())
        edges = []

        for _ in range(n):
            temp = list(map(int, input().split()))
            edges.append(temp)

        obj = Solution()
        print(obj.minCost(edges))
        print("~")
# } Driver Code Ends