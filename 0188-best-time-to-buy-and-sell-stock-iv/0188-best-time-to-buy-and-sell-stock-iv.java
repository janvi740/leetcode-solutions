class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] ahead = new int[2][k+1];

        for(int index=n-1; index>=0; index--){
            int[][] curr = new int[2][k+1];

            for(int txns=k-1; txns>=0; txns--){

                curr[1][txns] = Math.max(-prices[index] + ahead[0][txns], ahead[1][txns]);

                curr[0][txns] = Math.max(prices[index] + ahead[1][txns+1], ahead[0][txns]);
            }

            ahead = curr;
        }

        return ahead[1][0];
    }
}