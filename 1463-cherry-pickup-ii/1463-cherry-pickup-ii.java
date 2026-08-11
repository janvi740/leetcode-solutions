class Solution {
    public int cherryPickup(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] next = new int[cols][cols];

        for(int j1=0; j1<cols; j1++){
            for(int j2=0; j2<cols; j2++){

                if(j1 == j2){
                    next[j1][j2] = grid[rows-1][j1];
                }
                else{
                    next[j1][j2] = grid[rows-1][j1] + grid[rows-1][j2];
                }
            }
        }

        for(int i=rows-2; i>=0; i--){

            int[][] curr = new int[cols][cols];

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

                                int nextStep = next[newJ1][newJ2];

                                max = Math.max(max, currentCherries + nextStep);
                            }
                        }
                    }

                    curr[j1][j2] = max;   
                }
            }

            next = curr;
        }

        return next[0][cols-1];
    }
}