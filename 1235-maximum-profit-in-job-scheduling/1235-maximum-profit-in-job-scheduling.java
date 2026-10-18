class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];

        for(int i=0; i<jobs.length; i++){
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[jobs.length];
        Arrays.fill(dp, -1);

        return solve(0, jobs, dp);
    }

    public int solve(int index, int[][] jobs, int[] dp){
        int n = jobs.length;

        if(index >= n){
            return 0;
        }

        if(dp[index] != -1){
            return dp[index];
        }

        int nextIndex = binarySearch(jobs, jobs[index][1]);

        int skip = solve(index+1, jobs, dp);

        int take = jobs[index][2] + solve(nextIndex, jobs, dp);

        return dp[index] = Math.max(skip, take);
    }

    private int binarySearch(int[][] jobs, int target) {
        int low = 0;
        int high = jobs.length;

        while(low < high){
            
            int mid = low + (high - low) / 2;

            if(jobs[mid][0] >= target){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }
}