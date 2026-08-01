class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];
        Arrays.fill(color, -1);

        for(int i=0; i<n; i++){
            if(color[i] == -1){
                if(!dfs(i, graph, color)){
                return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int[][] graph, int[] color){

        for(int nbr : graph[node]){
            if(color[nbr] == -1){
                color[nbr] = 1 - color[node];
                if(!dfs(nbr, graph, color)){
                    return false;
                }
            }
            else if(color[nbr] == color[node]){
                return false;
            }
        }

        return true;
    }
}