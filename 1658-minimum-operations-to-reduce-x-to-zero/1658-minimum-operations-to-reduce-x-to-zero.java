class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if (totalSum < x) {
            return -1;
        }

        if (totalSum == x) {
            return n;
        }

        int target = totalSum - x;

        int sum = 0;
        int left = 0;
        int winLength = -1;

        for(int right=0; right<n; right++){

            sum += nums[right];

            while(sum > target){
                sum -= nums[left];
                left++;
            }

            if(sum == target){
                winLength = Math.max(winLength, right - left + 1);
            }
        }

        return winLength == -1 ? -1 : n - winLength;
    }
}