class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];
        

        for(int j=0; j<n; j++){
            dp[0][j] = matrix[0][j];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<n; j++){

                int up = matrix[i][j] + dp[i-1][j];

                int dLeft = Integer.MAX_VALUE;
                if(j>0){
                    dLeft = matrix[i][j] + dp[i-1][j-1];
                }

                int dRight = Integer.MAX_VALUE;
                if(j<n-1){
                    dRight = matrix[i][j] + dp[i-1][j+1];
                }

                dp[i][j] = Math.min(up, Math.min(dLeft, dRight));
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int j=0; j<n; j++){
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }
}