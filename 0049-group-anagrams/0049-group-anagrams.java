class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            int[] count = new int[26];

            for(char ch : str.toCharArray()){
                count[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int num : count){
                sb.append(num).append("#");
            }

            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}