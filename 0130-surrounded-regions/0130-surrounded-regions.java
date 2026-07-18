class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r=0; r<rows; r++){

            if(board[r][0]=='O'){
                dfs(r, 0, board);
            }

            if(board[r][cols-1]=='O'){
                dfs(r, cols-1, board);
            }
        }

        for(int c=0; c<cols; c++){

            if(board[0][c]=='O'){
                dfs(0, c, board);
            }

            if(board[rows-1][c]=='O'){
                dfs(rows-1, c, board);
            }
        }

        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){

                if(board[r][c]=='O'){
                    board[r][c] = 'X';
                }
                else if(board[r][c]=='#'){
                    board[r][c] = 'O';
                }
            }
        }
    }

    public void dfs(int row, int col, char[][] board){
        int rows = board.length;
        int cols = board[0].length;

        if(row<0 || row>=rows || col<0 || col>=cols || board[row][col]!='O'){
            return;
        }
        
        board[row][col] = '#';

        dfs(row-1, col, board);
        dfs(row+1, col, board);
        dfs(row, col+1, board);
        dfs(row, col-1, board);
    }
}