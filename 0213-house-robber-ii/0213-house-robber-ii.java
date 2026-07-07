class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1){
            return nums[0];
        }

        int excludeLast = robLinear(nums, 0, n-2);
        int excludeFirst = robLinear(nums, 1, n-1);

        return Math.max(excludeLast, excludeFirst);
    }

    public int robLinear(int[] nums, int start, int end){

        int prev2 = 0;
        int prev1 = nums[start];

        for(int i=start+1; i<=end; i++){

            int take = nums[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}