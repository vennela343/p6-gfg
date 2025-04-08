class Solution:
    def isBridge(self, V, edges, c, d):
        # code here 
        from collections import defaultdict
        graph = defaultdict(list)
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)
     
        disc = [-1] * V  
        low = [-1] * V   
        parent = [-1] * V
        time = [0]  
        
        bridges = set()

        def dfs(u):
            disc[u] = low[u] = time[0]
            time[0] += 1
         
            for v in graph[u]:
                if disc[v] == -1:  
                    parent[v] = u
                    dfs(v)
                    
                    low[u] = min(low[u], low[v])
                    
                    if low[v] > disc[u]:
                        bridges.add((u, v))
                elif v != parent[u]:  
                    low[u] = min(low[u], disc[v])

        for i in range(V):
            if disc[i] == -1:
                dfs(i)

        return (c, d) in bridges or (d, c) in bridges




#{ 
 # Driver Code Starts
import sys

sys.setrecursionlimit(10**7)
if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        V = int(input())
        E = int(input())
        adj = [[] for _ in range(V)]
        edges = []

        for _ in range(E):
            u, v = map(int, input().split())
            adj[u].append(v)
            adj[v].append(u)
            edges.append([u, v])

        c = int(input())
        d = int(input())

        obj = Solution()
        l = obj.isBridge(V, edges, c, d)

        if l:
            print("true")
        else:
            print("false")

        print("~")

# } Driver Code Ends