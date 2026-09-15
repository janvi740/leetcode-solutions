class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }

        solve(0, board, ans);

        return ans;
    }

    public void solve(int row, char[][] board, List<List<String>> ans){

        if(row == board.length){
            ans.add(construct(board));
            return;
        }

        for(int col=0; col<board.length; col++){

            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                solve(row+1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board){

        for(int i=0; i<row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        int maxLeft = Math.min(row, col);
        for(int i=1; i<=maxLeft; i++){
            if(board[row-i][col-i] == 'Q'){
                return false;
            }
        }

        int maxRight = Math.min(row, board.length-col-1);
        for(int i=1; i<=maxRight; i++){
            if(board[row-i][col+i] == 'Q'){
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();

        for(int i=0; i<board.length; i++){
            res.add(new String(board[i]));
        }

        return res;
    }
}