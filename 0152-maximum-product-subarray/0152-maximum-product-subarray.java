class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int prevMax = nums[0];
        int prevMin = nums[0];

        int ans = nums[0];

        for(int i=1; i<n; i++){

            int currMax = Math.max(nums[i], 
                        Math.max(nums[i]*prevMax, nums[i]*prevMin));

            int currMin = Math.min(nums[i], 
                        Math.min(nums[i]*prevMax, nums[i]*prevMin));
            
            ans = Math.max(ans, currMax);

            prevMax = currMax;
            prevMin = currMin;
        }

        return ans;
    }
}