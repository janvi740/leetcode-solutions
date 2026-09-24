class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        int n = s.length();

        boolean[] dp = new boolean[n+1];

        dp[n] = true;

        for(int index=n-1; index>=0; index--){
            for(int end=index; end<n; end++){

                String word = s.substring(index, end+1);

                if(words.contains(word)){
                    if(dp[end+1]){
                        dp[index] = true;
                        break;
                    }
                }
            }
        }

        return dp[0];
    }
}