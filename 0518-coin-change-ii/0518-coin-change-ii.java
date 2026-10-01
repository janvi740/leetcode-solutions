class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount+1];

        for(int amt=0; amt<=amount; amt++){
            if(amt % coins[0] == 0){
                dp[0][amt] = 1;
            }
            else{
                dp[0][amt] = 0;
            }
        }

        for(int index=1; index<n; index++){
            for(int amt=0; amt<=amount; amt++){

                int notPick = dp[index-1][amt];

                int pick = 0;

                if(coins[index] <= amt){
                    pick = dp[index][amt-coins[index]];
                }

                dp[index][amt] = pick + notPick;
            }
        }

        return dp[n-1][amount];
    }
}