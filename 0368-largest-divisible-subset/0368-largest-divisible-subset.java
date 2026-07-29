class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        int max = 1;
        int lastIndex = 0;

        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){

                if(nums[i] % nums[prev] == 0 && 1 + dp[prev] > dp[i]){
                    dp[i] = 1 + dp[prev];
                    parent[i] = prev;
                }
            }

            if(dp[i] > max){
                max = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(parent[lastIndex] != lastIndex){
            ans.add(nums[lastIndex]);
            lastIndex = parent[lastIndex];
        }

        ans.add(nums[lastIndex]);

        Collections.reverse(ans);

        return ans;
    }
}