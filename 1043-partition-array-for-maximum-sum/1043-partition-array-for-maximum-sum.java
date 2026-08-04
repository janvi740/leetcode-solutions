class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n+1];
        dp[n] = 0;

        for(int index=n-1; index>=0; index--){
            int maxAns = 0;
            int currentMax = 0;
            int partitionLength = 0;

            for(int end=index; end<n && end<index+k; end++){
                partitionLength++;

                currentMax = Math.max(currentMax, arr[end]);
            
                int currentSum = currentMax * partitionLength;
                int remainingSum = dp[end+1];
                int totalSum = currentSum + remainingSum;

                maxAns = Math.max(maxAns, totalSum);
            }

            dp[index] = maxAns;
        }

        return dp[0];
    }
}