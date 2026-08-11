class Solution {
    public int cherryPickup(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        for(int j1=0; j1<cols; j1++){
            for(int j2=0; j2<cols; j2++){

                if(j1 == j2){
                    dp[rows-1][j1][j2] = grid[rows-1][j1];
                }
                else{
                    dp[rows-1][j1][j2] = grid[rows-1][j1] + grid[rows-1][j2];
                }
            }
        }

        for(int i=rows-2; i>=0; i--){
            for(int j1=0; j1<cols; j1++){
                for(int j2=0; j2<cols; j2++){

                    int currentCherries;

                    if(j1 == j2){
                        currentCherries = grid[i][j1];
                    }else{
                        currentCherries = grid[i][j1] + grid[i][j2];
                    }

                    int max = Integer.MIN_VALUE;
                    
                    for(int dj1=-1; dj1<=1; dj1++){
                        for(int dj2=-1; dj2<=1; dj2++){

                            int newJ1 = j1 + dj1;
                            int newJ2 = j2 + dj2;

                            if(newJ1>=0 && newJ1<cols && newJ2>=0 && newJ2<cols){

                                int next = dp[i+1][newJ1][newJ2];

                                max = Math.max(max, currentCherries + next);
                            }
                        }
                    }

                    dp[i][j1][j2] = max;   
                }
            }
        }

        return dp[0][0][cols-1];
    }
}