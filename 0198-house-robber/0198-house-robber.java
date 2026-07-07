class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int prev2 = 0;
        int prev1 = nums[0];

        for(int i=1; i<n; i++){
            int rob = nums[i] + prev2;
            int notRob = prev1;

            int curr = Math.max(rob, notRob);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}