class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[] prev = new int[amount+1];

        for(int amt=0; amt<=amount; amt++){
            if(amt % coins[0] == 0){
                prev[amt] = amt/coins[0];
            }
            else{
                prev[amt] = 1_000_000_000;
            }
        }

        for(int index=1; index<n; index++){

            int[] curr = new int[amount+1];

            for(int amt=0; amt<=amount; amt++){

                int notPick = prev[amt];

                int pick = 1_000_000_000;

                if(coins[index] <= amt){
                    pick = 1 + curr[amt-coins[index]];
                }

                curr[amt] = Math.min(pick, notPick);
            }

            prev = curr;
        }

        int ans = prev[amount];
        return ans >= 1_000_000_000 ? -1 : ans;
    }
}