class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] count = new int[n];
        Arrays.fill(count, 1);

        int max = 1;

        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){

                if(nums[prev] < nums[i]){
                    if(dp[prev]+1 > dp[i]){
                        dp[i] = dp[prev] + 1;
                        count[i] = count[prev];
                    } 
                    else if(dp[prev]+1 == dp[i]){
                        count[i] += count[prev];
                    }
                }
            }

            max = Math.max(dp[i], max);
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            if(dp[i] == max){
                ans += count[i];
            }
        }

        return ans;
    }
}