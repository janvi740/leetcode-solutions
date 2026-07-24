class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[] prev = new boolean[m+1];
        
        // Empty string and empty pattern
        prev[0] = true;

        // Empty string against pattern prefix
        for(int j=1; j<=m; j++){
            prev[j] = prev[j-1] && p.charAt(j-1)=='*';
        }

        for(int i=1; i<=n; i++){

            boolean[] curr = new boolean[m+1];
            // Non-empty string cannot match empty pattern
            curr[0] = false;

            for(int j=1; j<=m; j++){

                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    curr[j] = prev[j-1];
                }
                else if(p.charAt(j-1) == '*'){
                    boolean emptyMatch = curr[j-1];
                    boolean charMatch = prev[j];

                    curr[j] = emptyMatch || charMatch;
                }
                else{
                    curr[j] = false;
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}