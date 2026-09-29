class Solution {

    private int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int maxLength = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                maxLength = Math.max(maxLength, dfs(i, j, matrix, dp));
            }
        }

        return maxLength;
    }

    public int dfs(int row, int col, int[][] matrix, int[][] dp){
        int m = matrix.length;
        int n = matrix[0].length;

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        int longest = 1;

        for(int[] direction : directions){

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(newRow>=0 && newRow<m && newCol>=0 && newCol<n && matrix[newRow][newCol] > matrix[row][col]){

                longest = Math.max(longest, 1 + dfs(newRow, newCol, matrix, dp));
            }
        }

        return dp[row][col] = longest;
    }
}