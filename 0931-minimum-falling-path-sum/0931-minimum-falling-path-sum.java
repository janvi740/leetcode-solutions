class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int j=0; j<n; j++){
            dp[n-1][j] = matrix[n-1][j];
        }
        
        for(int i=n-2; i>=0; i--){
            for(int j=0; j<n; j++){

                int down = dp[i+1][j];

                int leftD = Integer.MAX_VALUE;
                if(j-1 >= 0){
                    leftD = dp[i+1][j-1];
                }

                int rightD = Integer.MAX_VALUE;
                if(j+1 < n){
                    rightD = dp[i+1][j+1];
                }

                dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftD, rightD));
            }
        }

        int ans = Integer.MAX_VALUE;

        for(int j=0; j<n; j++){
            ans = Math.min(ans, dp[0][j]);
        }
        return ans;
    }
}