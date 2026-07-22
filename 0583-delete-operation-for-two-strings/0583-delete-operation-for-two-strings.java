class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int lcs = solve(word1, word2);

        return (m+n) - 2*lcs;
    }

    public int solve(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m+1];

        for(int i=1; i<=n; i++){
            int[] curr = new int[m+1];

            for(int j=1; j<=m; j++){

                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = 1 + prev[j-1];
                }
                else{
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}