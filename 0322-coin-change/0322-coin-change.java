class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int amt=0; amt<=amount; amt++){
            if(amt % coins[0] == 0){
                dp[0][amt] = amt / coins[0];
            }
            else{
                dp[0][amt] = (int) 1e9;
            }
        }

        for(int index=1; index<n; index++){
            for(int amt=0; amt<=amount; amt++){

                int notPick = dp[index-1][amt];

                int pick = (int) 1e9;

                if(coins[index] <= amt){
                    pick = 1 + dp[index][amt-coins[index]];
                }

                dp[index][amt] = Math.min(pick, notPick);
            }
        }

        int ans = dp[n-1][amount];

        return ans >= (int) 1e9 ? -1 : ans;
    }
}