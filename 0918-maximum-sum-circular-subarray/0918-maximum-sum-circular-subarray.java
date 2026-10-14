class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int currentSum1 = nums[0];
        int currentSum2 = nums[0];
        int max = nums[0];
        int min = nums[0];

        for(int i=1; i<nums.length; i++){

            totalSum += nums[i];

            currentSum1 = Math.max(nums[i], currentSum1 + nums[i]);
            max = Math.max(max, currentSum1);

            currentSum2 = Math.min(nums[i], currentSum2 + nums[i]);
            min = Math.min(min, currentSum2);

        }

        if(max < 0){
            return max;
        }

        return Math.max(max, totalSum - min);
    }
}