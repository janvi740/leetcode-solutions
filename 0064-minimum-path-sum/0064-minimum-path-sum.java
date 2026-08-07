class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] next = new int[n];

        next[n-1] = grid[m-1][n-1];

        for(int i=m-1; i>=0; i--){

            int[] curr = new int[n];

            for(int j=n-1; j>=0; j--){

                if(i == m-1 && j == n-1){
                    curr[j] = grid[i][j];
                    continue;
                }

                int down = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;

                if(i + 1 < m){
                    down = grid[i][j] + next[j];
                }
                if(j + 1 < n){
                    right = grid[i][j] + curr[j+1];
                }

                curr[j] = Math.min(down, right);
            }
            next = curr;
        }

        return next[0];
    }
}