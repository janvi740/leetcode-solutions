class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DisjointSet ds = new DisjointSet(n+1);

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) == ds.findParent(v)){
                return edge;
            }

            ds.unionBySize(u, v);
        }

        return new int[0];
    }
}

class DisjointSet{
    int[] parent;
    int[] size;

    public DisjointSet(int n){
        parent = new int[n];
        size = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int findParent(int node){
        if(parent[node] == node){
            return node;
        }

        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    public void unionBySize(int u, int v){

        int parentU = findParent(u);
        int parentV = findParent(v);

        if(parentU == parentV){
            return;
        }

        if(size[parentU] < size[parentV]){
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        }
        else{
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        }
    }
}