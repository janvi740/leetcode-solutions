class Solution {

    private int maxStart = 0;
    private int maxLen = 0;

    public String longestPalindrome(String s) {
        
        int n = s.length();

        for(int i=0; i<n; i++){

            //odd length
            expand(s, i, i);

            //even Length
            expand(s, i, i+1);
        }

        return s.substring(maxStart, maxStart + maxLen);
    }

    public void expand(String s, int left, int right){

        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){

            int currLen = right-left+1;

            if(currLen > maxLen){
                maxLen = currLen;
                maxStart = left;
            }

            left--;
            right++;
        }
    }
}