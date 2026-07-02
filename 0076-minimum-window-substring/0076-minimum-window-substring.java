class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }

        int[] freq = new int[128];

        for(char ch : t.toCharArray()){
            freq[ch]++;
        }

        int left = 0;
        int count = t.length();
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        for(int right=0; right<s.length(); right++){
            char rch = s.charAt(right);

            if(freq[rch] > 0){
                count--;
            }
            freq[rch]--;

            while(count==0){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }

                char lch = s.charAt(left);

                freq[lch]++;

                if(freq[lch]>0){
                    count++;
                }
                left++;
            }
        }

        if(minLen == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(start, start+minLen);
    }
}