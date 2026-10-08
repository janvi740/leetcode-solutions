class Solution {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        //find first island using dfs
        boolean found = false;

        for(int i=0; i<n && !found; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j, visited, queue);
                    found = true;
                    break;
                }
            }
        }

        //Multi source bfs
        int flips = 0;

        while(!queue.isEmpty()){

            int size = queue.size();

            for(int i=0; i<size; i++){

                int[] cell = queue.poll();

                int row = cell[0];
                int col = cell[1];

                for(int[] dir : directions){

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow<0 || newRow>=n || newCol<0 || newCol>=n ||
                    visited[newRow][newCol]){
                        continue;
                    }

                    if(grid[newRow][newCol] == 1){
                        return flips;
                    }

                    visited[newRow][newCol] = true;
                    queue.offer(new int[] {newRow, newCol});
                }
            }

            flips++;
        }

        return -1;
    }

    public void dfs(int[][] grid, int row, int col, boolean[][] visited, Queue<int[]> queue){

        int n = grid.length;

        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
            return;
        }

        visited[row][col] = true;
        queue.offer(new int[]{row, col});

        for (int[] dir : directions) {
            dfs(grid, row + dir[0], col + dir[1], visited, queue);
        }
    }
}