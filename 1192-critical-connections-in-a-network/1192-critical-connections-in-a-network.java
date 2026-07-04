class Solution {
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge : connections){
            int u =edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, adj, visited, tin, low, bridges);

        return bridges;
    }

    public void dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited, int[] tin, int[] low, List<List<Integer>> bridges){

        visited[node] = true;
        tin[node] = timer;
        low[node] = timer;
        timer++;

        for(int neighbour : adj.get(node)){

            if(neighbour == parent){
                continue;
            }

            if(!visited[neighbour]){
                dfs(neighbour, node, adj, visited, tin, low, bridges);

                low[node] = Math.min(low[node], low[neighbour]);

                if(low[neighbour] > tin[node]){
                    bridges.add(Arrays.asList(node, neighbour));
                }
            }
            else{
                low[node] = Math.min(low[node], tin[neighbour]);
            }
        }
    }
}