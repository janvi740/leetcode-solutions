class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }

        DisjointSet ds = new DisjointSet(n);

        for(int[] con : connections){
            int u = con[0];
            int v = con[1];

            ds.unionBySize(u, v);
        }

        int components = 0;

        for(int i=0; i<n; i++){
            if(ds.findParent(i)==i){
                components++;
            }
        }

        return components-1;
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