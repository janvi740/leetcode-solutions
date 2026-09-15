class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int[] maxProduct = new int[n];
        int[] minProduct = new int[n];

        maxProduct[0] = nums[0];
        minProduct[0] = nums[0];

        int ans = nums[0];

        for(int i=1; i<n; i++){

            maxProduct[i] = Math.max(nums[i], 
                        Math.max(nums[i]*maxProduct[i-1], nums[i]*minProduct[i-1]));

            minProduct[i] = Math.min(nums[i], 
                        Math.min(nums[i]*maxProduct[i-1], nums[i]*minProduct[i-1]));
            
            ans = Math.max(ans, maxProduct[i]);
        }

        return ans;
    }
}