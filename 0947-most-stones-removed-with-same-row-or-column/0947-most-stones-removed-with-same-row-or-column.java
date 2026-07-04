class Solution {
    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for(int[] stone : stones){
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 2);

        HashSet<Integer> nodes = new HashSet<>();

        for(int[] stone : stones){
            int row = stone[0];
            int col = stone[1] + maxRow + 1;

            ds.unionBySize(row, col);

            nodes.add(row);
            nodes.add(col);
        }

        int components = 0;

        for(int node : nodes){
            if(ds.findParent(node)==node){
                components++;
            }
        }

        return stones.length - components;
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