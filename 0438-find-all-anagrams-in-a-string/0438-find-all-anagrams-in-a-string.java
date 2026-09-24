class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if(p.length() > s.length()){
            return result;
        }

        int[] pFreq = new int[26];
        int[] sFreq = new int[26];

        for(int i=0; i<p.length(); i++){
            pFreq[p.charAt(i) - 'a']++;
        }

        int left = 0;

        for(int right=0; right<s.length(); right++){
            sFreq[s.charAt(right) - 'a']++;

            if(right-left+1 > p.length()){
                sFreq[s.charAt(left) - 'a']--;
                left++;
            }

            if(right-left+1 == p.length() && Arrays.equals(pFreq, sFreq)){
                result.add(left);
            }
        }

        return result;
    }
}