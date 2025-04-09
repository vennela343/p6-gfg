class Solution:
    def articulationPoints(self, V, edges):
        # code here
        adj = {i: [] for i in range(V)}
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        disc = [-1] * V 
        low = [-1] * V  
        parent = [-1] * V  
        ap = [False] * V
        time = [0]  
        def dfs(u):
            disc[u] = low[u] = time[0]
            time[0] += 1
            children = 0
            
            for v in adj[u]:
                if disc[v] == -1:  
                    parent[v] = u
                    children += 1
                    dfs(v)
                    low[u] = min(low[u], low[v])
                    if parent[u] == -1 and children > 1:
                        ap[u] = True  
                    if parent[u] != -1 and low[v] >= disc[u]:
                        ap[u] = True  
                elif v != parent[u]: 
                    low[u] = min(low[u], disc[v])
        for i in range(V):
            if disc[i] == -1:
                dfs(i)
        result = [i for i in range(V) if ap[i]]
        if not result:
            return [-1]
        
        return sorted(result)




#{ 
 # Driver Code Starts
import sys

sys.setrecursionlimit(int(1e7))


def main():
    tc = int(input())
    for _ in range(tc):
        V = int(input())
        E = int(input())
        edges = []
        for _ in range(E):
            u, v = map(int, input().split())
            edges.append([u, v])
        obj = Solution()
        ans = obj.articulationPoints(V, edges)
        ans.sort()
        print(" ".join(map(str, ans)))
        print("~")


if __name__ == "__main__":
    main()
# } Driver Code Ends