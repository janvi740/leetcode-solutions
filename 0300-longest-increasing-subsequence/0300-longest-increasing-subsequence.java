class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;
        
        for(int index=0; index<n; index++){
            for(int prev=0; prev<index; prev++){

                if(nums[prev] < nums[index]){
                    dp[index] = Math.max(dp[index], 1 + dp[prev]);
                }
            }
            max = Math.max(max, dp[index]);
        }

        return max;
    }
}