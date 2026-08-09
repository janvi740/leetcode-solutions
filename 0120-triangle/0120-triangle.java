class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] next = new int[n];
        
        for(int j=0; j<n; j++){
            next[j] = triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--){
            int[] curr = new int[n];

            for(int j=0; j<=i; j++){

                int down = next[j];
                int diagonal = next[j+1];

                curr[j] = triangle.get(i).get(j) + Math.min(down, diagonal);
            }

            next = curr;
        }

        return next[0];
    }
}