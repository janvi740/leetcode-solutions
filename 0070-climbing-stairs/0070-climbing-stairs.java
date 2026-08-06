class Solution {
    public int climbStairs(int n) {

        int[] dp = new int[n+2];

        dp[n] = 1;
        dp[n+1] = 0;

        for(int index=n-1; index>=0; index--){

            int oneStep = dp[index+1];
            int twoStep = dp[index+2];

            dp[index] = oneStep + twoStep;
        }

        return dp[0];
    }
}