class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }

        if(n == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int index=2; index<n; index++){
            int rob = nums[index] + dp[index-2];
            int notRob = dp[index-1];

            dp[index] = Math.max(rob, notRob);
        }

        return dp[n-1];
    }
}