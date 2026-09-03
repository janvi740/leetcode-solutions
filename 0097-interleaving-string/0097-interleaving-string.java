class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();

        if(n + m != s3.length()){
            return false;
        }

        boolean[] prev= new boolean[m+1];

        prev[0] = true;

        for(int i=0; i<=n; i++){

            boolean[] curr = new boolean[m+1];

            for(int j=0; j<=m; j++){

                if(i==0 && j==0){
                    curr[j] = true;
                    continue;
                }

                int k = i + j - 1;

                if(i>0 && s1.charAt(i-1) == s3.charAt(k)){
                    curr[j] = curr[j] || prev[j];
                }

                if(j>0 && s2.charAt(j-1) == s3.charAt(k)){
                    curr[j] = curr[j] || curr[j-1];
                }
            }

            prev = curr;
        }

        return prev[m];
    }
}