class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] ahead = new int[5];

        for(int index=n-1; index>=0; index--){

            int[] curr = new int[5];

            for(int txns=3; txns>=0; txns--){

                if(txns % 2 == 0){
                    curr[txns] = Math.max(-prices[index] + ahead[txns+1], ahead[txns]);
                }
                else{
                    curr[txns] = Math.max(prices[index] + ahead[txns+1], ahead[txns]);
                }
            }

            ahead = curr;
        }

        return ahead[0];
    }
}