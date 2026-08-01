class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] allCuts = new int[m+2];

        allCuts[0] = 0;
        allCuts[m+1] = n;

        for(int i=0; i<m; i++){
            allCuts[i+1] = cuts[i];
        }

        Arrays.sort(allCuts);

        int[][] dp = new int[m+2][m+2];

        for(int i=m; i>=1; i--){
            for(int j=i; j<=m; j++){
                
                int min = Integer.MAX_VALUE;

                for(int k=i; k<=j; k++){

                    int currentCost = allCuts[j+1] - allCuts[i-1];
                    int leftCost = dp[i][k-1];
                    int rightCost = dp[k+1][j];

                    int totalCost = currentCost + leftCost + rightCost;

                    min = Math.min(min, totalCost);
                }

                dp[i][j] = min;
            }
        }

        return dp[1][m];
    }
}