class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        backtrack(0, 0, current, n, result);

        return result;
    }

    public void backtrack(int open, int close, StringBuilder current, int n, List<String> result){

        if(open == n && close == n){
            result.add(current.toString());
            return;
        }

        if(open < n){
            current.append('(');

            backtrack(open+1, close, current, n, result);

            current.deleteCharAt(current.length() - 1);
        }

        if(close < open){
            current.append(')');

            backtrack(open, close+1, current, n, result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}