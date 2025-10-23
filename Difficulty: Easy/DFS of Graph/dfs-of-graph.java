class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size(); // Number of vertices
        boolean[] visited = new boolean[v];
        ArrayList<Integer> result = new ArrayList<>();

        dfsHelper(0, adj, visited, result); // Start DFS from node 0
        return result;
    }

    // Helper function for DFS traversal
    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj,
                           boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;
        result.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, result);
            }
        }
    }
}