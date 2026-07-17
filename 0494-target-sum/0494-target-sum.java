class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum) {
            return 0;
        }
        
        if((totalSum + target) % 2 != 0){
            return 0;
        }
        
        int subsetTarget = (totalSum + target) / 2;
        
        int[] prev = new int[subsetTarget+1];

        if(nums[0]==0){
            prev[0] = 2;
        }
        else{
            prev[0] = 1;
        }

        if(nums[0]!=0 && nums[0] <= subsetTarget){
            prev[nums[0]] = 1;
        }

        for(int index=1; index<n; index++){

            int[] curr = new int[subsetTarget+1];
            curr[0] = 0;

            for(int sum=0; sum<=subsetTarget; sum++){

                int notPick = prev[sum];

                int pick = 0;

                if(nums[index] <= sum){
                    pick = prev[sum-nums[index]];
                }

                curr[sum] = pick + notPick;
            }

            prev = curr;
        }

        return prev[subsetTarget];
    }
}