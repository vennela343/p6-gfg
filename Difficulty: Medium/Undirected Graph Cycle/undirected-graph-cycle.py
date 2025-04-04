
class Solution:
	def isCycle(self, V, edges):
        graph = {i: [] for i in range(V)}
        for u, v in edges:
            graph[u].append(v)
            graph[v].append(u)  
        def dfs(node, parent, visited):
            visited[node] = True
            for neighbor in graph[node]:
                if not visited[neighbor]:
                    if dfs(neighbor, node, visited):
                        return True
                elif neighbor != parent:
                    return True
            return False
        visited = [False] * V
        for i in range(V):
            if not visited[i]:
                if dfs(i, -1, visited):
                    return True  
        
   
        return False



#{ 
 # Driver Code Starts
import sys
#Position this line where user code will be pasted.


def main():
    tc = int(input())
    for _ in range(tc):
        V = int(input())
        E = int(input())
        edges = []
        for _ in range(E):
            u, v = map(int, input().split())
            edges.append((u, v))

        obj = Solution()
        ans = obj.isCycle(V, edges)
        print("true" if ans else "false")
        print("~")


if __name__ == "__main__":
    main()

# } Driver Code Ends