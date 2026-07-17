class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }
        
        if((totalSum + target) % 2 != 0){
            return 0;
        }
        
        int subsetTarget = (totalSum + target) / 2;
        
        int[][] dp = new int[n][subsetTarget+1];

        if(nums[0]==0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
        }

        if(nums[0]!=0 && nums[0] <= subsetTarget){
            dp[0][nums[0]] = 1;
        }

        for(int index=1; index<n; index++){
            for(int sum=0; sum<=subsetTarget; sum++){

                int notPick = dp[index-1][sum];

                int pick = 0;

                if(nums[index] <= sum){
                    pick = dp[index-1][sum-nums[index]];
                }

                dp[index][sum] = pick + notPick;
            }
        }

        return dp[n-1][subsetTarget];
    }
}