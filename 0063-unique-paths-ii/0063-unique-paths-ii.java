class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        dp[m-1][n-1] = 1;

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){

                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else if(i == m-1 && j == n-1){
                    dp[i][j] = 1;
                }
                else{
                    int down = 0;
                    int right = 0;

                    if(i+1 < m){
                        down = dp[i+1][j];
                    }
                    if(j+1 < n){
                        right = dp[i][j+1];
                    }

                    dp[i][j] = down + right;
                }
            }
        }

        return dp[0][0];
    }
}