class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DisjointSet ds = new DisjointSet(n*n);

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){

                if(grid[row][col]==0){
                    continue;
                }

                int node = row * n + col;

                for(int i=0; i<4; i++){
                    int newRow = row + dRow[i];
                    int newCol = col + dCol[i];

                    if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1){
                        int adjNode = newRow * n + newCol;
                        ds.unionBySize(node, adjNode);
                    }
                }
            }
        }

        int maxIsland = 0;

        for(int row=0; row<n; row++){
            for(int col=0; col<n; col++){

                if(grid[row][col]==1){
                    continue;
                }

                HashSet<Integer> uniqueParents = new HashSet<>();

                for(int i=0; i<4; i++){
                    int newRow = row + dRow[i];
                    int newCol = col + dCol[i];

                    if(newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol]==1){
                        int adjNode = newRow * n + newCol;
                        int parent = ds.findParent(adjNode);
                        uniqueParents.add(parent);
                    }
                }

                int currentSize = 1;

                for(int parent : uniqueParents){
                    currentSize += ds.size[parent];
                }

                maxIsland = Math.max(maxIsland, currentSize);
            }
        }

        for(int cell=0; cell<n*n; cell++){
            int parent = ds.findParent(cell);
            maxIsland = Math.max(maxIsland, ds.size[parent]);
        }

        return maxIsland;
    }
}

class DisjointSet {
    int[] parent;
    int[] size;

    DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        parent[node] = findParent(parent[node]);
        return parent[node];
    }

    void unionBySize(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);

        if (parentU == parentV) {
            return;
        }

        if (size[parentU] < size[parentV]) {
            parent[parentU] = parentV;
            size[parentV] += size[parentU];
        } else {
            parent[parentV] = parentU;
            size[parentU] += size[parentV];
        }
    }
}