class Solution {
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] front = new int[cols][cols];

        for(int j1=0; j1<cols; j1++){
            for(int j2=0; j2<cols; j2++){

                if(j1==j2){
                    front[j1][j2] = grid[rows-1][j1];
                }
                else{
                    front[j1][j2] = grid[rows-1][j1] + grid[rows-1][j2];
                }
            }
        }

        for(int i=rows-2; i>=0; i--){

            int[][] curr = new int[cols][cols];

            for(int j1=0; j1<cols; j1++){
                for(int j2=0; j2<cols; j2++){
                    
                    int currentCherries;

                    if(j1==j2){
                        currentCherries = grid[i][j1];
                    }
                    else{
                        currentCherries = grid[i][j1] + grid[i][j2];
                    }

                    int maxCherries = Integer.MIN_VALUE;

                    for(int dj1=-1; dj1<=1; dj1++){
                        for(int dj2=-1; dj2<=1; dj2++){

                            int nextj1 = j1 + dj1;
                            int nextj2 = j2 + dj2;

                            int next;

                            if(nextj1 >= 0 && nextj1 < cols && nextj2 >= 0 && nextj2 < cols){

                                next = front[nextj1][nextj2];
                            }
                            else{
                                next = -1_000_000_000;
                            }

                            maxCherries = Math.max(maxCherries, currentCherries + next);
                        }
                    }

                    curr[j1][j2] = maxCherries;
                }
            }

            front = curr;
        }

        return front[0][cols-1];
    }
}