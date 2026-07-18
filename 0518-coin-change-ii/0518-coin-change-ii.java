class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[] prev = new int[amount+1];
        
        for(int amt=0; amt<=amount; amt++){
            if(amt%coins[0] == 0){
                prev[amt] = 1;
            }
            else{
                prev[amt] = 0;
            }
        }

        for(int index=1; index<n; index++){

            int[] curr = new int[amount+1];

            for(int amt=0; amt<=amount; amt++){

                int notPick = prev[amt];

                int pick = 0;

                if(coins[index] <= amt){
                    pick = curr[amt-coins[index]];
                }

                curr[amt] = pick + notPick;
            }
            prev = curr;
        }
        return prev[amount];
    }
}