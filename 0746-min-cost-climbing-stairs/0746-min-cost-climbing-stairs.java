class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int[] dp = new int[n];

        if(n==1){
            return cost[0];
        }

        if(n==2){
            return Math.min(cost[0], cost[1]);
        }
        
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int index=2; index<n; index++){

            int oneStep = cost[index] + dp[index-1];
            int twoStep = cost[index] + dp[index-2];

            dp[index] = Math.min(oneStep, twoStep);
        }

        return Math.min(dp[n-2], dp[n-1]);
    }
}