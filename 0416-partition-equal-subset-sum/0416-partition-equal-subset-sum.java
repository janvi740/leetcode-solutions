class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        if(totalSum%2 != 0){
            return false;
        }

        int n = nums.length;

        int target = totalSum / 2;

        boolean[] prev = new boolean[target+1];

        prev[0] = true;

        if(nums[0] <= target){
            prev[nums[0]] = true;
        }

        for(int index=1; index<n; index++){

            boolean[] curr = new boolean[target+1];

            for(int ctarget=1; ctarget<=target; ctarget++){

                boolean notPick = prev[ctarget];
                boolean pick = false;

                if(nums[index] <= ctarget){
                    pick = prev[ctarget-nums[index]];
                }

                curr[ctarget] = pick || notPick;
            }

            prev = curr;
        }

        return prev[target];
    }
}