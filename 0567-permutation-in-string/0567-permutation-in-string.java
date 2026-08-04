class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Freq = new int[26];
        int[] winFreq = new int[26];

        for(int i=0; i<s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;
        }

        int left = 0;

        for(int right=0; right<s2.length(); right++){
            winFreq[s2.charAt(right) - 'a']++;

            if(right-left+1 > s1.length()){
                winFreq[s2.charAt(left) - 'a']--;
                left++;
            }

            if(matches(s1Freq, winFreq)){
                return true;
            }
        }
        return false;
    }

    public boolean matches(int[] arr1, int[] arr2){

        for(int i=0; i<26; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }

        return true;
    }
}