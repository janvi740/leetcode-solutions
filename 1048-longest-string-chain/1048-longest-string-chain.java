class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, (a,b) -> a.length() - b.length());

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 0;

        for(int i=0; i<n; i++){
            for(int prev=0; prev<i; prev++){

                if(isValid(words[prev], words[i]) && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }

    public boolean isValid(String shorter, String longer){
        if(longer.length() != shorter.length() + 1){
            return false;
        }

        int i = 0;
        int j = 0;

        while(i<shorter.length() && j<longer.length()){
            if(shorter.charAt(i) == longer.charAt(j)){
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        return i == shorter.length();
    }
}