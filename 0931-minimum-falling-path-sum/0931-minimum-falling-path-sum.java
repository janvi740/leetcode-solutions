class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[] prev = new int[n];

        for(int j=0; j<n; j++){
            prev[j] = matrix[0][j];
        }
        
        for(int i=1; i<n; i++){

            int[] curr = new int[n];

            for(int j=0; j<n; j++){

                int down = matrix[i][j] + prev[j];

                int dLeft = Integer.MAX_VALUE;
                if(j>0){
                    dLeft = matrix[i][j] + prev[j-1];
                }

                int dRight = Integer.MAX_VALUE;
                if(j<n-1){
                    dRight = matrix[i][j] + prev[j+1];
                }

                curr[j] = Math.min(down, Math.min(dLeft, dRight));

            }
            prev = curr;
        }

        int ans = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, prev[j]);
        }

        return ans;
    }
}