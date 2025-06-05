class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        Integer[] memo = new Integer[V];
        return dfs(graph, src, dest, memo);
    }

    private int dfs(List<List<Integer>> graph, int current, int dest, Integer[] memo) {
        if (current == dest) return 1;
        if (memo[current] != null) return memo[current];

        int totalPaths = 0;
        for (int neighbor : graph.get(current)) {
            totalPaths += dfs(graph, neighbor, dest, memo);
        }

        memo[current] = totalPaths;
        return totalPaths;
    }
}

        
   