class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] ahead = new int[2];
         int[] ahead2 = new int[2];

        for(int index=n-1; index>=0; index--){
            int[] curr = new int[2];

            curr[1] = Math.max(-prices[index] + ahead[0] , ahead[1]);

            curr[0] = Math.max(prices[index] + ahead2[1], ahead[0]);

             
             ahead2 = ahead;
             ahead = curr;
        }

        return ahead[1];
    }
}