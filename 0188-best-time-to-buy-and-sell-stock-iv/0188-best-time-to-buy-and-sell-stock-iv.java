class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n+1][2][k+1];

        for(int index=n-1; index>=0; index--){
            for(int txns=k-1; txns>=0; txns--){

                dp[index][1][txns] = Math.max(-prices[index] + dp[index+1][0][txns], dp[index+1][1][txns]);

                dp[index][0][txns] = Math.max(prices[index] + dp[index+1][1][txns+1], dp[index+1][0][txns]);
            }
        }

        return dp[0][1][0];
    }
}