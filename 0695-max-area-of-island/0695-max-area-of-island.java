class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){

                if(grid[i][j] == 1){
                    int currentArea = dfs(i, j, grid);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        return maxArea;
    }

    public int dfs(int i, int j, int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        if(i<0 || i>=rows || j<0 || j>=cols || grid[i][j]==0){
            return 0;
        }

        grid[i][j] = 0;

        int up = dfs(i-1, j, grid);
        int down = dfs(i+1, j, grid);
        int left = dfs(i, j-1, grid);
        int right = dfs(i, j+1, grid);

        return 1 + up + down + left + right;
    }
}