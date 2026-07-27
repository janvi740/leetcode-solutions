class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[] ahead = new int[n+1];
        
        for(int index=n-1; index>=0; index--){
            int[] curr = new int[n+1];

            for(int prev=index-1; prev>=-1; prev--){

                int notTake = ahead[prev+1];

                int take = 0;

                if(prev == -1 || nums[index] > nums[prev]){
                    take = 1 + ahead[index+1];
                }

                curr[prev + 1] =
                    Math.max(take, notTake);
            }

            ahead = curr;
        }

        return ahead[0];
    }
}