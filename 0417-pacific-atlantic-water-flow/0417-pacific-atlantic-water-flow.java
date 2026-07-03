class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        List<List<Integer>> ans = new ArrayList<>();

        //Pacific Ocean
        for(int col=0; col<n; col++){
            dfs(0, col, heights, pacific);
        }

        for(int row=0; row<m; row++){
            dfs(row, 0, heights, pacific);
        }

        //Atlantic
        for(int col=0; col<n; col++){
            dfs(m-1, col, heights, atlantic);
        }

        for(int row=0; row<m; row++){
            dfs(row, n-1, heights, atlantic);
        }

        for(int row=0; row<m; row++){
            for(int col=0; col<n; col++){
                if(pacific[row][col] && atlantic[row][col]){
                    ans.add(Arrays.asList(row, col));
                }
            }
        }
        return ans;
    }

    public void dfs(int row, int col, int[][] heights, boolean[][] visited){
        int m = heights.length;
        int n = heights[0].length;

        visited[row][col] = true;

        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        for(int i=0; i<4; i++){
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                continue;
            }

            if(visited[newRow][newCol]){
                continue;
            }

            if(heights[newRow][newCol] < heights[row][col]){
                continue;
            }

            dfs(newRow, newCol, heights, visited);
        }
    }
}