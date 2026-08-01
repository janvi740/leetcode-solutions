class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DisjointSet ds = new DisjointSet(n);

        for(int i=0; i<n; i++){
            for(int j=0;  j<n; j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }

        int provinces = 0;

        for(int i=0; i<n; i++){
            if(ds.findParent(i) == i){
                provinces++;
            }
        }

        return provinces;
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