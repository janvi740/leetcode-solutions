class Solution {
    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n+1];
        dp[n] = 0;

        for(int index=n-1; index>=0; index--){

            int min = Integer.MAX_VALUE;

            for(int end=index; end<n; end++){

                if(isPalindrome(index, end, s)){

                    int partitions = 1 + dp[end+1];

                    min = Math.min(min, partitions);
                }
            }

            dp[index] = min;
        }

        return dp[0] - 1;
    }

    public boolean isPalindrome(int left, int right, String s){

        while(left < right){

            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}