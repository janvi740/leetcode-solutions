class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        int prev1 = cost[1];
        int prev2 = cost[0];

        for(int index=2; index<n; index++){
            int oneStep = cost[index] + prev1;
            int twoStep = cost[index] + prev2;

            int curr = Math.min(oneStep, twoStep);

            prev2 = prev1;
            prev1 = curr;
        }

        return Math.min(prev1, prev2);
    }
}