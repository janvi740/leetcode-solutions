class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if(totalSum % 2 != 0){
            return false;
        }

        int target = totalSum / 2;

        boolean[][] dp = new boolean[n][target+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }

        for(int i=1; i<n; i++){
            for(int sum=1; sum<=target; sum++){

                boolean notPick = dp[i-1][sum];

                boolean pick = false;
                if(nums[i] <= sum){
                    pick = dp[i-1][sum - nums[i]];
                }

                dp[i][sum] = pick || notPick;
            }
        }

        return dp[n-1][target];
    }
}