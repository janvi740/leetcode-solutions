class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        backtrack(0, s, current, result);

        return result;
    }

    public void backtrack(int start, String s, List<String> current, List<List<String>> result){

        // Base case:
        // We have partitioned the entire string
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int end=start; end<s.length(); end++){

            if(isPalindrome(s, start, end)){
                //choose
                current.add(s.substring(start, end+1));

                //explore
                backtrack(end+1, s, current, result);

                //undo
                current.remove(current.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int left, int right){

        while(left < right){

            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}